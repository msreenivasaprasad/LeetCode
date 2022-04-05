public class AR_Battleships_in_a_Board {
	public static void main(String[] args) {
		char[][] board = { { 'X', 'X', 'X' } };
		System.out.println(countBattleships(board));
	}

	public static int countBattleships(char[][] board) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		int res = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X' && !visited[i][j]) {
					vertical(board, i, j, visited);
					horizontal(board, i, j, visited);
					res++;
				}
			}
		}
		return res;
	}

	public static void horizontal(char[][] board, int i, int j, boolean[][] visited) {
		while (j < board[0].length && board[i][j] == 'X') {
			visited[i][j] = true;
			j++;
		}
	}

	public static void vertical(char[][] board, int i, int j, boolean[][] visited) {
		while (i < board.length && board[i][j] == 'X') {
			visited[i][j] = true;
			i++;
		}
	}
}
