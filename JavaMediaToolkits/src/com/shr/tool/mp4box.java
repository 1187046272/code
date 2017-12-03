package com.shr.tool;

import com.shr.model.Video;

public class mp4box implements VideoTool{

	public static final String Root = "MP4BOX";
	
	@Override
	public String getVideoInfo(Video video) {
		System.out.println("此方法未实现");
		return "";
	}
	
	@Override
	public String encode(Video res_video, Video dest_video) {
		System.out.println("此方法未实行");
		return "";
	}

}
