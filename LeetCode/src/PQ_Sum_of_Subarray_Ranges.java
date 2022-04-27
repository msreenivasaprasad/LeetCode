import java.util.Collections;
import java.util.PriorityQueue;

public class PQ_Sum_of_Subarray_Ranges {
	public static void main(String[] args) {
		int[] nums = { 4, -2, -3, 4, 1 };
		System.out.println(subArrayRanges(nums));
	}

	public static long subArrayRanges(int[] nums) {
		long res = 0;
		PriorityQueue<Long> max = new PriorityQueue<Long>(Collections.reverseOrder());
		PriorityQueue<Long> min = new PriorityQueue<Long>();
		for (int i = 0; i < nums.length; i++) {
			max.clear();
			min.clear();
			for (int j = i; j < nums.length; j++) {
				max.add((long) nums[j]);
				min.add((long) nums[j]);
				res += max.peek() - min.peek();
			}
		}
		return res;
	}
}
