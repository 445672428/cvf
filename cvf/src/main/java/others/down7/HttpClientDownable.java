package others.down7;


public class HttpClientDownable implements Downloadable{

	public Page download(String url) {
		// TODO Auto-generated method stub
		Page page = new Page();
		page.setUrl(url);
		page.setContent(PageUtils.getContent(url));
		return page;
	}

}
