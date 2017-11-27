package com.easy.pojos;

import java.util.List;
import java.util.Map;

public class PagerBean {

	private int page;//当前的页数
	private int nums;//每页显示的行数
	private int index;//分页开始行数（数据库的下标）
	private int total;//满足条件的总行数
	private int totalPage;//总页数
	private List<?> rows;//满足条件的具体的数据
	private Map params;//查询条件
	public PagerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PagerBean(int page, int nums, Map params) {
		super();
		this.page = page;
		this.nums = nums;
		this.params = params;
		
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	public int getIndex() {
		index = (page - 1) * nums;
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		totalPage = (total % nums == 0) ? (total / nums) : (total / nums + 1);
		this.total = total;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public Map getParams() {
		return params;
	}
	public void setParams(Map params) {
		this.params = params;
	}
	@Override
	public String toString() {
		return "PagerBean [page=" + page + ", nums=" + nums + ", index=" + index + ", total=" + total + ", totalPage="
				+ totalPage + ", rows=" + rows + ", params=" + params + "]";
	}
}
