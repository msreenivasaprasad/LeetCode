public class DS_Delete_the_Middle_Node_of_a_Linked_List {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next.next.next.next = new ListNode(6);
		ListNode res = deleteMiddle(head);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public static ListNode deleteMiddle(ListNode head) {
		int len = 0;
		ListNode temp = head;
		while (temp != null) {
			len++;
			temp = temp.next;
		}
		if (len == 1) {
			return null;
		}
		int mid = len / 2;
		temp = head;
		for (int i = 0; i < mid - 1; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
		return head;
	}
}