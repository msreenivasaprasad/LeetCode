public class AR_Time_Needed_to_Buy_Tickets {
	public static void main(String[] args) {
		int[] tickets = { 2, 3, 2 };
		System.out.println(timeRequiredToBuy(tickets, 2));
	}

	public static int timeRequiredToBuy(int[] tickets, int k) {
		int sum = 0;
		for (int i = k - 1; i >= 0; i--) {
			sum += Integer.min(tickets[i], tickets[k]);
		}
		for (int i = k + 1; i < tickets.length; i++) {
			sum += Integer.min(tickets[i], tickets[k] - 1);
		}
		sum += tickets[k];
		return sum;
	}
}
