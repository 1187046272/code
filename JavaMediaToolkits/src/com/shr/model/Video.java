package com.shr.model;

public class Video {
	private String videoFilename;
	private String videoSrc;
	
	private int width;
	private int height;
	private long videoSize;
	private long videoLong;
	private String videoSurfix;
	private String videoFormat;
	
	private String bitRate;
	private String frameRate;
	
	private String codec;
	private int quality = 20;
	private boolean isHint = true;
	public String getVideoFilename() {
		return videoFilename;
	}
	public void setVideoFilename(String videoFilename) {
		this.videoFilename = videoFilename;
	}
	public String getVideoSrc() {
		return videoSrc;
	}
	public void setVideoSrc(String videoSrc) {
		this.videoSrc = videoSrc;
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
	public String getVideoSurfix() {
		return videoSurfix;
	}
	public void setVideoSurfix(String videoSurfix) {
		this.videoSurfix = videoSurfix;
	}
	public String getVideoFormat() {
		return videoFormat;
	}
	public void setVideoFormat(String videoFormat) {
		this.videoFormat = videoFormat;
	}
	public String getBitRate() {
		return bitRate;
	}
	public void setBitRate(String bitRate) {
		this.bitRate = bitRate;
	}
	public String getFrameRate() {
		return frameRate;
	}
	public void setFrameRate(String frameRate) {
		this.frameRate = frameRate;
	}
	public String getCodec() {
		return codec;
	}
	public void setCodec(String codec) {
		this.codec = codec;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public boolean isHint() {
		return isHint;
	}
	public void setHint(boolean isHint) {
		this.isHint = isHint;
	}
	
}
