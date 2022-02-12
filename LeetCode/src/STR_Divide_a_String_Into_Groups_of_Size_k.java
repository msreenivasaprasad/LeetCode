import java.util.ArrayList;
import java.util.List;

public class STR_Divide_a_String_Into_Groups_of_Size_k {
	public static void main(String[] args) {
		String[] res = divideString("abcdefghij", 3, 'x');
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	public static String[] divideString(String s, int k, char fill) {
		List<String> res = new ArrayList<String>();
		int i = 0;
		for (i = k; i <= s.length(); i += k) {
			res.add(s.substring(i - k, i));
		}
		if (s.length() % k != 0) {
			String temp = s.substring(i - k);
			for (int j = temp.length(); j < k; j++) {
				temp += Character.toString(fill);
			}
			res.add(temp);
		}

		String[] result = new String[res.size()];
		for (int j = 0; j < result.length; j++) {
			result[j] = res.get(j);
		}
		return result;
	}
}

