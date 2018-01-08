package com.shr.function;

import java.util.ArrayList;

import com.shr.exception.OptException;
import com.shr.model.Image;
import com.shr.model.Point;

public interface ImageInterface {
	//转格式
	public Image encode(Image res_img,Image dest_img);
	//按比例缩放
	public Image scaleByPercent(Image img ,int percent) throws OptException;
	//按长度缩放
	public Image scaleByLength(Image img,int width,int height);
	//截取图片
	public Image crop(Image img,Point left_top,Image dest_img);
	//图片叠加
	public Image overlay(Image big,Image small,Point point,Image dest);
	//旋转
	public Image rotate(Image img,int angle,Image dest);
	//灰度
	public Image gray(Image res_img,Image dest_img);
	//图片拼接
	public Image concat(ArrayList<Image> rs,int style,Image dest);
}
