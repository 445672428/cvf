package com.frame.web;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URLDecoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

@WebServlet("/file/load2")
public class classdown extends HttpServlet {
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 获取文件URI
		String path = URLDecoder
				.decode(request.getRequestURI().replace(
						getServletContext().getContextPath() + "/download", ""),
						"UTF-8");
		// 获取文件
		File file = (File) ManualBuffer.get(path);
		if (file == null) {
			DirectoryTree dt = DirectoryTree.getInstance();
			file = dt.findByPath(path);
			if (file == null) {
				response.sendError(404);
				return;
			}
			ManualBuffer.put(path, file);
		}
		// 文件名
		String filename = file.getFilename();
		// 获取文件读取对象
		FileReader fr = file.getReader();
		// 获取浏览器类型
		String browser = request.getHeader("user-agent");
		// 设置响应头，206支持断点续传
		int http_status = 206;
		if (browser.contains("MSIE"))
			http_status = 200;// 200 响应头，不支持断点续传
		response.reset();
		response.setStatus(http_status);
		// 响应头
		response.setContentType("application/octet-stream;charset=UTF-8");
		try {
			// 下载起始位置
			long since = 0;
			// 下载结束位置
			long until = file.getSize() - 1;
			// 获取Range，下载范围
			String range = request.getHeader("range");
			if (range != null) {
				// 剖解range
				range = range.split("=")[1];
				String[] rs = range.split("-");
				if (AuthFilter.isDigit(rs[0])) {
					since = Integer.parseInt(rs[0]);
				}
				if (rs.length > 1 && AuthFilter.isDigit(rs[1])) {
					until = Integer.parseInt(rs[1]);
				}
			}
			// 设置响应头
			response.setHeader("Accept-Ranges", "bytes");
			response.setHeader("Content-Range", "bytes " + since + "-" + until
					+ "/" + file.getSize());
			// 文件名用ISO08859_1编码
			response.setHeader("Content-Disposition", "attachment; filename=\""
					+ new String(filename.getBytes(), "ISO8859_1") + "\"");
			response.setHeader("Content-Length", "" + (until - since + 1));
			System.out.println("download: " + filename);
			// 定位到请求位置
			fr.seek(since);
			byte[] buffer = new byte[128 * 1024];
			int len;
			boolean full = false;
			// 读取，输出流
			while ((len = fr.read(buffer)) > 0) {
				if (fr.tell() - 1 > until) {
					len = (int) (len - (fr.tell() - until - 1));
					full = true;
				}
				response.getOutputStream().write(buffer, 0, len);
				if (full)
					break;
			}
			// 输出
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (java.net.SocketException e) {
			// 连接断开
		} finally {
			if (fr != null)
				fr.close();
		}
		response.flushBuffer();
	}
}
