public class STR_Check_if_Binary_String_Has_at_Most_One_Segment_of_Ones {
	public static void main(String[] args) {
		System.out.println(checkOnesSegment("100001"));
	}

	public static boolean checkOnesSegment(String s) {
		boolean flag = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0' && !flag) {
				flag = true;
			} else if (flag && s.charAt(i) == '1') {
				return false;
			}
		}
		return true;
	}
}
