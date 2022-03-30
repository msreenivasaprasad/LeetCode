public class DP_Jump_Game_VII {
	public static void main(String[] args) {
		System.out.println(canReach("00000000001", 1, 1));

	}

	public static boolean canReach(String s, int minJump, int maxJump) {

		boolean[] dynamic = new boolean[s.length()];
		dynamic[dynamic.length - 1] = s.charAt(s.length() - 1) == '0';
		int tcount = 0;
		char[] c = s.toCharArray();
		for (int i = c.length - 1 - minJump; i >= c.length - 1 - maxJump; i--) {
			dynamic[i] = dynamic[dynamic.length - 1] && c[i] == '0';
		}
		for (int i = c.length - 1 - (maxJump - minJump); i < c.length; i++) {
			if (dynamic[i]) {
				tcount++;
			}
		}
		for (int i = c.length - maxJump - 1; i >= 0; i--) {
			if (tcount > 0) {
				dynamic[i] = c[i] == '0';
			}
			if (dynamic[i + maxJump]) {
				tcount--;
			}
			if (dynamic[i + minJump - 1]) {
				tcount++;
			}
		}
		return dynamic[0];

	}
}
