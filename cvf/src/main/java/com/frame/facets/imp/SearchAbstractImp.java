package com.frame.facets.imp;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import com.frame.facets.SearchEtl;

public abstract class SearchAbstractImp implements SearchEtl{
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
}
