public class STR_Delete_Characters_to_Make_Fancy_String {
	public static void main(String[] args) {
		System.out.println(makeFancyString("lldddll"));
	}

	public static String makeFancyString(String s) {
		char[] c = s.toCharArray();
		int last = 0;
		int count = 0;
		boolean[] ispresent = new boolean[c.length];
		int reslen = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == c[last]) {
				count++;
			} else {
				last = i;
				count = 1;
			}
			if (count <= 2) {
				ispresent[i] = true;
				reslen++;
			}
		}
		char[] result = new char[reslen];
		int k = 0;
		for (int i = 0; i < c.length; i++) {
			if (ispresent[i]) {
				result[k++] = c[i];
			}
		}
		return new String(result);
	}
}
