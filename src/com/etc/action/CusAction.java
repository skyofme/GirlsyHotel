package com.etc.action;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.struts2.ServletActionContext;
import com.etc.bean.Cus;
import com.etc.bean.Ord;
import com.etc.bean.PageBean;
import com.etc.biz.CusIBiz;
import com.etc.biz.OrdIBiz;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CusAction extends ActionSupport{
	private CusIBiz cbiz;
	private OrdIBiz obiz;
	private Cus cus;
	private int cusId;
	private int start;// 第几页
	private int pageSize;// 显示的记录
	public OrdIBiz getObiz() {
		return obiz;
	}
	public void setObiz(OrdIBiz obiz) {
		this.obiz = obiz;
	}
	public Cus getCus() {
		return cus;
	}
	public void setCus(Cus cus) {
		this.cus = cus;
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public CusIBiz getCbiz() {
		return cbiz;
	}
	public void setCbiz(CusIBiz cbiz) {
		this.cbiz = cbiz;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String pageAll() throws Exception {
		// 根据总记录数 计算总页码
		//System.out.println("sfsdfsdfsfsdf");
		long row = cbiz.getCount();
		// 总页码
		long totalPage = (long) Math.ceil(row / (pageSize * 1.0));
		if (start <= 1) {
			start = 1;
		} else if (start >= totalPage) {
			start = (int) totalPage;
		}
		PageBean pb = new PageBean(start, pageSize);
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<Cus> clist = cbiz.getAllByPage(pb);
		session.setAttribute("clist", clist);
		return SUCCESS;
	}
	public String doDel() {		
		/*cbiz.deleteCus(cusId);
		return "Success";*/
/*		long row = obiz.getCount();
		// 总页码
		long totalPage = (long) Math.ceil(row / (pageSize * 1.0));
		if (start <= 1) {
			start = 1;
		} else if (start >= totalPage) {
			start = (int) totalPage;
		}
		PageBean pb = new PageBean(start, pageSize);*/
		List<Ord> olist=obiz.getOrd(cusId);
		if(olist.isEmpty()) {
			/*JOptionPane.showMessageDialog(null, "客户订单信息不为空，不允许删除", "标题",JOptionPane.WARNING_MESSAGE);*/
			int n=JOptionPane.showConfirmDialog(null, "是否确定删除？", "是否确定删除？", JOptionPane.YES_NO_OPTION);
			if(n==1) {				
			}else {
				//生成日志
				cbiz.doLog("删除", cbiz.getCusById(cusId));
				cbiz.deleteCus(cusId);
				
				}						
		}else {
			JOptionPane.showMessageDialog(null, "客户订单信息不为空，不允许删除！", "标题",JOptionPane.WARNING_MESSAGE);
			/*cbiz.deleteCus(cusId);*/
		}
		return "Success";
	}
	public String edit() {
		cus=cbiz.getCusById(cusId);	
		return "doedit";
	}
	public String doedit() {
		//生成日志
		cbiz.doLog("修改", cus);
		cbiz.updateOrAddCus(cus);
		//ActionContext cxt = ActionContext.getContext(); 
		HttpServletRequest request = ServletActionContext.getRequest();
		//request.setAttribute("init1", "<script>function init1(){document.getElementById('alluser').click();}</script>");	
		HttpSession session = request.getSession();
		session.setAttribute("init1", "<script>function init1(){document.getElementById('alluser').click();}</script>");
		return "editSuccess";
	}
	public String getInfo() {
		long row = obiz.getCount();
		// 总页码
		long totalPage = (long) Math.ceil(row / (pageSize * 1.0));
		if (start <= 1) {
			start = 1;
		} else if (start >= totalPage) {
			start = (int) totalPage;
		}
		PageBean pb = new PageBean(start, pageSize);
		
		HttpSession session = ServletActionContext.getRequest().getSession();		
		/*cus = cbiz.getCusById(cusId);
		Set<Ord> olist=cus.getOlist();*/

		List<Ord> olist=obiz.getOrdByPage(pb,cusId);
		for (Ord ord : olist) {
			ord.setTotalDay(ord.getTotalDay());
			ord.setTotalPrice(ord.getTotalPrice());
		/*int d = (int) ((ord.getOutDate().getTime() - ord.getInDate().getTime()) / 1000 / 60 / 60 / 24);
		ord.setTotalDay((int) (d));
		ord.setTotalPrice(d*ord.getRmDayPrice());
		System.out.println("======="+olist);*/		
		}
		
		session.setAttribute("olist",olist);
		return "cusInfo";
	}
}
