import java.util.HashSet;
import java.util.Set;

public class DS_Kth_Distinct_String_in_an_Array {
	public static void main(String[] args) {
		String[] arr = { "d", "b", "c", "b", "c", "a" };
		System.out.println(kthDistinct(arr, 2));

	}

	public static String kthDistinct(String[] arr, int k) {
		Set<String> dist = new HashSet<String>();
		int count = 0;
		Set<String> notdist = new HashSet<String>();
		for (int i = 0; i < arr.length; i++) {
			if (!dist.contains(arr[i])) {
				dist.add(arr[i]);
			} else if (dist.contains(arr[i])) {
				notdist.add(arr[i]);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (!notdist.contains(arr[i])) {
				count++;
			}
			if (count == k) {
				return arr[i];
			}
		}
		return "";
	}
}
