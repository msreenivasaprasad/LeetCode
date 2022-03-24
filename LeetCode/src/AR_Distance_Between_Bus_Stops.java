public class AR_Distance_Between_Bus_Stops {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(distanceBetweenBusStops(nums, 1, 1));
	}

	public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
		int beg = start;
		int end = destination;
		start = Integer.min(beg, end);
		destination = Integer.max(beg, end);
		int dist1 = 0;
		for (int i = start; i < destination; i++) {
			dist1 += distance[i];
		}
		int dist2 = 0;
		for (int i = destination; i != start; i++) {
			if (i == distance.length) {
				i = 0;
			}
			if (i == start) {
				break;
			}
			dist2 += distance[i];
		}
		return Integer.min(dist1, dist2);
	}

}