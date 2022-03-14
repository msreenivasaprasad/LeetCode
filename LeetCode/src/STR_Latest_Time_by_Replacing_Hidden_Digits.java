public class STR_Latest_Time_by_Replacing_Hidden_Digits {
	public static void main(String[] args) {
		System.out.println(maximumTime("00:0?"));
	}

	public static String maximumTime(String time) {
		char[] c = time.toCharArray();
		if (c[0] == '?') {
			if (c[1] == '?') {
				c[0] = '2';
			} else if (c[1] <= '3') {
				c[0] = '2';
			} else {
				c[0] = '1';
			}
		}
		if (c[1] == '?') {
			if (c[0] <= '1') {
				c[1] = '9';
			} else {
				c[1] = '3';
			}
		}
		if (c[3] == '?') {
			c[3] = '5';
		}
		if (c[4] == '?') {
			c[4] = '9';
		}
		return new String(c);
	}

}