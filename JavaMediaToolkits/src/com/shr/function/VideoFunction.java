package com.shr.function;

import java.io.File;
import java.util.List;

import com.shr.exception.OptException;
import com.shr.model.Image;
import com.shr.model.Video;
import com.shr.tool.impl.ffmpeg;
import com.shr.tool.impl.mediaInfo;
import com.shr.tool.impl.mencoder;
import com.shr.tool.impl.mp4box;
import com.shr.tool.impl.yamdi;
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
		if(!isFileOK(res_video.getFileUrl())){
			return null;
		}
		
		//构造命令对象
		String cmd = "";
		String root = "";
		if(StringUtil.isRMVB(res_video.getFileUrl()) || StringUtil.isRMVB(dest_video.getFileUrl())){
			mencoder vtool = new mencoder();
			cmd = vtool.encode(res_video, dest_video);
			root = "MENCODER";
		}else{
			ffmpeg vtool = new ffmpeg();
			cmd = vtool.encode(res_video, dest_video);
			root = "FFMPEG";
		}
		
		//执行命令并获得结果
		String result = "";
		try {
			result = CmdUtil.process(Conf.ToolDir + root, cmd, true);
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
		
		if(!isFileOK(video.getFileUrl())){
			return null;
		}
		
		mediaInfo vtool = new mediaInfo();
		
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
		video.setBitRate(Double.parseDouble(items[4])/8/1000);//转换成 kb/s
		
		return video;
	}

	@Override
	public Video hint(Video video) {
		
		if(!isFileOK(video.getFileUrl())){
			return null;
		}
		
		String cmd = "";
		String root = "";
		if("flv".equals(video.getVideoFormat())){
			yamdi vt = new yamdi();
			vt.hint(video);
			root = "YAMDI";
		}else if("mp4".equals(video.getVideoFormat())){
			mp4box vt = new mp4box();
			vt.hint(video);
			root = "MP4BOX";
		}else{
			System.out.println("只支持mp4和flv格式");
			return null;
		}
		
		String result = "";		
		try {
			result = CmdUtil.process(Conf.ToolDir + root, cmd, true);
		} catch (OptException e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
		
		if (root.equals("YAMDI")) {
			//先判断新文件是否生成成功
			File f = new File(StringUtil.getDirectory(video.getFileUrl()) + "temp_" + video.getFileName());
			if(f.exists() && f.length() > 0){
				//删除老文件。修改新文件
				File oldFile = new File(video.getFileUrl());
				oldFile.delete();
				f.renameTo(new File(video.getFileUrl()));
			}else{
				System.out.println("yamdi");
				return null;
			}
		}
		
		return video;
	}

	@Override
	public Video slice(Video video, int start, int end,Video dest_video) {
		
		ffmpeg vtool = new ffmpeg();
		String cmd = vtool.slice(video, start, end, dest_video);
		
		String result = "";		
		try {
			result = CmdUtil.process(Conf.ToolDir + ffmpeg.Root, cmd, true);
		} catch (OptException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		
		return dest_video;
	}

	@Override
	public Video subVideo(Video res_video, int start, int end,Video dest_video) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image subGif(Video res_video, int start, int end, Video dest_video) {
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
	
	public boolean isFileOK(String url){
		File vf = new File(url);
		if(!vf.exists() || vf.isDirectory()){
			System.out.println("文件是目录或者不存在！");
			return false;
		}else{
			System.out.println("文件存在，验证通过！");
			return true;
		}
	}
	
}
