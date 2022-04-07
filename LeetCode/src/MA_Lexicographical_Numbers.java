import java.util.ArrayList;
import java.util.List;

public class MA_Lexicographical_Numbers {
	public static void main(String[] args) {
		System.out.println(lexicalOrder(192));
	}

	public static List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<Integer>();
		int t = 1;
		while (res.size() < n) {
			res.add(t);
			t = findNext(t, n);
		}
		return res;
	}

	public static int findNext(int n, int max) {
		if (n * 10 <= max) {
			return n * 10;
		}
		if (n % 10 != 9 && n + 1 <= max) {
			return n + 1;
		}
		if (n % 10 == 9) {
			while (n % 10 == 9) {
				n = n / 10;
			}
			return n + 1;
		}
		n = n / 10;
		while (n % 10 == 9) {
			n = n / 10;
		}
		return n + 1;

	}

	public static int digits(int n) {
		return (int) Math.log10(n) + 1;
	}

}
