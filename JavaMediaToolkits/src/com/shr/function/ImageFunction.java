package com.shr.function;

import java.util.ArrayList;

import com.shr.exception.ErrorEnum;
import com.shr.exception.OptException;
import com.shr.model.Image;
import com.shr.model.Point;
import com.shr.tool.impl.magic;
import com.shr.utils.CmdUtil;
import com.shr.utils.Conf;

public class ImageFunction implements ImageInterface{

	@Override
	public Image encode(Image res_img, Image dest_img) {
		
		magic magic = new magic();
		
		String cmd = magic.encode(res_img, dest_img);
		
		String result = "";		
		try {
			result = CmdUtil.process(Conf.ToolDir + magic.Root, cmd, true);
		} catch (OptException e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
		
		return dest_img;
	}
	
	@Override
	public Image scaleByPercent(Image img, int percent) throws OptException {
		if(percent <= 0){
			throw new OptException(ErrorEnum.pe);
		}
		int width = img.getWidth() * percent / 100;
		int height = img.getHeight() * percent / 100;
		
		if(width == 0 || height == 0){
			throw new OptException(ErrorEnum.pe);
		}
		
		return scaleByLength(img, width, height);
	}

	@Override
	public Image scaleByLength(Image img, int width, int height) {
		magic magic = new magic();
		
		String cmd = magic.scale(img, width,height);
		
		String result = "";		
		try {
			result = CmdUtil.process(Conf.ToolDir + magic.Root, cmd, true);
		} catch (OptException e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
		img.setWidth(width);
		img.setHeight(height);
		return img;
	}

	@Override
	public Image concat(ArrayList<Image> rs, int style,Image dest) {
		magic magic = new magic();
		
		String cmd = magic.concat(rs,style, dest);
		
		String result = "";
		try {
			result = CmdUtil.process(Conf.ToolDir + magic.Root, cmd, true);
		} catch (OptException e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
		
		return dest;

	}

	@Override
	public Image crop(Image img, Point left_top, Image dest_img) {
		magic magic = new magic();
		
		String cmd = magic.crop(img, left_top, dest_img);
		
		String result = "";
		try {
			result = CmdUtil.process(Conf.ToolDir + magic.Root, cmd, true);
		} catch (OptException e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
		
		return dest_img;
	}

	@Override
	public Image gray(Image res_img, Image dest_img) {
		magic magic = new magic();
		
		String cmd = magic.gray(res_img, dest_img);
		
		String result = "";
		try {
			result = CmdUtil.process(Conf.ToolDir + magic.Root, cmd, true);
		} catch (OptException e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
		
		return dest_img;
	}

	@Override
	public Image overlay(Image big, Image small,Point point,Image dest) {
		magic magic = new magic();
		
		String cmd = magic.overlay(big,small,point,dest);
		
		String result = "";
		try {
			result = CmdUtil.process(Conf.ToolDir + magic.Root, cmd, true);
		} catch (OptException e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
		
		return dest;
	}

	@Override
	public Image rotate(Image img, int angle,Image dest) {
		magic magic = new magic();
		
		String cmd = magic.rotate(img,angle,dest);
		
		String result = "";
		try {
			result = CmdUtil.process(Conf.ToolDir + magic.Root, cmd, true);
		} catch (OptException e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
		return dest;
	}

}
