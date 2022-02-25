public class DS_Maximum_Twin_Sum_of_a_Linked_List {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		// head.next = new ListNode(100000);
//		head.next.next = new ListNode(2);
//		head.next.next.next = new ListNode(3);
		System.out.println(pairSum(head));

	}

	public static int pairSum(ListNode head) {
		int length = 0;
		ListNode temp = head;
		while (temp != null) {
			temp = temp.next;
			length++;
		}
		int[] nums = new int[length / 2];
		temp = head;
		int mid = length / 2;
		int i = 0;
		while (temp != null && i < mid) {
			nums[i] = temp.val;
			temp = temp.next;
			i++;
		}
		while (temp != null && i < length) {
			nums[nums.length - 1 - i + mid] += temp.val;
			temp = temp.next;
			i++;
		}
		int max = 0;
		for (i = 0; i < nums.length; i++) {
			max = Integer.max(max, nums[i]);
		}
		return max;
	}
}