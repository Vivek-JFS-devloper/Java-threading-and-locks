package in.ramesh;

public class LoopDetector {
	public static void main(String[] args) {
		
		int n = 5;
		
		for (int i = 1; i <= n; i++) {
			// spaces before numbers
			for (int s = 1; s <= n - i; s++) {
				System.out.print("  ");
			}
			// numbers in ascending order
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " ");
			}
			// numbers in descending order
			for (int j = i - 1; j >= 1; j--) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int v) {
		val = v;
	}

	public static boolean hasCycle(ListNode head) {

		ListNode slow = head, fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}
}
