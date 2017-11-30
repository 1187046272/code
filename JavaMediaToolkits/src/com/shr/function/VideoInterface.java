package com.shr.function;

import java.util.List;

import com.shr.model.Task;
import com.shr.model.Video;

public interface VideoInterface {
	//视频转码
	public void encode(Task task);
	//获取视频信息
	public Video getInfo(Task task);
	//flv和mp4流化。。。支持拖拽
	public void hint(Task task);
	//切片
	public List<Video> slice(Task task);
	//视频拼接
	public Video concat(Task task);
	//水印
	public Video waterPrint(Task task);
	//画中画
	public Video vInv(Task task);
	
	
}
