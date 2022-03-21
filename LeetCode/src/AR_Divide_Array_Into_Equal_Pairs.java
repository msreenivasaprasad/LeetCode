
public class AR_Divide_Array_Into_Equal_Pairs {
	public static void main(String[] args) {
		System.out.println("Hello World");
	}

	public boolean divideArray(int[] nums) {
		int[] count = new int[500];
		for (int i = 0; i < nums.length; i++) {
			count[nums[i] - 1]++;
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] % 2 != 0) {
				return false;
			}
		}
		return true;
	}

}