package com.shr.tool.impl;

import java.util.List;

import com.shr.model.Image;
import com.shr.model.Point;
import com.shr.utils.Conf;

public class magic implements com.shr.tool.magic{

	public static final String Root = "IMAGEMAGIC";
	
	@Override
	public String encode(Image res_img, Image dest_img) {
		String cmd = Conf.ToolDir + Root + "/convert ";
		cmd += res_img.getUrl() + " ";
		if(dest_img.getWidth() != 0 && dest_img.getHeight() != 0){
			cmd += "-resize " + dest_img.getWidth() + "x" + dest_img.getHeight() + "! "; 
		}
		cmd += dest_img.getUrl();
		
		System.out.println("命令：" + cmd);
		return cmd;
	}

	@Override
	public String scale(Image img, int width, int height) {
		String cmd = Conf.ToolDir + Root + "/convert ";
		cmd += img.getUrl() + " ";
		cmd += "-resize " + width + "x" + height + "! ";
		cmd += img.getUrl();
		
		System.out.println("命令：" + cmd);
		
		return cmd;
	}

	@Override
	//convert test.jpg -crop 100x100+50+50 c.png
	public String crop(Image res_img, Point point, Image dest_img) {
		String cmd = Conf.ToolDir + Root + "/convert ";
		cmd += res_img.getUrl() + " ";
		cmd += "-crop ";
		cmd += dest_img.getWidth() + "x" + dest_img.getHeight() + "+" + point.getX() + "+" + point.getY() + " ";
		cmd += dest_img.getUrl();
		
		System.out.println("命令：" + cmd);
		return cmd;
	}

	@Override
	//convert snapshot.jpg -rotate 45 e.jpg
	public String rotate(Image img, int d, Image dest) {
		String cmd = Conf.ToolDir + Root + "/convert ";
		
		cmd += img.getUrl() + " -rotate " + d + " ";
		cmd += dest.getUrl();
		
		System.out.println("命令：" + cmd);
		return cmd;
	}

	@Override
	//convert background.png -compose over overlay.png -geometry 100x100+0+0 -composite new.png
	public String overlay(Image big, Image small,Point point, Image dest) {
		String cmd = Conf.ToolDir + Root + "/convert ";
		
		cmd += big.getUrl() + " ";
		cmd += "-compose over ";
		cmd += small.getUrl() + " ";
		cmd += "-geometry " + small.getWidth()+"x"+small.getHeight() + "+" + point.getX()+"+"+point.getY();
		cmd += " -composite ";
		cmd += dest.getUrl();
		
		System.out.println("命令："+cmd);
		return cmd;
	}

	@Override
	//convert +append 1.jpg 2.jpg -gravity north dest.jpg
	public String concat(List<Image> list, int style, Image dest_img) {
		String cmd = Conf.ToolDir + Root + "/convert ";
		String flag = "-append ";
		if(style == 1){
			flag = "+append ";
		}
		cmd += flag;
		for(int i =0 ;i<list.size();i++){
			cmd += list.get(i).getUrl() + " ";
		}
		cmd += "-gravity north ";
		cmd += dest_img.getUrl();
		
		System.out.println("命令：" + cmd);
		return cmd;
	}

	@Override
	//convert test.jpg -colorspace Gray e.jpg
	public String gray(Image res_img, Image dest_img) {
		String cmd = Conf.ToolDir + Root + "/convert ";
		
		cmd += res_img.getUrl() + " -colorspace Gray ";
		cmd += dest_img.getUrl();
		
		System.out.println("命令：" + cmd);
		return cmd;
	}
	
	

}
