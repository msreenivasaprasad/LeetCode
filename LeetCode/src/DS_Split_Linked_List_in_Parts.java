public class DS_Split_Linked_List_in_Parts {
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

		ListNode[] res = splitListToParts(null, 5);
		for (int i = 0; i < res.length; i++) {
			ListNode temp = res[i];
			while (temp != null) {
				System.out.println(temp.val);
				temp = temp.next;
			}
			System.out.println();
		}
	}

	public static ListNode[] splitListToParts(ListNode head, int k) {
		int len = 0;
		ListNode temp = head;
		while (temp != null) {
			temp = temp.next;
			len++;
		}
		int size = len / k;
		temp = head;
		ListNode[] res = new ListNode[k];
		int[] result = new int[k];
		int sum = 0;
		for (int i = 0; i < result.length; i++) {
			result[i] = size;
			sum += size;
		}
		int i = 0;
		while (sum < len) {
			sum++;
			result[i++]++;
		}
		temp = head;
		for (i = 0; i < k; i++) {
			res[i] = temp;
			for (int j = 0; j < result[i] - 1; j++) {
				temp = temp.next;
			}
			if (temp != null) {
				ListNode pp = temp;
				temp = temp.next;
				pp.next = null;
			}
		}
		return res;
	}
}