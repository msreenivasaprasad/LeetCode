import java.util.ArrayList;
import java.util.List;

public class AR_Filter_Restaurants_by_Vegan_Friendly_Price_and_Distance {
	public static void main(String[] args) {
		int[][] nums = { { 5381, 42893, 0, 41516, 75892 }, { 39690, 32224, 1, 13232, 71333 },
				{ 80137, 75889, 0, 32126, 28857 }, { 2671, 31951, 1, 9481, 35136 }, { 72248, 9296, 0, 2820, 83281 } };
		System.out.println(filterRestaurants(nums, 0, 38119, 98400));

	}

	public static List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice,
			int maxDistance) {
		List<Integer> res = new ArrayList<Integer>();
		sort(restaurants);
		for (int i = 0; i < restaurants.length; i++) {
			if ((veganFriendly == 0 || restaurants[i][2] == 1) && restaurants[i][3] <= maxPrice
					&& restaurants[i][4] <= maxDistance) {
				res.add(restaurants[i][0]);
			}
		}
		return res;
	}

	public static void sort(int[][] nums) {
		for (int i = nums.length - 1; i >= 0; i--) {
			for (int j = 1; j <= i; j++) {
				if (nums[j][1] > nums[j - 1][1]) {
					int[] temp = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = temp;
				} else if (nums[j][1] == nums[j - 1][1] && nums[j][0] > nums[j - 1][0]) {
					int[] temp = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = temp;
				}
			}
		}
	}
}
