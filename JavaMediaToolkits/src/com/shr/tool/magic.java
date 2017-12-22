package com.shr.tool;

import com.shr.model.Image;

public interface magic extends ImageTool{
	public String encode(Image res_img,Image dest_img);
}
