package com.pojo;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 文件信息类
 * 
 * @author bobo
 *
 */
public class DirectoryInfo {
	private File file;
	private String path;
	private String ip;
	private String time;
	
	public DirectoryInfo(File file,String handler) {
		this.setFile(file);
		this.path = this.file.getAbsolutePath()+":"+handler;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		this.time = simpleDateFormat.format(new Date());
		getIpAddress();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	// 通过截取cmd流方式得到计算机的配置信息(不好)
	public String getIpAddress() {
		Map<String, String> map = System.getenv();
		String USERNAME = map.get("USERNAME");// 获取用户名
		String COMPUTERNAME = map.get("COMPUTERNAME");// 获取计算机名
		String USERDOMAIN = map.get("USERDOMAIN");// 获取计算机域名
		String info = "当前计算机名：" + COMPUTERNAME + "计算机域名 ：" + USERDOMAIN
				+ "计算机用户名 ：" + USERNAME + "";
		this.ip = info;
		Process p = null;
		try {
			String os = System.getProperty("os.name");
			String osUser = System.getProperty("user.name");
			if (os != null && os.startsWith("Windows")) {
				p = new ProcessBuilder("ipconfig", "/all").start();
			} else {
				p = new ProcessBuilder("ifconfig", "/all").start();
			}
		} catch (Exception e) {
			return info;
		}
		StringBuffer sb = new StringBuffer();
		// 读取进程输出值
		InputStream inputStream = p.getInputStream();

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					inputStream, "UTF-8"));
			String s = "";
			while ((s = br.readLine()) != null) {
				if (s.indexOf("IPv4") > -1) {
					this.ip += s;
				}
				sb.append(s + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return info;
	}

	@Override
	public String toString() {
		return "当前修改文件信息 [文件路径=" + path + ", 服务器信息=" + ip + ", 修改时间=" + time
				+ "]";
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
