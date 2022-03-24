public class DS_Remove_Linked_List_Elements {
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(3);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
		ListNode res = removeElements(null, 5);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public static ListNode removeElements(ListNode head, int val) {
		while (head != null && head.val == val) {
			head = head.next;
		}
		ListNode temp = head;
		ListNode prev = head;
		while (temp != null) {
			if (temp.val == val) {
				while (temp != null && temp.val == val) {
					temp = temp.next;
				}
				prev.next = temp;
			}
			prev = temp;
			if (temp != null) {
				temp = temp.next;
			}

		}
		return head;
	}

}