package com.shr.function;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

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
import com.shr.exception.ErrorEnum;
import com.shr.exception.OptException;
import com.shr.model.Image;
import com.shr.model.Point;
import com.shr.tool.impl.magic;
import com.shr.utils.CmdUtil;
import com.shr.utils.Conf;
import com.third.zxing.BufferedImageLuminanceSource;
import com.third.zxing.MatrixToImageWriter;


/**
 * @author 孙浩然
 * 图片处理实现类
 */
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
	public Image concat(List<Image> rs, int style,Image dest) {
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

	@Override
	public Image genQRCode(String msg,Image img,Point point) throws WriterException, IOException {
        String format = "png";  
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();  
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");  
        BitMatrix bitMatrix = new MultiFormatWriter().encode(msg, BarcodeFormat.QR_CODE, point.getX(), point.getY(), hints);  
        Path path = FileSystems.getDefault().getPath(img.getUrl());  
        MatrixToImageWriter.writeToPath(bitMatrix, format, path);
        return img;
	}

	@Override
	public String parseQRCode(Image img) {
		String retStr = "";
        
        try {
            BufferedImage bufferedImage = ImageIO.read(new FileInputStream(img.getUrl()));
            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap bitmap = new BinaryBitmap(binarizer);
            HashMap<DecodeHintType, Object> hintTypeObjectHashMap = new HashMap<>();
            hintTypeObjectHashMap.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            hintTypeObjectHashMap.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            //hintTypeObjectHashMap.put(DecodeHintType.OTHER, Boolean.TRUE);
            
            Result result = new MultiFormatReader().decode(bitmap, hintTypeObjectHashMap);
            retStr = result.getText();
        } catch (Exception e) {
            e.printStackTrace();
            return "解析失败";
        }
        return retStr;
	}

	@Override
	public String Image2Base(Image img) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(img.getUrl());
			int len = fis.available();
			byte[] bytes = new byte[len];
			fis.read(bytes);
			byte[] result = Base64.encodeBase64(bytes);
			return new String(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}finally{
			try {
				if(fis != null){
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void Base2Image(String str, Image img) {
		File file = new File(img.getUrl());
		if(file.exists()){
			System.out.println("删除历史文件");
			file.delete();
		}
		
        byte[] b = Base64.decodeBase64(new String(str).getBytes());  
        
        OutputStream out;
		try {
			out = new FileOutputStream(img.getUrl());
			out.write(b);
	        out.flush();
	        out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
