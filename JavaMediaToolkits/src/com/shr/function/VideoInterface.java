package com.shr.function;

import java.util.List;

import com.shr.model.Task;
import com.shr.model.Video;

public interface VideoInterface {
	//ת��
	public void encode(Task task);
	//��ȡ��Ƶ������Ϣ
	public Video getInfo(Task task);
	//��������ֻ֧��flv��mp4
	public void hint(Task task);
	//��Ƶ����
	public List<Video> slice(Task task);
	//��Ƶ����
	public Video concat(Task task);
	//ˮӡ
	public Video waterPrint(Task task);
	//���л�
	public Video vInv(Task task);
	
	
}
