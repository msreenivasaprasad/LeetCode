
import java.util.ArrayList;
import java.util.List;

public class AR_Summary_Ranges {
	public static void main(String[] args) {
		int [] nums= {1,2,3,4,5,6,7};
		System.out.println(summaryRanges(nums).toString());
		
	}

	public static List<String> summaryRanges(int[] nums) {
		if (nums.length == 0) {
			return new ArrayList<String>();
		}
		if (nums.length == 1) {
			List<String> t = new ArrayList<String>();
			t.add(Integer.toString(nums[0]));
			return t;
		}
		int lastnum = nums[0];
		List<String> res = new ArrayList<String>();
		for (int i = 1; i < nums.length ; i++) {
			if (nums[i] != nums[i - 1] + 1) {
				if (lastnum != nums[i - 1]) {
					res.add(Integer.toString(lastnum) + "->" + Integer.toString(nums[i - 1]));

				} else {
					res.add(Integer.toString(lastnum));
				}
				lastnum = nums[i];
			}
		}
		if (lastnum != nums[nums.length - 1]) {
			res.add(Integer.toString(lastnum) + "->" + Integer.toString(nums[nums.length - 1]));

		} else {
			res.add(Integer.toString(lastnum));
		}
		return res;
	}
}
