package com.shr.tool;

import com.shr.model.Image;
import com.shr.model.Video;

public interface ffmpeg  extends VideoTool{
	public String encode(Video res_video,Video dest_video);
	public String slice(Video video,int st,int et,Video dest_video);
	public String subGif(Video video,int start,int len,Image img);
	public String thumb(Video video,int start,Image img);
}
