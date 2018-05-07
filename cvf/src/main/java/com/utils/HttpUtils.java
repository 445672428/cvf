package com.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
public class HttpUtils {
	 /** 
     * get请求 
     * @return 
     */  
    public static String doGet(String url) {  
        try {  
        	HttpClient client = HttpClients.createDefault();
            HttpGet request = new HttpGet(url);  
            request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36"); 
            HttpResponse response = client.execute(request);  
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {  
                String strResult = EntityUtils.toString(response.getEntity());  
                return strResult;  
            }  
        }   
        catch (IOException e) {  
            e.printStackTrace();  
        }  
          
        return null;  
    }  
      
    /** 
     * post请求(用于key-value格式的参数) 
     * @param url 
     * @param params 
     * @return 
     */  
    public static String doPost(String url, Map<String,Object> params){  
          
        BufferedReader in = null;    
        try {    
        	HttpClient client = HttpClients.createDefault();
            HttpPost request = new HttpPost();    
            request.setURI(new URI(url));  
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            if(params!=null && params.size()>0){
            	for( Map.Entry<String, Object> entry : params.entrySet()){
            		String name = entry.getKey();  
                    String value = String.valueOf(entry.getValue());  
                    nvps.add(new BasicNameValuePair(name, value));
                }
            }
            request.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));  
            HttpResponse response = client.execute(request);    
            int code = response.getStatusLine().getStatusCode();  
            if(code == HttpStatus.SC_OK){
                in = new BufferedReader(new InputStreamReader(response.getEntity()    
                        .getContent(),HTTP.UTF_8));  
                StringBuffer sb = new StringBuffer();    
                String line = "";    
                String NL = System.getProperty("line.separator");    
                while ((line = in.readLine()) != null) {    
                    sb.append(line + NL);    
                }
                in.close();    
                return sb.toString();  
            }  
            else{   
                System.out.println("状态码：" + code);  
                return null;  
            }  
        }  catch(Exception e){  
            e.printStackTrace();  
            return null;  
        } finally{
        	if(in!= null){
        		try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
        	}
        }
    }  
    public static byte[]  downloadHttpFile(String url){
    	InputStream  input =null;
    	try{
    		input = downloadFile(url);
	    	return readInputStream(input);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
    }
    public static InputStream downloadFile(String url) throws ClientProtocolException, IOException{
    	HttpClient httpClient = HttpClients.createDefault();
    	HttpGet request = new HttpGet(url); 
    	InputStream in =  null;
		HttpResponse response = httpClient.execute(request); 
    	HttpEntity entity = response.getEntity();
    	in =  entity.getContent();
    	return in;
    }
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {    
        byte[] buffer = new byte[1024];    
        int len = 0;    
        ByteArrayOutputStream bos = new ByteArrayOutputStream();    
        while((len = inputStream.read(buffer)) != -1) {    
            bos.write(buffer, 0, len);    
        }    
        bos.close();    
        return bos.toByteArray();    
    }   
    
    
   

    //post请求方法
    public static  String sendJsonPost(String url, String data) {
       String response = null;
       try {
    	   HttpClient httpclient = null;
    	   HttpResponse httpresponse = null;
    		HttpClient httpClient = HttpClients.createDefault();
           HttpPost httppost = new HttpPost(url);
           StringEntity stringentity = new StringEntity(data,
                   ContentType.create("text/json", "UTF-8"));
           httppost.setEntity(stringentity);
           httpresponse = httpclient.execute(httppost);
           response = EntityUtils
                   .toString(httpresponse.getEntity());
       } catch (Exception e) {
           e.printStackTrace();
       }
       return response;
    }
    public static void main(String[] args) {
    	/*Map<String,Object> params = new HashMap<String, Object>(){
    		{
    			put("aaa", "第一");
    			put("bbb", "测试韩式");
    			put("ccc", 666);
    		}
    	};
		String result = doPost("http://127.0.0.1:8012/DataMonitor/config/test.do", params);
		if(result!=null){
			if(result.startsWith("{")){
				JSONObject json =  JSONObject.fromObject(result);
				System.out.println(json.size());
				System.out.println(json.keySet());
			}
			else if(result.startsWith("[")){
				JSONArray jar = JSONArray.fromObject(result);
				System.out.println(jar.size());
			}
		}
		System.out.println("请求结果:\n"+result);
		System.out.println(doGet("https://www.cnblogs.com/mengrennwpu/p/6418114.html"));*/
    	
    	String url = "http://dl.2345.com/haozip/haozip_v5.9.7.exe";
    	byte[] nr  =  downloadHttpFile(url);
    	if(nr==null){
    		System.out.println("。。");
    	}else{
    		File file = new File("H:/logs/司法鉴定","haoya.exe");
    		try {
				FileUtils.writeByteArrayToFile(file, nr);
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }
      
}
