public class DS_Merge_In_Between_Linked_Lists {
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		ListNode head2 = new ListNode(1000);
		head2.next = new ListNode(10001);
		head2.next.next = new ListNode(10001);
		ListNode res = mergeInBetween(head, 0, 4, head2);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		ListNode temp = list1;
		if (a == 0) {
			while (b >= 0) {
				list1 = list1.next;
				b--;
			}
			ListNode tempoo = list2;
			while (list2.next != null) {
				list2 = list2.next;
			}
			list2.next = list1;
			return tempoo;
		}
		while (a > 1) {
			temp = temp.next;
			a--;
			b--;
		}
		ListNode tempo = temp;
		while (b >= 0) {
			tempo = tempo.next;
			b--;
		}
		temp.next = list2;
		while (list2.next != null) {
			list2 = list2.next;
		}

		list2.next = tempo;
		return list1;
	}
}