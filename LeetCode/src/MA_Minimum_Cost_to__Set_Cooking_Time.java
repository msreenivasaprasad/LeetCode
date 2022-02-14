import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MA_Minimum_Cost_to__Set_Cooking_Time {
	public static void main(String[] args) {
		System.out.println(minCostSetTime(1, 9403, 9402, 6008));

	}

	public static int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
		int[] poss = generateAll(targetSeconds);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < poss.length; i++) {
			int t = findCost(startAt, moveCost, pushCost, poss[i]);
			if (i == 0 && t != -1) {
				min = t;
			}
			if (t != -1) {
				min = Integer.min(t, min);
			}
		}
		return min;
	}

	public static int findCost(int start, int move, int push, int num) {
		int[] digits = todigits(num);
		if (digits.length > 4) {
			return -1;
		}
		int cost = 0;
		if (digits[0] == start) {
			cost += push;
		} else {
			cost += push + move;
		}
		for (int i = 1; i < digits.length; i++) {
			if (digits[i] == digits[i - 1]) {
				cost += push;
			} else {
				cost += push + move;
			}
		}
		return cost;
	}

	public static int[] todigits(int num) {
		List<Integer> res = new ArrayList<Integer>();
		while (num > 0) {
			res.add(num % 10);
			num /= 10;
		}
		Collections.reverse(res);
		int[] result = new int[res.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = res.get(i);
		}

		return result;
	}

	public static int[] generateAll(int target) {
		List<Integer> res = new ArrayList<Integer>();
		if (target < 60) {
			res.add(target);
		} else if (target >= 60 && target <= 99) {
			res.add(new Integer(target));
			res.add(new Integer(100 + target - 60));
		} else {
			int mins = target / 60;
			int remsec = target - (mins * 60);
			res.add(new Integer((mins * 100) + remsec));
			if (remsec + 60 <= 99) {
				mins--;
				remsec += 60;
				res.add(new Integer((mins * 100) + remsec));
			}
		}
		int[] result = new int[res.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = res.get(i);
		}
		return result;
	}
}
