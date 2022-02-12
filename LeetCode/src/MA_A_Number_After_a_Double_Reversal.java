public class MA_A_Number_After_a_Double_Reversal {
	public static void main(String[] args) {
		System.out.println(isSameAfterReversals(00));
	}

	public static boolean isSameAfterReversals(int num) {
		if (num == 0) {
			return true;
		}
		return !(num % 10 == 0);
	}
}
