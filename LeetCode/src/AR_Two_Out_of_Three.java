import java.util.ArrayList;
import java.util.List;

public class AR_Two_Out_of_Three {
	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2 };
		int[] nums2 = { 4, 3, 3 };
		int[] nums3 = { 5 };
		System.out.println(twoOutOfThree(nums1, nums2, nums3));
	}

	public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
		int[] count = new int[101];
		boolean[] not = new boolean[101];
		for (int i = 0; i < nums1.length; i++) {
			if (!not[nums1[i]]) {
				count[nums1[i]]++;
				not[nums1[i]] = true;
			}
		}
		for (int i = 0; i < not.length; i++) {
			not[i] = false;
		}
		for (int i = 0; i < nums2.length; i++) {
			if (!not[nums2[i]]) {
				count[nums2[i]]++;
				not[nums2[i]] = true;
			}
		}
		for (int i = 0; i < not.length; i++) {
			not[i] = false;
		}
		for (int i = 0; i < nums3.length; i++) {
			if (!not[nums3[i]]) {
				count[nums3[i]]++;
				not[nums3[i]] = true;
			}
		}
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < count.length; i++) {
			if (count[i] >= 2) {
				res.add(i);
			}
		}
		return res;
	}
}
