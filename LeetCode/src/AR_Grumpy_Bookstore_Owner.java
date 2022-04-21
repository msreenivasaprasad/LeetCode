public class AR_Grumpy_Bookstore_Owner {
	public static void main(String[] args) {
		int[] customers = { 1 };
		int[] grumpy = { 0 };
		System.out.println(maxSatisfied(customers, grumpy, 1));
	}

	public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
		int total = 0;
		int normal = 0;
		for (int i = 0; i < minutes; i++) {
			total += customers[i];
			if (grumpy[i] == 0) {
				normal += customers[i];
			}
		}
		int max = total - normal;
		for (int i = minutes; i < customers.length; i++) {
			total -= customers[i - minutes];
			if (grumpy[i - minutes] == 0) {
				normal -= customers[i - minutes];
			}
			total += customers[i];
			if (grumpy[i] == 0) {
				normal += customers[i];
			}
			max = Integer.max(max, total - normal);
		}

		for (int i = 0; i < customers.length; i++) {
			if (grumpy[i] == 0) {
				max += customers[i];
			}
		}
		return max;
	}
}
