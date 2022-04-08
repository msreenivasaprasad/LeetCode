import java.util.ArrayList;
import java.util.List;

public class MA_Fraction_Addition_and_Subtraction {
	public static void main(String[] args) {
		System.out.println(fractionAddition("10/9-4/1+10/9-9/10+4/3"));
	}

	public static String fractionAddition(String expression) {
		List<Integer> nums = new ArrayList<Integer>();
		List<Integer> dens = new ArrayList<Integer>();
		if (expression.charAt(0) != '-') {
			if (expression.charAt(0) != '1') {
				nums.add((expression.charAt(0) - '0'));
			} else {
				if (1 < expression.length() && expression.charAt(1) == '0') {
					nums.add((10));
				} else {
					nums.add((expression.charAt(0) - '0'));
				}
			}
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '-') {
				if (expression.charAt(i + 1) != '1') {
					nums.add(-(expression.charAt(i + 1) - '0'));
				} else {
					if (i + 2 < expression.length() && expression.charAt(i + 2) == '0') {
						nums.add(-(10));
					} else {
						nums.add(-(expression.charAt(i + 1) - '0'));
					}
				}

			} else if (expression.charAt(i) == '+') {
				if (expression.charAt(i + 1) != '1') {
					nums.add((expression.charAt(i + 1) - '0'));
				} else {
					if (i + 2 < expression.length() && expression.charAt(i + 2) == '0') {
						nums.add((10));
					} else {
						nums.add((expression.charAt(i + 1) - '0'));
					}
				}
			} else if (expression.charAt(i) == '/') {
				if (expression.charAt(i + 1) != '1') {
					dens.add((expression.charAt(i + 1) - '0'));
				} else {
					if (i + 2 < expression.length() && expression.charAt(i + 2) == '0') {
						dens.add((10));
					} else {
						dens.add((expression.charAt(i + 1) - '0'));
					}
				}
			}
		}
		long lcm = 1;
		for (int i = 0; i < dens.size(); i++) {
			lcm *= dens.get(i);
		}
		long numer = 0;
		for (int j = 0; j < nums.size(); j++) {
			numer += (lcm / dens.get(j)) * nums.get(j);
		}
		if (numer == 0) {
			lcm = 1;
		}
		for (long i = Long.min(Math.abs(numer), lcm); i >= 1; i--) {
			if (numer % i == 0 && lcm % i == 0) {
				numer = numer / i;
				lcm = lcm / i;
			}
		}
		return Long.toString(numer) + "/" + Long.toString(lcm);
	}
}