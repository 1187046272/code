package com.shr.tool;

import com.shr.model.Video;

/*
主要参数：
-i 设定输入流
-f 设定输出格式
-ss 开始时间
视频参数：
-b 设定视频流量，默认为200Kbit/s
-r 设定帧速率，默认为25
-s 设定画面的宽与高
-aspect 设定画面的比例
-vn 不处理视频
-vcodec 设定视频编解码器，未设定时则使用与输入流相同的编解码器
音频参数：
-ar 设定采样率
-ac 设定声音的Channel数
-acodec 设定声音编解码器，未设定时则使用与输入流相同的编解码器
-an 不处理音频
 */

/**
 * @author 孙浩然
 * 生成ffmpeg命令字符串类
 */
public class ffmpeg implements VideoTool{
	
	public static final String Root = "FFMPEG";
	
	/*ffmpeg -i in.mp4 -vcodec h264 -b:v 256k -maxrate 300k -s 720*480 -y -movflags faststart out.mp4*/
	@Override
	public String encode(Video src_video,Video dest_video){
		String cmd = "ffmpeg";
		
		//设置输入
		if(src_video.getFileUrl() != null){
			cmd += " -i "+src_video.getFileUrl();
		}
		//设置音频编解码器
		if(src_video.isHasAudio()){
			if(src_video.getAcodec() != null){
				cmd += " -acodec "+src_video.getAcodec();
			}else{
				cmd += " -acodec copy";
			}
		}else{
			cmd += " -an";
		}
		//设置视频编解码器
		if(src_video.getVcodec() != null){
			cmd += "" + src_video.getVcodec();
		}else{
			cmd += " -vcodec copy";
		}
		//设置分辨率
		if(src_video.getWidth() != 0 && src_video.getHeight() != 0){
			cmd += " -s "+src_video.getWidth() + "*" + src_video.getHeight();
		}
		//帧率
		if(src_video.getFrameRate() != 0){
			cmd += " -r "+src_video.getFrameRate();
		}
		//比特率
		if(src_video.getBitRate() != 0){
			cmd += " -b " + src_video.getBitRate();
		}
		//设置是否hint
		if(src_video.isHint()){
			cmd += " -movflags faststart";
		}
		//设置文件覆盖
		cmd += " -y";
		//设置输出文件
		cmd += " " + dest_video.getFileUrl();
		
		System.out.println("命令：" + cmd);
		return cmd;
	}
	
	@Override
	public String getVideoInfo(Video video) {
		System.out.println("此方法未实现");
		return "";
	}
	
}
