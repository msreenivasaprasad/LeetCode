public class DS_Linked_List_in_Binary_Tree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(2);
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		System.out.println(isSubPath(head, root));
	}

	public static boolean isSubPath(ListNode head, TreeNode root) {
		return dfs(root, head);
	}

	public static boolean dfs(TreeNode root, ListNode head) {
		if (head == null && root == null) {
			return true;
		}
		if (head == null) {
			return false;
		}
		if (root == null) {
			return false;
		}
		if (help(head, root)) {
			return true;
		}
		if (help(head, root.left)) {
			return true;
		}
		if (help(head, root.right)) {
			return true;
		}
		return dfs(root.left, head) || dfs(root.right, head);
	}

	public static boolean help(ListNode head, TreeNode root) {
		if (root == null) {
			return head == null;
		}
		if (head == null) {
			return true;
		}
		if (head.val == root.val) {
			return help(head.next, root.left) || help(head.next, root.right);
		}
		return false;
	}
}
