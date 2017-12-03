package com.shr.function;

import java.io.File;
import java.util.List;

import com.shr.exception.OptException;
import com.shr.model.Video;
import com.shr.tool.VideoTool;
import com.shr.tool.ffmpeg;
import com.shr.tool.mediaInfo;
import com.shr.tool.mencoder;
import com.shr.tool.mp4box;
import com.shr.utils.CmdUtil;
import com.shr.utils.Conf;
import com.shr.utils.StringUtil;

/**
 * @author 孙浩然
 * 视频处理功能实现类
 */
public class VideoFunction implements VideoInterface {

	@Override
	public Video encode(Video res_video,Video dest_video) {
		File video = new File(res_video.getFileUrl());
		if(!video.exists() || video.isDirectory()){
			System.out.println("文件是目录或者不存在！");
			return null;
		}
		
		VideoTool vtool = null;
		if(StringUtil.isRMVB(res_video.getFileUrl()) || StringUtil.isRMVB(dest_video.getFileUrl())){
			vtool = new mencoder();
		}else{
			vtool = new ffmpeg();
		}
		
		//构造命令对象
		String cmd = vtool.encode(res_video, dest_video);
		//执行命令并获得结果
		String result = "";
		try {
			result = CmdUtil.process(Conf.ToolDir, cmd, true);
		} catch (OptException e) {
			e.printStackTrace();
		}
		//解析命令
		System.out.println("解析命令\n"+result);
		//返回
		return dest_video;
	}

	@Override
	public Video getInfo(Video video) {
		File vf = new File(video.getFileUrl());
		if(!vf.exists() || vf.isDirectory()){
			System.out.println("文件是目录或者不存在！");
			return null;
		}
		
		VideoTool vtool = new mediaInfo();
		
		String cmd = vtool.getVideoInfo(video);
		
		String result = "";
		try {
			result = CmdUtil.process(Conf.ToolDir + mp4box.Root, cmd, true);
		} catch (OptException e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
		if(result.equals("")){
			System.out.println("解析失败");
			return null;
		}
		String[] items = result.trim().split("#");
		video.setVideoLong(Long.parseLong(items[0]));
		video.setWidth(Integer.parseInt(items[1]));
		video.setHeight(Integer.parseInt(items[2]));
		video.setFrameRate(Double.parseDouble(items[3]));
		video.setBitRate(Double.parseDouble(items[4])/8/1000);
		
		return video;
	}

	@Override
	public Video hint(Video video) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> slice(Video video) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Video concat(List<Video> videos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Video waterPrint(Video video) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void vInv() {
		// TODO Auto-generated method stub
		
	}
	
}
