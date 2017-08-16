package com.shr.action;

import java.util.List;

import com.shr.model.Task;
import com.shr.model.Video;

public interface VideoInterface {
	//转码
	public void encode(Task task);
	//获取视频基本信息
	public Video getInfo(Task task);
	//流化处理，只支持flv和mp4
	public void hint(Task task);
	//视频剪切
	public List<Video> slice(Task task);
	//视频连接
	public Video concat(Task task);
	//水印
	public Video waterPrint(Task task);
	//画中画
	public Video vInv(Task task);
	
	
}
