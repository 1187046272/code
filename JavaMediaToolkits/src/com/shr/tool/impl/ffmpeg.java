package com.shr.tool.impl;

import com.shr.model.Image;
import com.shr.model.Video;
import com.shr.utils.StringUtil;

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
public class ffmpeg implements com.shr.tool.ffmpeg{
	
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
	//ffmpeg -ss 0 -t 00:00:05 -i 3.mp4 -vcodec copy -acodec copy out-1.mp4
	public String slice(Video video, int st, int et,Video dest_video) {
		String cmd = "ffmpeg ";
		
		cmd += "-ss ";
		cmd += StringUtil.IntToTime(st) + " -t ";
		cmd += StringUtil.IntToTime(et) + " -i ";
		cmd += video.getFileUrl() + " -vcodec copy -acodec copy -y ";
		cmd += dest_video.getFileUrl();
		
		System.out.println("命令："+cmd);
		return cmd;
	}

	//ffmpeg -ss 0 -t 3 -i D:\4.mp4 -s 320x240 -f gif -r 1 D:\b.gif
	@Override
	public String subGif(Video video, int start, int len,Image img) {
		String cmd = "ffmpeg -ss ";
		cmd += start + " ";
		cmd += "-t " + len + " -i ";
		cmd += video.getFileUrl() +" ";
		
		if(img.getWidth() > 0 && img.getHeight() > 0){
			cmd += "-s " + img.getWidth() + "x"+img.getHeight();
		}
				
		cmd += " -f gif -r 1 -y ";
		cmd += img.getUrl() + " ";
		
		System.out.println("生成命令" + cmd);
		
		return cmd;
	}

	//ffmpeg -i test.flv -y -f mjpeg -ss 3 -t 0.001 -s 320x240 test.jpg
	@Override
	public String thumb(Video video,int start, Image img) {
		String cmd = "ffmpeg -i ";
		cmd += video.getFileUrl() + " ";
		cmd += "-y -f mjpeg -ss ";
		cmd += start + " ";
		cmd += "-t 0.001 ";
		
		if(img.getWidth() > 0 && img.getHeight() > 0){
			cmd += "-s " + img.getWidth() + "x"+img.getHeight();
		}
		
		cmd += " " + img.getUrl();
		
		System.out.println("命令：" + cmd);
		return cmd;
	}
	
	
	
}
