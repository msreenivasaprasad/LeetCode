public class STR_Robot_Return_to_Origin {
	public static void main(String[] args) {
		System.out.println("Hello World");
	}

	public boolean judgeCircle(String moves) {
		int x = 0, y = 0;
		for (int i = 0; i < moves.length(); i++) {
			if (moves.charAt(i) == 'L') {
				y--;
			} else if (moves.charAt(i) == 'U') {
				x--;
			} else if (moves.charAt(i) == 'D') {
				x++;
			} else {
				y++;
			}
		}
		return x == 0 && y == 0;
	}
}