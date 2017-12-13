package com.shr.tool.impl;

import com.shr.model.Video;

public class mp4box implements com.shr.tool.mp4box{

	public static final String Root = "MP4BOX";
	
	@Override
	public String hint(Video video) {
		String cmd = "mp4box -hint " + video.getFileUrl();
		
		return cmd;
	}

}
