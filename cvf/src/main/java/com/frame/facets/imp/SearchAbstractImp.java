package com.frame.facets.imp;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.TrackingIndexWriter;
import org.apache.lucene.search.ControlledRealTimeReopenThread;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ReferenceManager;
import org.apache.lucene.search.SearcherFactory;
import org.apache.lucene.search.SearcherManager;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.frame.facets.SearchEtl;

public abstract class SearchAbstractImp implements SearchEtl{
	protected static final Logger logger = LoggerFactory.getLogger(SearchAbstractImp.class);
	public static TrackingIndexWriter trackingIndexWriter = null;
	public static ReferenceManager<IndexSearcher> refManager = null;
	public static ControlledRealTimeReopenThread<IndexSearcher> crtThread = null;
	
	protected static Directory directory = null;
	protected static IndexWriter writer = null;
	@Override
	public <T> void startCreateDataIndex(T t){
		
	}
	@Override
	public <T> void deleteIndex(T t){
		
	}
	@Override
	public <T> void  updateIndex(T t){
		
	}
	@Override
	public Directory getDirectory() throws IOException{
		Directory directory = FSDirectory.open(new File(DirectoryPath));
		return directory;
	}
	
	protected void loadIndexWriterDaemon() throws IOException{
		String start = new Date().toString();
		directory = getDirectory();
		writer =  new IndexWriter(directory, new IndexWriterConfig(Lucene_Version, new StandardAnalyzer()));
		trackingIndexWriter = new TrackingIndexWriter(writer);
		refManager = new SearcherManager(writer, true, new SearcherFactory());
		/** 在0.025s~5.0s之间重启一次线程，这个是时间的最佳实践 **/
		crtThread = new ControlledRealTimeReopenThread<>(trackingIndexWriter,refManager, 5.0, 0.025);
		crtThread.setDaemon(true);// 设置为后台服务
		crtThread.setName("Index update to disk");// 线程名称
		crtThread.start();// 线程启动
		String end = new Date().toString();
		logger.info(start+end);
	}

	/**
	 * 查询
	 * 
	 * 查询时search如果使用完成，需要将search释放会searchFactory中，使用refManager.release(indexSearcher)
	 * 进行释放
	 * **/
	public void abstractSearch() {
		IndexSearcher indexSearcher = getSingleSearcher();
		try {
			doSearch(indexSearcher);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				refManager.release(indexSearcher);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	/*** 查询 **/
	public void query() {
		IndexSearcher indexSearcher = getSingleSearcher();
		try {
			// 通过reader可以有效的获取到文档的数量
			doSearch(indexSearcher);
			System.out.println("numDocs:" + indexSearcher.getIndexReader().numDocs());
			System.out.println("maxDocs:" + indexSearcher.getIndexReader().maxDoc());
			System.out.println("deleteDocs:"+ indexSearcher.getIndexReader().numDeletedDocs());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				refManager.release(indexSearcher);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 实现类做自己查询
	 * @param indexSearcher
	 */
	//TODO
	public abstract void doSearch(IndexSearcher indexSearcher);

	/**
	 * 删除 使用trackIndexWriter进行数据删除，也不需要关闭Writer
	 * **/
	public void delete() {
		try {
			trackingIndexWriter.deleteDocuments(new Term("id", "2"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改 使用trackIndexWriter进行修改，不需要关闭writer
	 * Lucene并没有提供更新，这里的更新操作其实是如下两个操作的合集 先删除之后再添加
	 * **/
	public void doUpdate() {
		try {
			abstractUpdate(trackingIndexWriter);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 更新需要更新的数据
	 * @param trackingIndexWriter
	 * @return
	 */
	public abstract Document abstractUpdate(TrackingIndexWriter trackingIndexWriter);

	/** 使用单例获取IndexSearch **/
	public IndexSearcher getSingleSearcher() {
		IndexSearcher indexSearcher = null;
		try {
			if (indexSearcher == null) {
				refManager.maybeRefresh();// 刷新reMgr,获取最新的IndexSearcher
				indexSearcher = refManager.acquire();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (indexSearcher == null) {
			throw new RuntimeException("indexSearcher is null!!!!");
		}
		return indexSearcher;
	}
	/**
	 * 关闭初始化线程的处理
	 */
	public void close() {
		crtThread.interrupt();
		crtThread.close();// close the indexWriter,commit 所有有过修改的内容
		try {
			writer.commit();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取IndexSearcher
	 * @return
	 * @throws IOException
	 */
	public IndexSearcher getSearcher() throws IOException {
		IndexReader reader = DirectoryReader.open(directory);
		IndexSearcher searcher = new IndexSearcher(reader);
		return searcher;
	}
}
