import java.util.HashSet;
import java.util.Set;

public class DS_Remove_Duplicates_from_Sorted_List_II {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(4);
		ListNode res = deleteDuplicates(head);
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		Set<Integer> duplicates = new HashSet<Integer>();
		ListNode temp = head;
		int prev = 101;
		while (temp != null) {
			if (temp.val == prev) {
				duplicates.add(prev);
			}
			prev = temp.val;
			temp = temp.next;
		}
		if (duplicates.contains(head.val)) {
			while (head != null && duplicates.contains(head.val)) {
				head = head.next;
			}
		}
		ListNode prevNode = head;
		if (head == null) {
			return null;
		}
		temp = head.next;
		while (temp != null) {
			if (!duplicates.contains(temp.val)) {
				prevNode.next = temp;
				prevNode = temp;
			}
			temp = temp.next;
		}
		prevNode.next = null;
		return head;
	}
}