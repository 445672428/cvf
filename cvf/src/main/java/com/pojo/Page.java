package com.pojo;


import java.util.List;

import javax.sql.DataSource;

public class Page<T> {
	// 下一页
	private int nextPage;
	private String sql;
	// 当前页
	private int currentPage;

	// 每页个个数
	private int pageSize;

	// 总条数
	private int totalCount;

	// 总页数
	private int pageCount;

	// 记录
	private List<T> results;
	
	private int first;// 首页索引
	private int last;// 尾页索引
	private int prev;// 上一页索引
	private int next;// 下一页索引
	private boolean firstPage;//是否是第一页
	private boolean lastPage;//是否是最后一页
	
	
	@Override
	public String toString() {
		return "PageResults{" +
				"nextPage=" + getNextPage() +
				", currentPage=" + getCurrentPage() +
				", pageSize=" + getPageSize() +
				", totalCount=" + getTotalCount() +
				", pageCount=" + getPageCount() +
				", results=" + getResults() +
				'}';
	}

	public Page(int nextPage, int currentPage, int pageSize, int totalCount, int pageCount, List<T> results) {
		this.nextPage = nextPage;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.pageCount = pageCount;
		this.results = results;
	}

	public Page() {}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getNextPage() {
		if (nextPage <= 0) {
			return 1;
		} else {
			if (nextPage > pageCount && pageCount != 0) {
				nextPage = pageCount;
			} else if (nextPage > pageCount && pageCount == 0) {
				nextPage = 1;
			}
			return nextPage;
		}
	}

	public void setNextPage(int nextPageNumber) {
		this.nextPage = nextPageNumber;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize <= 0 ? 10 : pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void resetPageNumber() {
		nextPage = currentPage + 1;
		pageCount = totalCount % pageSize == 0 ? totalCount / pageSize
				: totalCount / pageSize + 1;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getPrev() {
		return prev;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
}
