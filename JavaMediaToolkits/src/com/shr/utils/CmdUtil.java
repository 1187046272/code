package com.shr.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

import com.shr.exception.ErrorEnum;
import com.shr.exception.OptException;

public class CmdUtil {

	
	/**
	 * 执行cmd命令
	 * @param cmd 命令行
	 * @param getresult 是否组装结果
	 * @return 返回结果
	 * @throws OptException 
	 */
	public static String process(String dir,String cmd,boolean getresult) throws OptException{
		StringBuilder result = new StringBuilder("");
		try {
			
			final CommandLine cmdLine = CommandLine.parse(cmd);
			
			//final DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
			
			DefaultExecutor executor = new DefaultExecutor();
			ByteArrayOutputStream baos = null;
			
			if(getresult){
				baos = new ByteArrayOutputStream(1024);
				PumpStreamHandler psHandler = new PumpStreamHandler(baos, baos);
				executor.setStreamHandler(psHandler);
			}
			
			executor.setWorkingDirectory(new File(dir));
			//executor.execute(cmdLine, resultHandler);
			executor.execute(cmdLine);
			
			/*if(getresult){
				while(resultHandler.hasResult()){
					System.out.println(baos.toString("utf-8"));
					result.append(baos.toString());
				}
			}*/
			
			if(getresult){
				result.append(baos.toString());
			}
			
			//resultHandler.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
			throw new OptException(ErrorEnum.zhuanma);
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		/*File file = new File(Conf.ToolDir+"FFMPEG");
		String result = "";
		try {
			result = CmdUtil.process(file.getAbsolutePath(), "ffmpeg -i d://3.mp4 -y d://5.mp4", false);
		} catch (OptException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		System.out.println("\n\n\n\n\n\n\n" + result);*/
		
		while(true){
			new Thread(new Runnable() {
				String result = "";
				int index = 1;
				public void run() {
					System.out.println("开始录屏" + index);
					try {
						result = CmdUtil.process("d://", "adb shell screenrecord --time-limit 4 --bit-rate 1000000 --size 848x480 /sdcard/test" + index + ".mp4", true);
						System.out.println(result);
						System.out.println("开始传输");
						result = CmdUtil.process("d://", "adb pull /sdcard/test" + index + ".mp4", true);
						System.out.println(result);
						index++;
						if(index > 10){
							index = 1;
						}
					} catch (OptException e) {
						e.printStackTrace();
					}
				}
			}).start();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
