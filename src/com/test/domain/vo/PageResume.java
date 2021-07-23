package com.test.domain.vo;

import java.util.ArrayList;
import java.util.List;

import com.test.biz.ResumeService;
import com.test.biz.impl.ResumeServiceImpl;
import com.test.domain.po.Resume;

public class PageResume {
	 private int curPage=1;//当前页数
	   private int rows=3; // 设置每页显示的记录条数
	   private int TotalPages;// 总页数
	   private List<Resume> pageDate=new ArrayList<Resume>();//每一页的数据记录集合
	   private boolean hasNextpage; //是否有下一页
	   private boolean hasPreviousPage;//是否有上一页
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getTotalPages() {
		ResumeService resumeService=new ResumeServiceImpl();
	       List<Resume> all=resumeService.findAll();
	       int count=all.size();
	       return (count+rows-1)/rows;
	}
	public void setTotalPages(int totalPages) {
		this.TotalPages = totalPages;
	}
	public List<Resume> getPageDate() {
		ResumeService resumeService=new ResumeServiceImpl();
		 List<Resume> all=resumeService.findAll();
	       List<Resume> res=new ArrayList<Resume>();
	        int start=(curPage-1)*rows;
	        int end=curPage*rows;
	        for(int i=start;i<end&&i<all.size();i++) {
	        	res.add(all.get(i));
	        }
	        return res;
	}
	public void setPageDate(List<Resume> pageDate) {
		this.pageDate = pageDate;
	}
	   public boolean isHasNextPage() {
		   return (this.getCurPage()<this.getTotalPages());
	   }
	   public boolean isHasPrevoiousPage() {
		   return (this.getCurPage()>1);
	   }
	   
}
