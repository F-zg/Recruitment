package com.test.domain.vo;

import java.util.List;

public class Page {
	private int totalRows; // 总记录数
	private int totalPages; // 总页数
	private int currentPage; // 当前页数
	private int pageSize; // 每页显示的记录数
	private List<Object> data; // 每次查询显示在当前页面的数据集合

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
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
		this.pageSize = pageSize;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

	public Page() {
		super();
	}

	public int getTotalpage() {
		if (totalPages % totalRows != 0) {
			return (totalPages / totalRows) + 1;
		} else {
			return (totalPages / totalRows);
		}
	}

	public int getStartIndex() {
		return (currentPage - 1) * pageSize;
	}

	public int prev() {
		int num = currentPage - 1;
		if (num < 1)
			num = 1;
		return num;
	}

	public int next() {
		int num = currentPage + 1;

		if (num > this.getTotalPages()) {
			num = this.getTotalPages();
		}
		return num;
	}

}
