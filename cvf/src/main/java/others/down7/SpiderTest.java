package others.down7;



public class SpiderTest {
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
		}
		spider.setStoreable(new ConsoleStoreable());
		spider.store(page);
	}
}
