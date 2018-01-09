package com.shr.tool;

import com.shr.model.Video;

/**
 * @author 孙浩然
 * 用于处理flv视频，进行流化。
 */
public interface yamdi extends VideoTool{
	public String hint(Video video);
}
