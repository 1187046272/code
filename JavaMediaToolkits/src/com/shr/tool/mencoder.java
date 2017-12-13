package com.shr.tool;

import com.shr.model.Video;

/**
 * @author 孙浩然
 * 生成mencoder命令，目前用于处理rm和rmvb格式视频
 */
public interface mencoder extends VideoTool{
	public String encode(Video res_video,Video dest_video);
	
}
