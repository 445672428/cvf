package others.demo.jsajax;

public class StringTest {
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		String a = "abc";
		String b = "abc";
		String c = new String("abc");
		String d = "ab"+"c";
		System.out.println(c==d);
		
	}
}
