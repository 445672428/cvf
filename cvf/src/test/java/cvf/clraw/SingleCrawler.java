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
		//POST /member.php?mod=logging&action=login&loginsubmit=yes&infloat=yes&lssubmit=yes&inajax=1
		String loginUrl = "http://www.zhenhao2016.com/member.php?mod=logging&action=login&loginsubmit=yes&infloat=yes&lssubmit=yes&inajax=1";
		String downUrl = "http://www.zhenhao2016.com/member.php?mod=logging&action=login&loginsubmit=yes&infloat=yes&lssubmit=yes&username=%E4%BB%99%E6%A1%83%E5%B8%82%E4%B8%B6%E5%86%AF%E8%99%B9&password=czb199345";
		
	}
}
