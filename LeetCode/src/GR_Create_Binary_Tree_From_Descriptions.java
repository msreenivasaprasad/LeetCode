public class GR_Create_Binary_Tree_From_Descriptions {
	public static void main(String[] args) {

	}

	public static TreeNode createBinaryTree(int[][] descriptions) {
		leftchilds = new int[10001];
		rightchilds = new int[10001];
		boolean[] isroot = new boolean[10001];
		for (int i = 0; i < descriptions.length; i++) {
			isroot[descriptions[i][1]] = true;
			if (descriptions[i][2] == 1) {
				leftchilds[descriptions[i][0]] = descriptions[i][1];
			} else {
				rightchilds[descriptions[i][0]] = descriptions[i][1];
			}
		}
		int root = 0;
		for (int i = 1; i < isroot.length; i++) {
			if (!isroot[i] && (leftchilds[i] != 0 || rightchilds[i] != 0)) {
				root = i;
				break;
			}
		}
		return help(root);
	}

	static int[] leftchilds;
	static int[] rightchilds;

	public static TreeNode help(int root) {
		TreeNode res = new TreeNode(root);
		if (leftchilds[root] != 0) {
			res.left = help(leftchilds[root]);
		}
		if (rightchilds[root] != 0) {
			res.right = help(rightchilds[root]);
		}
		return res;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}