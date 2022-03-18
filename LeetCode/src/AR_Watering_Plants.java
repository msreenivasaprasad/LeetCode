public class AR_Watering_Plants {
	public static void main(String[] args) {
		int[] nums = { 1 };
		System.out.println(wateringPlants(nums, 8));
	}

	public static int wateringPlants(int[] plants, int capacity) {
		int rem = capacity;
		int res = 0;
		for (int i = 0; i < plants.length; i++) {
			if (rem < plants[i]) {
				res += i * 2;
				rem = capacity;
			}
			rem -= plants[i];
			res++;
		}
		return res;
	}
}