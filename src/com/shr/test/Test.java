package com.shr.test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.ImageIcon;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.third.BufferedImageLuminanceSource;
import com.third.MatrixToImageWriter;

public class Test {
	public static void main(String[] args) {
			try {
				Test.testEncode();
				/*while(true){
					Thread.sleep(1500);
					Test.decodeQr("d:/1.jpg");
				}*/
				
				//Test.changeColor("d://1.jpg");
				//Test.decode1("d:/1.jpg");
				
				//Test.zoomImage("d://5.jpg", "d://11.jpg", 700, 700);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}
	
	public static void testEncode() throws WriterException, IOException {  
        String filePath = "D://";  
        String fileName = "zxing.png";  
        String content = "吕帅涛";
        //String content = "啊";
        int width = 700; // ͼ����  
        int height = 700; // ͼ��߶�  
        String format = "png";// ͼ������  
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();  
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);// ���ɾ���  
        Path path = FileSystems.getDefault().getPath(filePath, fileName);  
        MatrixToImageWriter.writeToPath(bitMatrix, format, path);// ���ͼ��  
    }  
  
    /** 
     * ����ͼ�� 
     */  
	public static String decodeQr(String filePath) {
        String retStr = "";
        if ("".equalsIgnoreCase(filePath) && filePath.length() == 0) {
            return "文件未找到";
        }
        try {
            BufferedImage bufferedImage = ImageIO.read(new FileInputStream(filePath));
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap bitmap = new BinaryBitmap(binarizer);
            HashMap<DecodeHintType, Object> hintTypeObjectHashMap = new HashMap<>();
            hintTypeObjectHashMap.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            hintTypeObjectHashMap.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            //hintTypeObjectHashMap.put(DecodeHintType.OTHER, Boolean.TRUE);
            
            Result result = new MultiFormatReader().decode(bitmap, hintTypeObjectHashMap);
            retStr = result.getText();
            System.out.println(retStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retStr;
    }
	
	public static String decode1(String filePath){
        BufferedImage image;  
        try {  
            image = ImageIO.read(new File(filePath));  
            LuminanceSource source = new BufferedImageLuminanceSource(image);  
            Binarizer binarizer = new HybridBinarizer(source);  
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);  
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();  
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");  
            hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);  
            hints.put(DecodeHintType.POSSIBLE_FORMATS, BarcodeFormat.QR_CODE); 
            
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);
            String r = result.getText();
            System.out.println(r);
            return r;
        }catch(Exception e){
        	e.printStackTrace();
        }
        return null;
	}
	
	public static void zoomImage(String src,String dest,int w,int h) throws Exception {
        
        double wr=0,hr=0;
        File srcFile = new File(src);
        File destFile = new File(dest);

        BufferedImage bufImg = ImageIO.read(srcFile); //读取图片
        Image Itemp = bufImg.getScaledInstance(w, h, bufImg.SCALE_SMOOTH);//设置缩放目标图片模板
        
        wr=w*1.0/bufImg.getWidth();     //获取缩放比例
        hr=h*1.0 / bufImg.getHeight();

        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);
        Itemp = ato.filter(bufImg, null);
        try {
            ImageIO.write((BufferedImage) Itemp,dest.substring(dest.lastIndexOf(".")+1), destFile); //写入缩减后的图片
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	public static void changeColor(String png){
		try{
			BufferedImage image = ImageIO.read(new File(png)); 
			ImageIcon imageIcon = new ImageIcon(image);  
	        
			BufferedImage bufferedImage = new BufferedImage(imageIcon.getIconWidth(),imageIcon.getIconHeight()
	            , BufferedImage.TYPE_4BYTE_ABGR);
			
			Graphics2D g2D = (Graphics2D) bufferedImage.getGraphics();
			g2D.drawImage(imageIcon.getImage(), 0, 0,imageIcon.getImageObserver());
	        
	        //循环每一个像素点，改变像素点的Alpha值
	        for (int j1 = bufferedImage.getMinY(); j1 < bufferedImage.getHeight(); j1++) {
	          for (int j2 = bufferedImage.getMinX(); j2 < bufferedImage.getWidth(); j2++) {
	            int pixel = bufferedImage.getRGB(j2, j1);
	            int[]   rgb = new int[3];
	            
	            rgb[0] = (pixel & 0xff0000) >> 16;
	            rgb[1] = (pixel & 0xff00) >> 8;
	            rgb[2] = (pixel & 0xff);
	            //rgb[3] = (pixel & 0xff) >> 24;

	            Color c;
	            int d = 125;
	            if(rgb[0] >= d && rgb[1] >= d && rgb[2] >= d){
	            	c = new Color(255,255 ,255 ,0);
	            }else{
	                c = new Color(0,0,0,255);
	            }
	            
	            bufferedImage.setRGB(j2, j1, c.getRGB());
	          }
	        }
	        
	        int x1=0,x2=bufferedImage.getWidth(),y1=0,y2=bufferedImage.getHeight();
	        
	        ImageInputStream iis = null;
	        ByteArrayOutputStream os = new ByteArrayOutputStream();
	        ImageOutputStream imOut = ImageIO.createImageOutputStream(os);
	        ImageIO.write(bufferedImage,"png",imOut);
	        InputStream is = new ByteArrayInputStream(os.toByteArray());
	        iis = ImageIO.createImageInputStream(is);
	        Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName("png");	        
	        ImageReader reader = it.next();
	        ImageReadParam param = reader.getDefaultReadParam();
	        Rectangle r = new Rectangle(x1<0?0:x1, y1<0?0:y1, (x2-x1)<0?0:(x2-x1), (y2-y1)<0?0:(y2-y1));
	        param.setSourceRegion(r);
	        reader.setInput(iis, true);
	        BufferedImage out = reader.read(0, param);
	        
	        imageIcon = new ImageIcon(out);
	        g2D.drawImage(out, 0, 0,imageIcon.getImageObserver());
	        //生成图片为PNG
	        ImageIO.write(out, "png",  new File("d://0.png"));
	        
		}catch (Exception e) {
	       e.printStackTrace();
	    }
	}
}
