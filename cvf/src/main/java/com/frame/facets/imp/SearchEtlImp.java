package com.frame.facets.imp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.TrackingIndexWriter;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MultiPhraseQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockFactory;
import org.apache.lucene.store.SimpleFSLockFactory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.utils.FileUtils;
@Service("searchEtlImp")
public class SearchEtlImp extends SearchAbstractImp{
	public static final String DirectoryPath = "D:\\temp\\hotle\\";
	@Qualifier("mysqlDataSource")
	@Autowired
	private DataSource mysqlDataSource;
	/**
	 * 对文本文件进行数据索引
	 * @return
	 */
	public String startCreateDataIndex() {
		// 搜素开始时间
		Date beginTime = new Date();
		IndexWriter indexWriter = null;
		Directory directory = null;
		LockFactory lockFactory = null;
		File file = new File("D://temp/text//");
		if (!file.exists()) {
			file.mkdirs();
		}
		lockFactory = new SimpleFSLockFactory(file);
		try {
			directory = FSDirectory.open(file, lockFactory);
			Analyzer analyzer = new StandardAnalyzer();
			IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_4, analyzer);
			config.setOpenMode(OpenMode.CREATE_OR_APPEND);
			config.setMaxBufferedDocs(100);
			indexWriter = new IndexWriter(directory, config);
			// 获取文件 文本 路径创建索引
			File textFile = new File(DirectoryPath);
			File[] files = textFile.listFiles();
			// 遍历数组
			for (int i = 0; i < files.length; i++) {
				// 获取文件名
				String fileName = files[i].getName();
				// 判断是否为txt文件
				if (fileName.substring(fileName.lastIndexOf(".")).equals(".txt")) {
					// 创建一个新的Document
					Document doc = new Document();
					// 为文件名创建一个新的Document
					Field field = new StringField("filename", files[i].getName(),Field.Store.YES);
					doc.add(field);
					// 为文件内容创建一个Field
					Field content = new TextField("content", FileUtils.readTextAllContent(files[i]), Store.NO);
					doc.add(content);
					// 把Document加入IndexWriter
					indexWriter.addDocument(doc);
				}
			}
			indexWriter.commit();
			indexWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (indexWriter != null) {
				try {
					indexWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// 搜索完成时间
		Date endTime = new Date();
		return endTime.toString()+"-"+beginTime.toString();
	}
	/**
	 * post数据进行索引
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public String postDataChange() throws SQLException, ClassNotFoundException,IOException {
		// 搜素开始时间
		Date beginTime = new Date();
		String sql = "select * from post";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = mysqlDataSource.getConnection();
		
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
		preparedStatement.setFetchSize(Integer.MIN_VALUE);
		preparedStatement.setFetchDirection(ResultSet.FETCH_REVERSE);
		resultSet = preparedStatement.executeQuery();
		
		
		File file = new File("D:\\temp\\post\\");
		if (!file.exists()) {
			file.mkdirs();
		}
		FSDirectory directory = null;
		IndexWriter writer = null;
		try {
			directory = FSDirectory.open(file);
			Analyzer analyzer = new StandardAnalyzer();
			IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_4_10_4, analyzer);
			conf.setOpenMode(OpenMode.CREATE_OR_APPEND);
			conf.setMaxBufferedDocs(100);
			writer = new IndexWriter(directory, conf);
			long count = 1;
			while (resultSet.next()) {
				Document document = new Document();
				document.add(new StringField("id", resultSet.getString("id"),Store.YES));
				document.add(new StringField("postNumber", resultSet.getString("postNumber"),Store.YES));
				document.add(new StringField("province", resultSet.getString("province"),Store.YES));
				writer.addDocument(document);
				count++;
			}
			System.out.println("Total record : " + count);
			writer.close();
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (CorruptIndexException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 搜索完成时间
		Date endTime = new Date();
		return endTime.toString() +"-"+beginTime.toString();
	}
	
	/**
	 * 使用数据库数据进行数据转换
	 * */
	public String startDataChange() throws SQLException, ClassNotFoundException,IOException {
		// 搜素开始时间
		Date beginTime = new Date();
		String sql = "select name,Address from hotle";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = mysqlDataSource.getConnection();
		
		preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
		preparedStatement.setFetchSize(Integer.MIN_VALUE);
		preparedStatement.setFetchDirection(ResultSet.FETCH_REVERSE);
		resultSet = preparedStatement.executeQuery();
		
		IndexWriter writer = null;
		Directory directory = null;
		try {
			File file = new File("D://temp/hotle//");
			if (!file.exists()) {
				file.mkdirs();
			}
			directory = FSDirectory.open(file);
			Analyzer analyzer = new StandardAnalyzer();
			IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_4_10_4, analyzer);
			conf.setOpenMode(OpenMode.CREATE_OR_APPEND);
			conf.setMaxBufferedDocs(100);
			writer = new IndexWriter(directory, conf);
			long count = 1;
			while (resultSet.next()) {
				Document document = new Document();
				document.add(new StringField("Address", resultSet.getString("Address"), Store.YES));
				Field field = new StringField("name", resultSet.getString("name"), Store.YES);
				document.add(field);
				writer.addDocument(document);
				count++;
			}
			writer.commit();
			System.out.println("Total record : " + count);
			writer.close();
			resultSet.close();
			preparedStatement.close();
			connection.close();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (CorruptIndexException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (null!=resultSet) {
				resultSet.close();
			}
			if (null!=preparedStatement) {
				preparedStatement.close();
			}
			if (null!=connection) {
				connection.close();
			}
		}
		// 搜索完成时间
		Date endTime = new Date();
		return endTime.toString() +"-"+beginTime.toString();
	}
	

	public void StringSearch(String keyword, String searchPath) {
		System.out.println("----------------------使用字符串匹配方式搜索---------------------");

		File filePath = new File(searchPath);

		// 返回目录文件夹下所有文件数组
		File[] files = filePath.listFiles();

		// HashMap保存文件名和匹配次数对
		Map<String, Object> map = new LinkedHashMap<String, Object>();

		// 搜索开始时间
		Date beginTime = new Date();

		// 遍历所有文件
		for (int i = 0; i < files.length; i++) {
			// 初始化匹配次数
			int hits = 0;

			try {

				// 读取文件内容
				BufferedReader reader = new BufferedReader(new FileReader(
						files[i]));
				StringBuffer buffer = new StringBuffer();
				String line = null;
				while ((line = reader.readLine()) != null) {
					buffer.append(line);
				}
				reader.close();

				// 将StringBuffer转换成String,以便于搜索
				String fileToSearchString = buffer.toString();

				// 初始化fromIndex
				int fromIndex = -keyword.length();

				// 逐个匹配关键词
				while ((fromIndex = fileToSearchString.indexOf(keyword,
						fromIndex + keyword.length())) != -1) {
					hits++;
				}

				// 将文件名和匹配次数加入HashMap.
				map.put(files[i].getName(), new Integer(hits));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}// end for

		Iterator<String> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String fileName = iter.next();
			Integer hits = (Integer) map.get(fileName);
			System.out.println("find " + hits.intValue() + " matches in "
					+ fileName);
		}

		// 结束时间
		Date endTime = new Date();

		// 得到搜索耗费时间
		long timeOfSearch = endTime.getTime() - beginTime.getTime();

		System.out.println("使用字符串匹配方式总耗时" + timeOfSearch + "ms");
	}
	@Override
	public void doSearch(IndexSearcher indexSearcher) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Document abstractUpdate(TrackingIndexWriter trackingIndexWriter) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<JSONObject> queryMatchSuitValue(String search) {
		List<JSONObject> list = new ArrayList<JSONObject>();
		try {
			// 根据索引位置建立IndexSearch
			Directory directory = FSDirectory.open(new File(DirectoryPath));
			IndexReader reader = DirectoryReader.open(directory);
			IndexSearcher indexSearcher = new IndexSearcher(reader);
			
			// 建立搜索单元,searchType代表要搜索的Filed,searchType代表关键字
			String fields[] = {"name","Address"};
			Analyzer analyzer = new StandardAnalyzer();
			QueryParser queryParser  = new MultiFieldQueryParser(fields, analyzer); 
			//定义查询表达式
			Query query = queryParser.parse(search);
			//Query query = queryParser.parse("name:"+search+"");
			TopDocs topDocs = indexSearcher.search(query, 100);
			for (ScoreDoc sd : topDocs.scoreDocs) {
				Document doc = indexSearcher.doc(sd.doc);
				JSONObject object = new JSONObject();
				object.put("name", doc.get("name"));
				object.put("Address", doc.get("Address"));
				list.add(object);
			}
			System.out.println("查询条数:"+topDocs.totalHits);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


}
