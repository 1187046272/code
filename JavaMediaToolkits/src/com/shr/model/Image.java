package com.shr.model;


/**
 * @author 孙浩然
 * 图片描述类
 */
public class Image implements Media{
	
	String url;			//图片路径
	String fileName;	//图片文件命名
	String format;		//图片格式
	
	int width;			//图片宽度
	int height;			//图片高度
	
	long size;			//图片文件大小
	
	double alpha;		//透明度 0-1之间的值

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}
	
}
