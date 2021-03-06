package com.shr.function;

import java.util.List;

import com.shr.model.Image;
import com.shr.model.Point;
import com.shr.model.Video;

/**
 * @author 孙浩然
 * 视频处理接口定义
 */
public interface VideoInterface {
	//视频转码
	public Video encode(Video res_video,Video dest_video);
	//获取视频信息
	public Video getInfo(Video video);
	//flv和mp4流化。。。支持拖拽
	public Video hint(Video video);
	//切片 - 按时间
	public Video slice(Video video,int start,int end,Video dest_video);
	//截取
	public Video subVideo(Video res_video,int start,int end,Video dest_video);
	//截取gif图片
	public Image subGif(Video res_video,int start,int end,Image img);
	//截取缩略图
	public Image thumb(Video res_video,int start,Image img);
	//视频拼接
	public Video concat(List<Video> videos);
	//水印
	public Video waterPrint(Video video,Image img,Point point,Video dest_video);
	//画中画
	public void vInv();
	
}
