public class STR_Check_if_All_A_s_Appears_Before_All_B_s {
	public static void main(String[] args) {
		System.out.println(checkString("aaaba"));
	}

	public static boolean checkString(String s) {
		char[] c = s.toCharArray();
		boolean flag = false;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 'b' && !flag) {
				flag = true;
				continue;
			}
			if (c[i] == 'a' && flag) {
				return false;
			}

		}
		return true;

	}
}
