package com.shr.tool;

import com.shr.model.Video;

/**
 * @author 孙浩然
 * 生成mencoder命令字符串的类
 * 暂时用来处理rm和rmvb类型的视频
 */
public class mencoder implements VideoTool{

	@Override
	public String encode(Video res_video, Video dest_video) {
		return null;
	}
	
	@Override
	public String getVideoInfo(Video video) {
		System.out.println("此方法未实现");
		return "";
	}
	
}
