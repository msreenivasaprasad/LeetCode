
public class AR_Minimum_Cost_of_Buying_Candies_With_Discount {
	public static void main(String[] args) {
		System.out.println(capitalizeTitle("First leTTeR of EACH Word"));
	}

	public static String capitalizeTitle(String title) {
		String res = new String();
		String[] words = title.split("\\W+");
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].toLowerCase();
			if (words[i].length() >= 3) {
				words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
			}
			if (i != words.length - 1) {
				res += words[i] + " ";
			}
		}
		res += words[words.length - 1];
		return res;
	}
}
