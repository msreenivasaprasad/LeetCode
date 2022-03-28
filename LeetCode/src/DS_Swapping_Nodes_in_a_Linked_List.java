public class DS_Swapping_Nodes_in_a_Linked_List {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode res = swapNodes(head, 1);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public static ListNode swapNodes(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		int len = 0;
		ListNode temp = head;
		while (temp != null) {
			len++;
			temp = temp.next;
		}
		int end = len - k;
		ListNode tempo = head;
		while (k != 1) {
			tempo = tempo.next;
			k--;
		}
		ListNode temp2 = head;
		while (end != 0) {
			temp2 = temp2.next;
			end--;
		}
		int tempvar = tempo.val;
		tempo.val = temp2.val;
		temp2.val = tempvar;
		return head;
	}
}
