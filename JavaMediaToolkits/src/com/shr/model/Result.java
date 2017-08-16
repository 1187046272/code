package com.shr.model;

import java.util.List;

public class Result {
	private List<String> errors;
	private Task task;
	private List<Video> videos;
	
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	
}
