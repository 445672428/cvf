package com.commom.utils;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

public class SMS {
	   private  String nameSpace = "http://info.pica.com";
	   private  String SHCNN_URI_SEND = "/mms/services/info";
	   private  String strURL =  "http://211.99.191.148";
	   
	   private String regcode="";
	   private String password="";
	   
	   public SMS(){
			  
	   }
	 
	  
	  public boolean sendSMS(String content,String mobile,Integer sendTimes,StringBuffer msg){
		  msg.append("发送手机验证码错误:");
	      Map<String,String> resultMap=new HashMap<String,String>();
	      resultMap.put("-1", "用户名或密码不正确");
	      resultMap.put("-2", "余额不够");
	      resultMap.put("-3", "帐号没有注册");
	      resultMap.put("-4", "内容超长");
	      resultMap.put("-5", "帐号路由为空");
	      resultMap.put("-6", "手机号码多于1000个或号码错误");
	      resultMap.put("-8", "扩展号超长");
	      resultMap.put("-13", "定时时间错误或者小于当前系统时间");
	      resultMap.put("-17", "手机号码为空");
	      resultMap.put("-18", "号码不是数字或者逗号不是英文逗号");
	      resultMap.put("-19", "短信内容为空");
	      resultMap.put("-32", "（包体异常）或网络故障");
	      
	        String result = "";
 	        byte [] b;
  	        boolean isSentOk=false;
	        int index=0;
	        while(!isSentOk && index<sendTimes){
		        try {
		        	index++;  
                    Service services = new Service();
	                Call call1 = null;
	                call1 = (Call) services.createCall();

	                call1.setTargetEndpointAddress(new URL(strURL+SHCNN_URI_SEND));
 	                call1.setOperationName(new QName(nameSpace,"sendSMS"));
	                call1.addParameter(new QName(nameSpace,"in0"), XMLType.XSD_STRING, ParameterMode.IN);
	                call1.addParameter(new QName(nameSpace,"in1"), XMLType.XSD_STRING, ParameterMode.IN);
	                call1.addParameter(new QName(nameSpace,"in2"), XMLType.XSD_STRING, ParameterMode.IN);
	                call1.addParameter(new QName(nameSpace,"in3"), XMLType.XSD_STRING, ParameterMode.IN);
	                call1.addParameter(new QName(nameSpace,"in4"), XMLType.XSD_STRING, ParameterMode.IN);
	                call1.addParameter(new QName(nameSpace,"in5"), XMLType.XSD_STRING, ParameterMode.IN);
	                call1.addParameter(new QName(nameSpace,"in6"), XMLType.XSD_STRING, ParameterMode.IN);
	                call1.addParameter(new QName(nameSpace,"in7"), XMLType.XSD_STRING, ParameterMode.IN);
	                call1.addParameter(new QName(nameSpace,"in8"), XMLType.XSD_STRING, ParameterMode.IN);
	                call1.addParameter(new QName(nameSpace,"in9"), XMLType.XSD_STRING, ParameterMode.IN);
	                call1.setReturnType(XMLType.XSD_STRING);

	                call1.setUseSOAPAction(true);
	                call1.setSOAPActionURI("http://zzwx/example");
	    			
	    			
	                result = (String) call1.invoke(new Object[] {regcode, password, 
	                		mobile,java.net.URLEncoder.encode(content,"gbk"),  //发送内容
	       					"",//Extnum 扩展子号码
	       					"1", //Level 发送优先级别（1-5级别递减）
	       					"", //Schdate 定时发送时间设置（格式：20150215132145） 
	       					"1", //Reportflag 是否要状态报告（0：需要，1：不需要）
	       					"", //wapUrl 保留参数
	       					"4"//smstype 信息类型（普通短信：0；长短信：4）
	       					}); 
	               
	                b = result.getBytes("8859_1");
		            String name = new String(b, "GBK"); //转换成GBK字符
		            
		            if(name.equals("0")){  //发生成功
 		            	isSentOk=true;
                         return true;
		            }else{	
		            	isSentOk=false;
		            	if(index<sendTimes){
		            		//do nothing
		            	}else{
		            		String ret=resultMap.get(name.trim());
		            		if(ret!=null){
		            			msg.append(ret);
 		            		}else{
		            			msg.append(name);
		            		}
		            		return false;
		            	}
		            }
		           
		        }
 		        catch(Exception ex){
 		        	System.out.println("ex----");
		        	isSentOk=false;
		        }finally{
		        	
		        }
	        }// while end
	        return false;
	    }

}
