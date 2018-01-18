package others.down7;

public interface Repository {

	String poll();

	void addHigh(String nextUrl);

	void add(String nextUrl);

}
