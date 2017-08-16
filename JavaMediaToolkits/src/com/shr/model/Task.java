package com.shr.model;

import java.util.List;

public class Task {
	private int optionType;
	private List<Video> videos;
	
	public int getOptionType() {
		return optionType;
	}
	public void setOptionType(int optionType) {
		this.optionType = optionType;
	}
	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	
	
}
