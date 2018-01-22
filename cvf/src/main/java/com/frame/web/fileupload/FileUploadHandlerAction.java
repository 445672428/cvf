package com.frame.web.fileupload;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import contant.Contant;
@Controller
@RequestMapping(value="file")
public class FileUploadHandlerAction {
	/**
	 * 使用springmvc 进行文件上传
	 * @param file
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="upload.do",method=RequestMethod.POST,produces=MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public void serverUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpServletResponse response){
		FileOutputStream outStream = null;
		InputStream inStream = null;
		try {
			outStream = new FileOutputStream("//savefilepath//"+file.getOriginalFilename());
			inStream = file.getInputStream();
			int flag = 0;
			while((flag=inStream.read())!=-1){
				outStream.write(flag);
			}
			outStream.flush();
			outStream.close();
			inStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("fileName", file.getOriginalFilename());
	}
	/**
	 * 文件上传到远程服务器上
	 * @param files
	 */
	public void uploadToFarService(HashMap<String, InputStream> files) {
        try {  
            String BOUNDARY = "---------7d4a6d158c9"; // 定义数据分隔线  
            URL url = new URL(Contant.SERVER_DIR_URL);  
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
            // 发送POST请求必须设置如下两行  
            conn.setDoOutput(true);  
            conn.setDoInput(true);  
            conn.setUseCaches(false);  
            conn.setRequestMethod("POST");  
            conn.setRequestProperty("connection", "Keep-Alive");  
            conn.setRequestProperty("user-agent",  
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");  
            conn.setRequestProperty("Charsert", "UTF-8");  
            conn.setRequestProperty("Content-Type",  
                    "multipart/form-data; boundary=" + BOUNDARY);  
  
            OutputStream out = new DataOutputStream(conn.getOutputStream());  
            byte[] end_data = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();// 定义最后数据分隔线  
            Iterator iter = files.entrySet().iterator();  
            int i=0;  
            while (iter.hasNext()) {  
                i++;  
                Map.Entry entry = (Map.Entry) iter.next();  
                String key = (String) entry.getKey();  
                InputStream val = (InputStream) entry.getValue();  
                String fname = key;  
                File file = new File(fname);  
                StringBuilder sb = new StringBuilder();  
                sb.append("--");  
                sb.append(BOUNDARY);  
                sb.append("\r\n");  
                sb.append("Content-Disposition: form-data;name=\"file" + i  
                        + "\";filename=\"" + key + "\"\r\n");  
                sb.append("Content-Type:application/octet-stream\r\n\r\n");  
  
                byte[] data = sb.toString().getBytes();  
                out.write(data);  
                DataInputStream in = new DataInputStream(val);  
                int bytes = 0;  
                byte[] bufferOut = new byte[1024];  
                while ((bytes = in.read(bufferOut)) != -1) {  
                    out.write(bufferOut, 0, bytes);  
                }  
                out.write("\r\n".getBytes()); // 多个文件时，二个文件之间加入这个  
                in.close();  
            }  
            out.write(end_data);  
            out.flush();  
            out.close();  
  
            // 定义BufferedReader输入流来读取URL的响应  
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));  
            String line = null;  
            while ((line = reader.readLine()) != null) {  
                System.out.println(line);  
            }  
  
        } catch (Exception e) {  
            System.out.println("发送POST请求出现异常！" + e);  
            e.printStackTrace();  
        }  
    }  
	
	/**
	 * 文件下载
	 * @param fileNames
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="down.do")
	public void downfileUpload(String[] fileNames,HttpServletRequest request,HttpServletResponse response){
		for(String fileName : fileNames){
			try {
				fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");
				//获取文件下载目录
				ServletContext sc = request.getSession().getServletContext();
				String fileSavePath = sc.getRealPath("/images");
				File file = new File(fileSavePath + "\\" + fileName);
				if (!file.exists()) {
					request.setAttribute("message", "文件已经被删除");
				}
				 // 处理文件名  
		        String realname = fileName.substring(fileName.indexOf("_") + 1);  
		        // 设置响应头，控制浏览器下载该文件  
		        response.setHeader("content-disposition", "attachment;filename="  
		                + URLEncoder.encode(realname, "UTF-8"));  
		        // 读取要下载的文件，保存到文件输入流  
		        FileInputStream in = new FileInputStream(fileSavePath + "\\" + fileName);  
		        // 创建输出流  
		        OutputStream out = response.getOutputStream();  
		        // 创建缓冲区  
		        byte buffer[] = new byte[1024];  
		        int len = 0;  
		        // 循环将输入流中的内容读取到缓冲区当中  
		        while ((len = in.read(buffer)) > 0) {  
		            // 输出缓冲区的内容到浏览器，实现文件下载  
		            out.write(buffer, 0, len);  
		        }  
		        // 关闭文件输入流  
		        in.close();  
		        // 关闭输出流  
		        out.close();  
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * @description: 通过URL下载
	 * @param photoUrl
	 * @param fileName
	 * @return      
	 * @author:  zhouzhian
	 * @date: 2017-6-22
	 */
	public boolean downUrlAs(String photoUrl, String fileName) {
		try {
			URL url = new URL(photoUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			DataInputStream in = new DataInputStream(connection.getInputStream());
			DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
			byte[] buffer = new byte[4096];
			int count = 0;
			while ((count = in.read(buffer)) > 0) {
				out.write(buffer, 0, count);
			}
			out.close();
			in.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
