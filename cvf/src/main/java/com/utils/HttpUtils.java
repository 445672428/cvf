package com.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
public class HttpUtils {
	/**
	 * 获取外网IP
	 * @return
	 */
	public static String getLocalAddress(){
		String ip = "";
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ip;
	}
    public static String getIpAddress(HttpServletRequest request) {  
        String ip = request.getHeader("x-forwarded-for");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        }  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
            ip = request.getRemoteAddr();  
        }  
        return ip;  
    }
    /**
     * https请求
     * @param url
     * @return
     */
	public static String doGetHttps(String url)  {
		String result = null;
		try {
	        url = "https://www.sojson.com/open/api/weather/json.shtml?city=武汉";
	        try (CloseableHttpClient httpClient = createHttpClient()) {
	            HttpGet httpGet = new HttpGet(url);
	            try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
	                HttpEntity entity = httpResponse.getEntity();
	                result = EntityUtils.toString(entity);
	                EntityUtils.consume(entity);
	            }
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
    }


    private static CloseableHttpClient createHttpClient() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
    	KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());  
    	FileInputStream instream = null;
        try {  
        	instream = new FileInputStream(new File("D:\\key.txt"));
            // 加载keyStore d:\\tomcat.keystore    
            trustStore.load(instream, null);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                instream.close();  
            } catch (Exception ignore) {  
            }  
        }  
        SSLContext sslcontext = SSLContexts.custom()
                .loadTrustMaterial(trustStore, new TrustSelfSignedStrategy())
                .build();

        SSLConnectionSocketFactory sslSf = new SSLConnectionSocketFactory(sslcontext, null, null,
                new X509HostnameVerifier() {
					
					@Override
					public boolean verify(String arg0, SSLSession arg1) {
						return false;
					}
					
					@Override
					public void verify(String host, String[] cns, String[] subjectAlts)
							throws SSLException {
						
					}
					
					@Override
					public void verify(String host, X509Certificate cert) throws SSLException {
						
					}
					
					@Override
					public void verify(String host, SSLSocket ssl) throws IOException {
						
					}
				});

        return HttpClients.custom().setSSLSocketFactory(sslSf).build();
    }
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
