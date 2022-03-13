import java.util.Arrays;

public class STR_Check_If_a_String_Can_Break_Another_String {
	public static void main(String[] args) {
		System.out.println(checkIfCanBreak("leetcodee", "interview"));
	}

	public static boolean checkIfCanBreak(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		boolean flag = false;
		for (int i = 0; i < c1.length; i++) {
			if (c2[i] > c1[i]) {
				flag = true;
			}
		}
		if (!flag) {
			return true;
		}
		flag = false;
		for (int i = 0; i < c1.length; i++) {
			if (c1[i] > c2[i]) {
				flag = true;
			}
		}
		if (!flag) {
			return true;
		}
		return false;
	}
}