import java.util.Stack;

public class DS_Reorder_List {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		reorderList(head);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static void reorderList(ListNode head) {
		int length = 0;
		ListNode ltemp = head;
		while (ltemp != null) {
			ltemp = ltemp.next;
			length++;
		}
		int t1 = length / 2;
		if (length % 2 != 0) {
			t1++;
		}
		Stack<ListNode> count = new Stack<ListNode>();
		ListNode temp = head;
		while (temp != null) {
			t1--;
			if (t1 < 0) {
				count.add(temp);
			}
			temp = temp.next;
		}

		int len = count.size();
		ListNode tempo = head;
		while (tempo != null && len > 0) {
			ListNode t = tempo.next;
			if (count.size() != 0) {
				tempo.next = count.pop();
			}
			tempo = tempo.next;
			tempo.next = t;
			len--;
			tempo = tempo.next;
		}
		tempo.next = null;
	}
}
