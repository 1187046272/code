package com.shr.tool.impl;

import com.shr.model.Video;
import com.shr.utils.StringUtil;

/**
 * @author 孙浩然
 * 生成flv序列化命令
 */
public class yamdi implements com.shr.tool.yamdi{
	public static final String Root = "YAMDI";

	@Override
	public String hint(Video video) {
		String cmd = "yamdi -i " + video.getFileUrl() + " -o " + StringUtil.getDirectory(video.getFileUrl()) + "temp_" + video.getFileName();
		System.out.println("生成命令:" + cmd);
		return cmd;
	}
	
}
