public class MA_Minimum_Moves_to_Reach_Target_Score {
	public static void main(String[] args) {
		System.out.println(minMoves(342556637, 0));
	}

	public static int minMoves(int target, int maxDoubles) {
		int count = 0;
		while (target > 1) {
			if (maxDoubles == 0) {
				count += target - 1;
				return count;
			}
			if (target % 2 == 0 && maxDoubles > 0) {
				maxDoubles--;
				target /= 2;
			} else {
				target--;
			}
			count++;
		}
		return count;
	}
}