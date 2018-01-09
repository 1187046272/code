package com.shr.tool;

import com.shr.model.Video;

/**
 * @author 孙浩然
 * 用于处理mp4视频，流化、拼接、切割。
 */
public interface mp4box  extends VideoTool{
	public String hint(Video video);
}
