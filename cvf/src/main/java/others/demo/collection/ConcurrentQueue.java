package others.demo.collection;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueue {
	private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	public static void main(String[] args) {
		for(int i = 0; i < 100; i ++){
			queue.add(i);
		}
		System.out.println("all:"+queue.size());
		Iterator<Integer> t = queue.iterator();
		while (t.hasNext()) {
			int s = t.next();
			System.out.println(s);
		}
	}
}
