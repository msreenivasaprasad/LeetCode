public class DS_Merge_Nodes_in_Between_Zeros {
	public static void main(String[] args) {

	}

	public ListNode mergeNodes(ListNode head) {
		ListNode temp = head;
		temp = temp.next;
		int sum = 0;
		while (temp != null && temp.val != 0) {
			sum += temp.val;
			temp = temp.next;
		}
		temp = temp.next;
		ListNode resh = new ListNode(sum);
		sum = 0;
		ListNode tempo = resh;
		while (temp.next != null) {
			if (temp.val == 0) {
				ListNode tempp = new ListNode(sum);
				sum = 0;
				tempo.next = tempp;
				tempo = tempp;
			}
			sum += temp.val;
			temp = temp.next;
		}
		ListNode tempp = new ListNode(sum);
		sum = 0;
		tempo.next = tempp;
		tempo = tempp;
		return resh;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}