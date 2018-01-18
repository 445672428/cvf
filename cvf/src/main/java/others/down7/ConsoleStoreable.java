package others.down7;


public class ConsoleStoreable implements Storeable{

	public void store(Page page) {
		System.out.println(page.getUrl()+"--"+page.getValues().get("price"));
	}

}
