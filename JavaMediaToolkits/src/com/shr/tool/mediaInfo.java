package com.shr.tool;

import com.shr.model.Video;

public class mediaInfo implements VideoTool{

	public static final String Root = "MEDIAINFO";
	
	@Override
	public String getVideoInfo(Video video) {
		String url = video.getFileUrl().replace("//","\\");//mediainfo不能识别 '/'
		String cmd = "mediainfo --Output=Video;%Duration%#%Width%#%Height%#%FrameRate%#%BitRate% " + url;
		return cmd;
	}
	
	@Override
	public String encode(Video res_video, Video dest_video) {
		System.out.println("此方法暂未实现");
		return "";
	}
}
