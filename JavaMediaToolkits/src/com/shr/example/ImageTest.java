package com.shr.example;

import com.shr.exception.OptException;
import com.shr.function.ImageFunction;
import com.shr.function.ImageInterface;
import com.shr.model.Image;
import com.shr.model.Point;

public class ImageTest {
	
	public void testEncode(){
		ImageInterface ii = new ImageFunction();
		Image res_img = new Image("d://a.jpg");
		Image dest_img = new Image("d://b.png",200,400);
		ii.encode(res_img, dest_img);
	}

	public void testCrop(){
		ImageInterface ii = new ImageFunction();
		Image res_img = new Image("d://test.jpg");
		Point point = new Point(10,10);
		Image dest_img = new Image("d://d.png",20,20);
		ii.crop(res_img,point, dest_img);
	}
	
	public void testScale(){
		ImageInterface ii = new ImageFunction();
		Image res_img = new Image("d://a.jpg");
		//ii.scaleByLength(res_img, 50, 50);
		try {
			ii.scaleByPercent(res_img, 300);
		} catch (OptException e) {
			e.printStackTrace();
		}
	}
	
	public void testGray(){
		ImageInterface ii = new ImageFunction();
		Image res_img = new Image("d://a.jpg");
		Image dest_img = new Image("d://a.jpg");
		ii.gray(res_img, dest_img);
	}
	
	public void testRotate(){
		ImageInterface ii = new ImageFunction();
		Image res_img = new Image("d://a.jpg");
		Image dest_img = new Image("d://a.jpg");
		ii.rotate(res_img, 90,dest_img);
	}
	
	public void testOverlay(){
		ImageInterface ii = new ImageFunction();
		Image res_img1 = new Image("d://test.jpg");
		Image res_img2 = new Image("d://a.jpg");
		Image dest_img = new Image("d://x.jpg");
		Point point = new Point(10,10);
		ii.overlay(res_img1,res_img2,point ,dest_img);
	}
	
	public void testConcat(){
		ImageInterface ii = new ImageFunction();
		Image res_img = new Image("d://a.jpg");
		Image dest_img = new Image("d://a.jpg");
		ii.rotate(res_img, 90,dest_img);
	}
	
	public static void main(String[] args) {
		ImageTest it = new ImageTest();
		//it.testEncode();
		//it.testScale();
		//it.testCrop();
		//it.testGray();
		//it.testRotate();
		//it.testOverlay();
		
	}
}
