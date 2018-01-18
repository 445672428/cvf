package others.demo.lucene;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MultiPhraseQuery;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.data.MysqlDBUtils;

public class LuceneDemo {
	public static void main(String[] args) throws Exception {
		 //test2();
		//searchByTerm("name", "李");
		test3();
	}

	public static void test3() throws ParseException {
		 //1、创建QueryParser对象,默认搜索域为content
        QueryParser parser = new QueryParser( "name", new StandardAnalyzer());
        //改变空格的默认操作符，以下可以改成AND
        //parser.setDefaultOperator(Operator.AND);
        //开启第一个字符的通配符匹配，默认关闭因为效率不高
        //parser.setAllowLeadingWildcard(true);
        //搜索content中包含有like的
        
        Query query = parser.parse("name:波~");
        Term term = new Term("name","波");
        Query query2 = new FuzzyQuery(term);
        Query query3 = new MultiPhraseQuery();
        //有basketball或者football的，空格默认就是OR
        //query = parser.parse("basketball football");
        Term term1=new Term("name", "波");
        Query query4=new TermQuery(term1);
        
        
        Term t = new Term("name", "*波*");
        WildcardQuery query5 = new WildcardQuery(t);
        //短语搜索
        PhraseQuery phrasequery=new PhraseQuery(); 
        phrasequery.setSlop(100); 
        phrasequery.add(term); 
        //改变搜索域为name为mike
        //query = parser.parse("content:like");
        //多短语搜索
        MultiPhraseQuery multiPhraseQuery=new MultiPhraseQuery();
        multiPhraseQuery.add(term);
        multiPhraseQuery.add(new Term[]{term1});
        //模糊搜索
        FuzzyQuery fuzzyquery=new FuzzyQuery(term1); 
        //同样可以使用*和?来进行通配符匹配
//        query = parser.parse("name:j*");
        
        //query = parser.parse("email:*@itat.org");
        
        //匹配name中没有mike但是content中必须有pingpeng的，+和-要放置到域说明前面
        //query = parser.parse("-name:mike +like +pingpeng");
        
        //匹配一个区间，注意:TO必须是大写
        //query = parser.parse("id:[1 TO 6]");
        
        //闭区间匹配只会匹配到2
        //query = parser.parse("id:{1 TO 3}");
        
        //完全匹配I Like Football的
        //query = parser.parse("\"I like football\"");
        
        //匹配I 和football之间有一个单词距离的
        //query = parser.parse("\"I football\"~1");
        
        //模糊查询
        //query = parser.parse("name:make~");
        
        //没有办法匹配数字范围（自己扩展Parser）
        //query = parser.parse("attach:[2 TO 10]");
        searchByQueryParse(query3, Integer.MAX_VALUE);
	}

	public static void searchByQueryParse(Query query, int num) {
		try {
			IndexSearcher searcher = getSearch();
			TopDocs tds = searcher.search(query, num);
			System.out.println("一共查询了:" + tds.totalHits);
			for (ScoreDoc sd : tds.scoreDocs) {
				Document doc = searcher.doc(sd.doc);
			}
		} catch (CorruptIndexException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void searchByTerm(String field, String name) {
		IndexSearcher indexSearcher = null;
		Query query = new TermQuery(new Term(field, name));
		try {
			indexSearcher = getSearch();
			TopDocs docs = indexSearcher.search(query, Integer.MAX_VALUE);
			System.out.println("count:" + docs.totalHits);
			for (ScoreDoc sd : docs.scoreDocs) {
				Document doc = indexSearcher.doc(sd.doc);
				/*
				 * System.out.println("name:"+doc.get("name"));
				 * System.out.println("Address:"+doc.get("Address"));
				 * System.out.println("nation:"+doc.get("nation"));
				 * System.out.println("education:"+doc.get("education"));
				 * System.out.println("company:"+doc.get("company"));
				 * System.out.println("family:"+doc.get("family"));
				 */
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static IndexSearcher getSearch() {
		IndexReader indexReader = null;
		Directory directory = null;
		IndexSearcher searcher = null;
		File file = new File("D:\\temp\\post\\");
		try {
			directory = FSDirectory.open(file);
			indexReader = DirectoryReader.open(directory);
			searcher = new IndexSearcher(indexReader);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return searcher;
	}

	public static void test2() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		IndexWriter indexWriter = null;
		String sql = "select name,Address,mobile,tel,company from hotle";
		File file = new File("D:\\temp\\post\\");
		Directory directory = null;
		int count = 0;
		try {
			connection = MysqlDBUtils.getConnection();
			preparedStatement = (PreparedStatement) connection
					.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,
							ResultSet.CONCUR_READ_ONLY);
			preparedStatement.setFetchSize(Integer.MIN_VALUE);
			preparedStatement.setFetchDirection(ResultSet.FETCH_REVERSE);
			resultSet = preparedStatement.executeQuery();

			directory = FSDirectory.open(file);// 创建一个文档
			Version Lucene_Version = Version.LUCENE_4_10_4;
			Analyzer analyzer = new StandardAnalyzer();
			IndexWriterConfig config = new IndexWriterConfig(Lucene_Version,
					analyzer);
			config.setOpenMode(OpenMode.CREATE_OR_APPEND);
			config.setMaxBufferedDocs(100);
			indexWriter = new IndexWriter(directory, config);
			while (resultSet.next()) {
				Document document = new Document();
				document.add(new StringField("name", resultSet
						.getString("name"), Store.YES));
				document.add(new StringField("Address", resultSet
						.getString("Address"), Store.YES));
				document.add(new StringField("mobile", resultSet
						.getString("mobile"), Store.YES));
				document.add(new StringField("tel", resultSet.getString("tel"),
						Store.YES));
				document.add(new StringField("company", resultSet
						.getString("company"), Store.YES));
				indexWriter.addDocument(document);
				count ++;
			}
			indexWriter.commit();
			System.out.println("总数:"+count);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (indexWriter != null) {
				try {
					indexWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void test1() {
		Connection con = null;
		PreparedStatement ps = null;
		Statement st = null;
		ResultSet rs = null;
		long count = 0;
		String sql = "select name,Address,Dirty,mobile,tel,eMail,nation,education,company,family from hotle";
		try {
			con = MysqlDBUtils.getConnection();
			ps = (PreparedStatement) con.prepareStatement(sql,
					ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ps.setFetchSize(Integer.MIN_VALUE);
			ps.setFetchDirection(ResultSet.FETCH_REVERSE);
			rs = ps.executeQuery();
			while (rs.next()) {
				// 此处处理业务逻辑
				count++;
				if (count % 600000 == 0) {
					System.out.println(" 写入到第  " + (count / 600000) + " 个文件中！");
					long end = System.currentTimeMillis();
				}
			}
			System.out.println("取回数据量为  " + count + " 行！");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
