import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class DS_Remove_Stones_to_Minimize_the_Total {
	public static void main(String[] args) {
		int[] nums = { 1 };
		System.out.println(minStoneSum(nums, 3));

	}

	public static int minStoneSum(int[] piles, int k) {
		PriorityQueue<Integer> p = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (int i = 0; i < piles.length; i++) {
			p.add(piles[i]);
		}
		while (k > 0) {
			p.add(p.peek() - Math.floorDiv(p.poll(), 2));
			k--;
		}
		int sum = 0;
		Iterator<Integer> i = p.iterator();
		while (i.hasNext()) {
			sum += i.next();
		}
		return sum;
	}

}
