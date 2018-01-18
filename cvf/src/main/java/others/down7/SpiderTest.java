package others.down7;

import org.junit.Test;


public class SpiderTest {
	@Test
	public void testName() throws Exception {
		Spider spider = new Spider();
		String url = "http://list.jd.com/list.html?cat=9987,653,655";
		spider.setDownloadable(new HttpClientDownable());
		//下载页面
		Page page = spider.download(url);
		//获取页面所有内容
		spider.setProcessable(new JDProcessable());
		spider.process(page);
		for (String s : page.getUrls()) {
			System.out.println(s);
		}
//		System.out.println(page.getValues().get("spec"));
		spider.setStoreable(new ConsoleStoreable());
		spider.store(page);
	}
}
