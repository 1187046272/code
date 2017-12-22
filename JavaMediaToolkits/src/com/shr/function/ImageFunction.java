package com.shr.function;

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
	public Image scaleByPercent(Image img, int percent) {
		
		return null;
	}

	@Override
	public Image scaleByLength(Image img, int width, int height) {
		
		return null;
	}

	@Override
	public Image crop(Image img, Point left_top, Image dest_img) {
		
		return null;
	}

	@Override
	public Image overlay(Image big, Image small) {
		
		return null;
	}

	@Override
	public Image rotate(Image img, Point center, int angle) {
		
		return null;
	}

}
