import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class DP_Partition_Equal_Subset_Sum {
	public static void main(String[] args) {
		int[] nums = new int[200];
		Random r = new Random(100);
		for (int i = 0; i < nums.length; i++) {
			nums[i] = r.nextInt();
		}
		System.out.println(canPartition(nums));
	}

	public static boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0) {
			return false;
		}
		int req = sum / 2;
		Set<Integer> count = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			Set<Integer> temp = new HashSet<Integer>();
			Iterator<Integer> k = count.iterator();
			while (k.hasNext()) {
				int t = k.next() + nums[i];
				if (t <= req) {
					temp.add(t);
				}
				if (t == req) {
					return true;
				}
			}
			temp.add(nums[i]);
			if (nums[i] == req) {
				return true;
			}
			Iterator<Integer> k2 = temp.iterator();
			while (k2.hasNext()) {
				count.add(k2.next());
			}
		}
		Iterator<Integer> k = count.iterator();
		while (k.hasNext()) {
			if (k.next() == req) {
				return true;
			}
		}
		return false;

	}
}
