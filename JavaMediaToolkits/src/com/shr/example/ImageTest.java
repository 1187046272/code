package com.shr.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.zxing.WriterException;
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
		Image res_img1 = new Image("d://1.jpg");
		Image res_img2 = new Image("d://2.jpg");
		Image res_img3 = new Image("d://3.jpg");
		List<Image> list = new ArrayList<Image>();
		list.add(res_img3);
		list.add(res_img2);
		list.add(res_img1);
		
		Image dest_img = new Image("d://5.jpg");
		ii.concat(list,1,dest_img);
	}
	
	public void testEncodeBase(){
		ImageInterface ii = new ImageFunction();
		Image res_img1 = new Image("d://1.jpg");
		Point point = new Point(10,10);
		System.out.println(ii.Image2Base(res_img1));
	}

	public void testDecodeBase(){
		ImageInterface ii = new ImageFunction();
		Image res_img1 = new Image("d://0.png");
		Point point = new Point(10,10);
		String str = "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";
		ii.Base2Image(str, res_img1);
	}
	
	public void testEncodeQR(){
		ImageInterface ii = new ImageFunction();
		Image res_img1 = new Image("d://0.png");
		Point point = new Point(610,610);
		try {
			ii.genQRCode("孙浩然", res_img1, point);
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void testDecodeQR(){
		ImageInterface ii = new ImageFunction();
		Image res_img1 = new Image("d://0.jpg");
		System.out.println(ii.parseQRCode(res_img1));
	}
	
	public static void main(String[] args) {
		ImageTest it = new ImageTest();
		//it.testEncode();
		//it.testScale();
		//it.testCrop();
		//it.testGray();
		//it.testRotate();
		//it.testOverlay();
		//it.testConcat();
		//it.testEncodeBase();
		//it.testDecodeBase();
		//it.testEncodeQR();
		//it.testDecodeQR();
		
	}
}
