public class DS_Convert_Binary_Number_in_a_Linked_List_to_Integer {
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		System.out.println(getDecimalValue(head));
	}

	public static int getDecimalValue(ListNode head) {
		int res = 0;
		int len = 0;
		ListNode temp = head;
		while (temp != null) {
			temp = temp.next;
			len++;
		}
		len--;
		while (head != null) {
			res += head.val * Math.pow(2, len--);
			head = head.next;
		}
		return res;
	}
}