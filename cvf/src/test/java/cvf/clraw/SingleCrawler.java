package cvf.clraw;


public class SingleCrawler {
	public static void main(String[] args) {
		downHyData1();
	}
	public static void downHyData1() {
		String a = "a.b.c.d";
		System.out.println(a.lastIndexOf("."));
		System.out.println(a.substring(a.lastIndexOf("."), a.length()));
	}
	public static void downHyData() {
	}
}
