package com.shr.tool;

import java.util.List;

import com.shr.model.Image;
import com.shr.model.Point;

/**
 * @author 孙浩然
 * 用于生成基于imagemagic的图片处理命令。
 */
public interface magic extends ImageTool{
	public String encode(Image res_img,Image dest_img);
	public String scale(Image img, int width, int height);
	public String crop(Image res_img,Point point,Image dest_img);
	
	public String rotate(Image img,int d,Image dest);
	public String concat(List<Image> list,int style,Image dest_img);
	public String gray(Image res_img,Image dest_img);
	public String overlay(Image big,Image small,Point point,Image dest);
}
