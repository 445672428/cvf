package others.crawl;

import java.io.UnsupportedEncodingException;

public class ImageCrawl {
	public static void main(String[] args) throws UnsupportedEncodingException {
		         String userName = "仙桃市丶冯虹";
		         String password = "czb199345";
		         String loginUrl = "http://www.zhenhao2016.com/member.php?mod=logging&action=login&loginsubmit=yes&infloat=yes&lssubmit=yes&inajax=1";
		         String dataUrl = "http://home.cnblogs.com/";
		         HttpClientLogin(userName, password, loginUrl, dataUrl);
		     }

	private static void HttpClientLogin(String userName, String password,
			String loginUrl, String dataUrl) throws UnsupportedEncodingException {
		
	}
}
