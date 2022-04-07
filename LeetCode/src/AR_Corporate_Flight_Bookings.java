public class AR_Corporate_Flight_Bookings {
	public static void main(String[] args) {
		int[][] nums = { { 1, 2, 10 }, { 2, 2, 15 } };
		int[] res = corpFlightBookings(nums, 2);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public static int[] corpFlightBookings(int[][] bookings, int n) {
		int[] count = new int[n];
		for (int i = 0; i < bookings.length; i++) {
			for (int j = bookings[i][0] - 1; j <= bookings[i][1] - 1; j++) {
				count[j] += bookings[i][2];
			}
		}
		return count;
	}
}
