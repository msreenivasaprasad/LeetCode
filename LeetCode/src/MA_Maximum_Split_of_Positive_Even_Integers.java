import java.util.ArrayList;
import java.util.List;

public class MA_Maximum_Split_of_Positive_Even_Integers {
	public static void main(String[] args) {
		System.out.println(maximumEvenSplit(28));
	}

	public static List<Long> maximumEvenSplit(long finalSum) {
		long sum = 0;
		List<Long> res = new ArrayList<Long>();
		if (finalSum % 2 != 0) {
			return res;
		}
		for (long i = 2; i < finalSum; i += 2) {
			sum += i;
			res.add(i);
			if (sum >= finalSum) {
				break;
			}
		}
		if (sum > finalSum) {
			res.remove(sum - finalSum);
		}
		return res;
	}

}