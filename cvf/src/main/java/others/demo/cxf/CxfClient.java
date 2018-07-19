package others.demo.cxf;

import java.net.URL;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class CxfClient {
	public static void main(String[] args) {
		//test();
		//test1();
	}
	public static void test1(){
		
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();  
        Client client = dcf.createClient(  
            "http://www.webxml.com.cn/WebServices/ValidateEmailWebService.asmx?wsdl");  
        Object[] res;
		try {
			res = client.invoke("ValidateEmailAddressPro");
		} catch (Exception e) {
			e.printStackTrace();
		}  
        
	}

	public static void test() {
//		String endpoint = "http://192.168.31.177:8090/ZyPrj/services/demo?wsdl";
//		String nameSpace = "http://services.web.txx.cn.com/";
		String endpoint = "http://www.webxml.com.cn/WebServices/RandomFontsWebService.asmx?wsdl";
		String nameSpace = "http://WebXml.com.cn/";
		
		Object obj = callWebserviceBack(endpoint, nameSpace, "ArrayOfString",
				new Object[] {"1"});
	}

	public static Object callWebserviceBack(String webServiceUrl,
			String targetNamespace, String methodName, Object[] params) {
		try {
			Service service = new Service();

			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new URL(webServiceUrl));
			call.setOperationName(new javax.xml.namespace.QName(
					targetNamespace, methodName));
			if ("DddJdcxfkInfo".equals(methodName)) {
				call.addParameter("Usermarker",
						org.apache.axis.encoding.XMLType.XSD_STRING,
						javax.xml.rpc.ParameterMode.IN);
				call.addParameter("Backinfo",
						org.apache.axis.encoding.XMLType.XSD_STRING,
						javax.xml.rpc.ParameterMode.IN);
			}

			call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
			call.setUseSOAPAction(true);
			call.setTimeout(1000 * 20); // 单位是毫秒

			return call.invoke(params);

		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
