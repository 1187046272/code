package com.shr.tool.impl;

import com.shr.model.Video;

/**
 * @author 孙浩然
 * 生成mediainfo命令
 */
public class mediaInfo implements com.shr.tool.mediaInfo{

	public static final String Root = "MEDIAINFO";
	
	@Override
	public String getVideoInfo(Video video) {
		String url = video.getFileUrl().replace("//","\\");//mediainfo不能识别 '/'
		String cmd = "mediainfo --Output=Video;%Duration%#%Width%#%Height%#%FrameRate%#%BitRate% " + url;
		return cmd;
	}

}
