package com.shr.model;

import java.io.File;

import com.shr.utils.StringUtil;


/**
 * @author 孙浩然
 * 视频封装类
 */
public class Video implements Media{
	private String fileName;		//视频文件名
	private String fileUrl;			//视频文件路径
	
	private int width;				//视频宽度
	private int height;				//视频高度
	
	private long videoSize;			//视频文件大小
	private long videoLong;			//视频时长
	
	private String videoFormat;		//视频封装格式
	
	private double bitRate;			//bit率
	private double frameRate;		//帧率
	
	private String vcodec;			//视频编解码器
	private String acodec;			//音频编解码器
	private boolean hasAudio=false;	//是否有声音

	private boolean isHint = true;	//是否执行hint操作
	
	public Video(String fileUrl) {
		super();
		File file = new File(fileUrl);
		this.fileUrl = fileUrl;
		this.fileName = StringUtil.getFileName(fileUrl);
		this.videoFormat = StringUtil.getSurfix(fileUrl).toLowerCase();
		this.setVideoSize(file.length());
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
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
	public long getVideoSize() {
		return videoSize;
	}
	public void setVideoSize(long videoSize) {
		this.videoSize = videoSize;
	}
	public long getVideoLong() {
		return videoLong;
	}
	public void setVideoLong(long videoLong) {
		this.videoLong = videoLong;
	}
	
	public String getVideoFormat() {
		return videoFormat;
	}
	public void setVideoFormat(String videoFormat) {
		this.videoFormat = videoFormat;
	}

	public double getBitRate() {
		return bitRate;
	}

	public void setBitRate(double bitRate) {
		this.bitRate = bitRate;
	}

	public double getFrameRate() {
		return frameRate;
	}

	public void setFrameRate(double frameRate) {
		this.frameRate = frameRate;
	}

	public boolean isHint() {
		return isHint;
	}
	public void setHint(boolean isHint) {
		this.isHint = isHint;
	}

	public String getVcodec() {
		return vcodec;
	}

	public void setVcodec(String vcodec) {
		this.vcodec = vcodec;
	}

	public String getAcodec() {
		return acodec;
	}

	public void setAcodec(String acodec) {
		this.acodec = acodec;
	}

	public boolean isHasAudio() {
		return hasAudio;
	}

	public void setHasAudio(boolean hasAudio) {
		this.hasAudio = hasAudio;
	}
	
	@Override
	public String toString() {
		String rtn = "视频信息：\n";
		rtn += "文件名:" + this.fileName + "\n";
		rtn += "视频宽度:" + this.width + "\n";
		rtn += "视频高度:" + this.height + "\n";
		rtn += "比特率:" + this.bitRate + "\n";
		rtn += "帧率:" + this.frameRate + "\n";
		rtn += "视频文件大小:" + this.videoSize + "\n";
		rtn += "视频时长:" + this.videoLong + "\n";
		return rtn;
	}
}
