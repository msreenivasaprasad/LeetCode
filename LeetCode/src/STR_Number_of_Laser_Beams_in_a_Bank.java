public class STR_Number_of_Laser_Beams_in_a_Bank {
	public static void main(String[] args) {
		String[] bank = { "000", "111", "000" };
		System.out.println(numberOfBeams(bank));
	}

	public static int numberOfBeams(String[] bank) {
		int prev = 0;
		int res = 0;
		for (int i = 0; i < bank.length; i++) {
			int num = 0;
			for (int j = 0; j < bank[0].length(); j++) {
				if (bank[i].charAt(j) == '1') {
					num++;
				}
			}
			if (num != 0) {
				res += (prev * num);
				prev = num;
			}
		}
		return res;
	}
}
