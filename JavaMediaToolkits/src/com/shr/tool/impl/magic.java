package com.shr.tool.impl;

import com.shr.model.Image;

public class magic implements com.shr.tool.magic{

	public static final String Root = "IMAGEMAGIC";
	
	@Override
	public String encode(Image res_img, Image dest_img) {
		String cmd = "convert ";
		cmd += res_img.getUrl() + " " + dest_img.getUrl();
		
		System.out.println("命令：" + cmd);
		return cmd;
	}

}
