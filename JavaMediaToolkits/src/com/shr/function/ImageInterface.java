package com.shr.function;

import java.io.IOException;
import java.util.List;

import com.google.zxing.WriterException;
import com.shr.exception.OptException;
import com.shr.model.Image;
import com.shr.model.Point;

/**
 * @author 孙浩然
 * 图片处理接口定义
 */
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
	public Image concat(List<Image> rs,int style,Image dest);
	//生成二维码
	public Image genQRCode(String msg,Image img,Point point) throws WriterException, IOException;
	//识别二维码
	public String parseQRCode(Image img);
	//图片生成base64编码
	public String Image2Base(Image img);
	//根据base64生成图片
	public void Base2Image(String str,Image img);
}
