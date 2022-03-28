public class DS_Odd_Even_Linked_List {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode res = oddEvenList(head);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public static ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		int i = 1;
		ListNode oddHead = new ListNode(head.val);
		ListNode tempo = oddHead;
		ListNode evenHead = new ListNode(head.next.val);
		head = head.next.next;
		ListNode temp = evenHead;
		while (head != null) {
			if (i % 2 != 0) {
				oddHead.next = new ListNode(head.val);
				oddHead = oddHead.next;
			} else {
				evenHead.next = new ListNode(head.val);
				evenHead = evenHead.next;
			}
			i++;
			head = head.next;
		}
		oddHead.next = temp;
		return tempo;
	}
}
