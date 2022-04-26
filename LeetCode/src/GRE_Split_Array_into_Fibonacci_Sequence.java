import java.util.ArrayList;
import java.util.List;

public class GRE_Split_Array_into_Fibonacci_Sequence {
	public static void main(String[] args) {
		System.out.println(Math.log10(Integer.MAX_VALUE));
		System.out.println(Long.MAX_VALUE);
		System.out.println(splitIntoFibonacci("1"));
	}

	public static List<Integer> splitIntoFibonacci(String num) {
		System.out.println(num.length());
		List<Integer> res = new ArrayList<Integer>();
		help(num, 0, res);
		return res;
	}

	public static boolean help(String num, int index, List<Integer> count) {
		if (index >= num.length()) {
			return count.size() >= 3;
		}
		for (int i = index; i < num.length(); i++) {
			if (i + 1 - index <= 10) {
				long temp = Long.parseLong(num.substring(index, i + 1));
				if (temp <= Integer.MAX_VALUE) {
					if (count.size() < 2) {
						if (num.charAt(index) != '0') {
							count.add((int) temp);
							if (help(num, i + 1, count)) {
								return true;
							}
							count.remove(count.size() - 1);
						} else {
							if (i == index) {
								count.add(0);
								if (help(num, i + 1, count)) {
									return true;
								}
								count.remove(count.size() - 1);
							}
						}
					} else {
						if (num.charAt(index) != '0') {
							if (temp == (long) count.get(count.size() - 1) + (long) count.get(count.size() - 2)) {
								count.add((int) temp);
								if (help(num, i + 1, count)) {
									return true;
								}
								count.remove(count.size() - 1);
							}
						} else {
							if (i == index
									&& (long) count.get(count.size() - 1) + (long) count.get(count.size() - 2) == 0) {
								count.add(0);
								if (help(num, i + 1, count)) {
									return true;
								}
								count.remove(count.size() - 1);
							}
						}
					}
				}
			}
		}
		return false;
	}
}
