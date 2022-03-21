
import java.util.ArrayList;
import java.util.List;

public class AR_Create_Target_Array_in_the_Given_Order {
	public static void main(String[] args) {
		System.out.println("Hello World");
	}

	public static int[] createTargetArray(int[] nums, int[] index) {
		List<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			res.add(index[i], nums[i]);
		}
		int[] result = new int[res.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = res.get(i);
		}
		return result;
	}
}