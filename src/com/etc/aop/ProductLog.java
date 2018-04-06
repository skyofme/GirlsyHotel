package com.etc.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;

import com.etc.bean.Emp;
import com.etc.bean.Log;
import com.etc.biz.LogIBiz;

public class ProductLog {
	private LogIBiz lib;
	
    public void after(JoinPoint joinpoint){  
    	System.out.println("doAOP成功啦");
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	Object[] obj = joinpoint.getArgs();  
        Log l = new Log();
        l.setEmp((Emp)session.getAttribute("login"));
        l.setOpe(obj[1]+"");
        l.setOpeTime(sdf.format(new Date()));
        lib.updateOrAddLog(l);
    }
	public LogIBiz getLib() {
		return lib;
	}
	public void setLib(LogIBiz lib) {
		this.lib = lib;
	} 
}
