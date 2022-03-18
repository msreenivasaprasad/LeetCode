public class AR_Slowest_Key {
	public static void main(String[] args) {
		int[] num = { 9, 29, 49, 50 };
		System.out.println(slowestKey(num, "cbcd"));
	}

	public static char slowestKey(int[] releaseTimes, String keysPressed) {
		int num = 0;
		char res = keysPressed.charAt(0);
		int max = 0;
		for (int i = 0; i < releaseTimes.length; i++) {
			if (releaseTimes[i] - num > max || (releaseTimes[i] - num == max && keysPressed.charAt(i) > res)) {
				max = releaseTimes[i] - num;
				res = keysPressed.charAt(i);
			}
			num = releaseTimes[i];
		}
		System.out.println(max);
		return res;
	}
}