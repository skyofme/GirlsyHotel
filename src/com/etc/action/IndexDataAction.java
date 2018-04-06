package com.etc.action;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.etc.bean.RoomType;
import com.etc.biz.RoomIBiz;
import com.etc.biz.RoomTypeIBiz;
import com.opensymphony.xwork2.ActionSupport;

public class IndexDataAction extends ActionSupport{
	private RoomIBiz rib;
	private RoomTypeIBiz rtib;

	public RoomTypeIBiz getRtib() {
		return rtib;
	}

	public void setRtib(RoomTypeIBiz rtib) {
		this.rtib = rtib;
	}

	public RoomIBiz getRib() {
		return rib;
	}

	public void setRib(RoomIBiz rib) {
		this.rib = rib;
	}

	@Override
	public String execute() throws Exception {
		//首页所需的LIST
		List<Map<String, String>> indexData = new ArrayList<>();
		//所有房间类型对象
		List<RoomType> rt= rtib.getAllRoomType();
		//所有类型String
		List<String> rmTypeList = new ArrayList<String>();
		for (RoomType r : rt) {
			rmTypeList.add(r.getRmTpName());
		}
		
		//房间总数
		List<Integer> roomtotal = new ArrayList<>();
		for (String r : rmTypeList) {
			roomtotal.add((int) rib.getCountByType(r));
		}
		
		//房间已住数量
		List<Integer> roomfull = new ArrayList<>();
		for (String r : rmTypeList) {
			roomfull.add((int) rib.getFullCountByType(r));
		}
		
		//把数据加到首页所需的LIST里面
		for (int i = 0 ;i<rmTypeList.size();i++) {
			Map<String, String> m = new HashMap<>();
			m.put("roomType", rmTypeList.get(i));
			if(0==roomfull.get(i)) {
				m.put("ratio", "0.00");
			}else {
				double p = roomfull.get(i)*1.0/roomtotal.get(i);
				DecimalFormat df = new DecimalFormat("###.00");   
				double tp = Double.parseDouble(df.format(p));
				m.put("ratio", tp+"");
			}
			m.put("index", (i+1)+"");
			indexData.add(m);
		}
		
		for (int i = 0 ;i<indexData.size();i++) {
			System.out.println("roomType"+indexData.get(i).get("roomType")+"ratio"+indexData.get(i).get("ratio"));
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("indexDate", indexData);
		return "success";
	}
	
}
