package com.shr.tool;

import com.shr.model.Video;

/**
 * @author 孙浩然
 * 视频处理命令字符串生成类 顶层接口，代表一个视频处理第三方工具
 */
public interface VideoTool extends Tool{
	public String encode(Video res_video,Video dest_video);
	public String getVideoInfo(Video video);
}
