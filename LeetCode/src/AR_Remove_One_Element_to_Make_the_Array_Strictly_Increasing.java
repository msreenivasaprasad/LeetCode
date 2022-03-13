import java.util.ArrayList;
import java.util.List;

public class AR_Remove_One_Element_to_Make_the_Array_Strictly_Increasing {
	public static void main(String[] args) {
		int[] nums = { 105, 924, 32, 968 };
		System.out.println(canBeIncreasing(nums));
	}

	public static boolean canBeIncreasing(int[] nums) {
		List<Integer> count = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			count.add(nums[i]);
		}
		if (isOK(count)) {
			return true;
		}
		List<Integer> count2 = new ArrayList(count);
		for (int i = 1; i < count.size(); i++) {
			if (count.get(i) <= count.get(i - 1)) {
				count.remove(i - 1);
				count2.remove(i);
				break;
			}
		}
		if (isOK(count) || isOK(count2)) {
			return true;
		}
		return false;
	}

	public static boolean isOK(List<Integer> count) {
		for (int i = 1; i < count.size(); i++) {
			if (count.get(i) <= count.get(i - 1)) {
				return false;
			}
		}
		return true;
	}
}