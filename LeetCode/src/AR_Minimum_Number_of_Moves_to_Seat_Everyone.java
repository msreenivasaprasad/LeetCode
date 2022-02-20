import java.util.Arrays;

public class AR_Minimum_Number_of_Moves_to_Seat_Everyone {
	public static void main(String[] args) {
		int[] seats = { 2, 2, 6, 6 };
		int[] students = { 1, 3, 2, 6 };
		System.out.println(minMovesToSeat(seats, students));
	}

	public static int minMovesToSeat(int[] seats, int[] students) {
		int res = 0;
		Arrays.sort(seats);
		Arrays.sort(students);
		for (int i = 0; i < seats.length; i++) {
			res += Math.abs(seats[i] - students[i]);
		}
		return res;
	}

}
