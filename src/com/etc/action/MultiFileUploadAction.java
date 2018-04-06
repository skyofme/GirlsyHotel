package com.etc.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.etc.bean.RoomType;
import com.etc.biz.RoomTypeIBiz;
import com.etc.biz.impl.RoomTypeIBizImpl;
import com.etc.dao.RoomTypeDao;
import com.opensymphony.xwork2.ActionSupport;

public class MultiFileUploadAction extends ActionSupport {
	// 获取提交的多个文件
	private List<File> upload = new ArrayList<File>();
	// 封装上传文件的类型
	private List<String> uploadContentType = new ArrayList<String>();;
	// 封装上传文件名称
	private List<String> uploadFileName = new ArrayList<String>();
	// 获取文件上传的路径
	private String savePath;// 目标目录
	private String[] targetfilename;// 目标文件名
	private String[] imgsArry;// 目标文件名
	private RoomTypeIBiz rtbiz;
	//添加房间类型(添加房间类型图片)
	public String add() throws IOException  {
		// 保存路径
		String realPath = this.getSavePath();
		// 设置目标文件名
		targetfilename = new String[upload.size()];
		if (upload != null) {
			String imgs = "";
			//先查出最大roomtypeid的房间
			System.out.println("==================");
			int MaxIdRt=rtbiz.getRtByMaxId();
			System.out.println("最大值========"+MaxIdRt);
			for (int i = 0; i < targetfilename.length; i++) {
				//图片路径	
				imgs += new String(((MaxIdRt+1)+"__" + i + "__" + ".jpg" + " ").getBytes("ISO-8859-1"),"UTF-8");
				//重命名上传文件
				String filename=uploadFileName.get(i);
				int position = filename.lastIndexOf(".");
				//为了得到文件的后缀
				String ext = filename.substring(position);
				filename=(MaxIdRt+1)+"__" + i + "__" +ext;
				targetfilename[i] = filename;
				// 建立一个文件
				File target = new File(realPath, targetfilename[i]);
				FileUtils.copyFile(upload.get(i), target);
			}
			RoomType rt=new RoomType();
			rt.setRmTpPic(imgs);
			rt.setRmTpId(MaxIdRt+1);
			rtbiz.addRoomType(rt);
		}
		int MaxIdRt1=rtbiz.getRtByMaxId();
		RoomType rt1=rtbiz.getRoomTypeById(MaxIdRt1);
		imgsArry = new String[5];
	    imgsArry = rt1.getRmTpPic().split(" ");
		return "success";
	}
	
	//修改房间类型(修改房间类型图片)
	public String update() throws IOException  {
			// 保存路径
			String realPath = this.getSavePath();
			// 设置目标文件名
			targetfilename = new String[upload.size()];
			//先查出要修改的房間id
			int id=1;//其實這個id是要修改的那個類的id
			RoomType rt=new RoomType();//其實這個rt是要修改的那個rt
			if (upload != null) {
				String imgs = "";
				for (int i = 0; i < targetfilename.length; i++) {
					//图片路径	
					imgs += new String((id+"__" + i + "__" + ".jpg" + " ").getBytes("ISO-8859-1"),"UTF-8");
					//重命名上传文件
					String filename=uploadFileName.get(i);
					int position = filename.lastIndexOf(".");
					//为了得到文件的后缀
					String ext = filename.substring(position);
					filename=id+"__" + i + "__" +ext;
					targetfilename[i] = filename;
					// 建立一个文件
					File target = new File(realPath, targetfilename[i]);
					FileUtils.copyFile(upload.get(i), target);
				}
				rt.setRmTpPic("");//将pic的信息先清空
				rt.setRmTpPic(imgs);
				rtbiz.updateOrAddRoomType(rt);
			}
			RoomType rt1=rtbiz.getRoomTypeById(id);
			imgsArry = new String[5];
		    imgsArry = rt1.getRmTpPic().split(" ");
			return "success";
			

		}

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String[] getTargetfilename() {
		return targetfilename;
	}

	public void setTargetfilename(String[] targetfilename) {
		this.targetfilename = targetfilename;
	}
	public String[] getImgsArry() {
		return imgsArry;
	}

	public void setImgsArry(String[] imgsArry) {
		this.imgsArry = imgsArry;
	}

	public RoomTypeIBiz getRtbiz() {
		return rtbiz;
	}

	public void setRtbiz(RoomTypeIBiz rtbiz) {
		this.rtbiz = rtbiz;
	}

}
