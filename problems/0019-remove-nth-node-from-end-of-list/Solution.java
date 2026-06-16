import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) { this.val = val; }

    static ListNode of(int... vals) {
        ListNode dummy = new ListNode(0), cur = dummy;
        for (int v : vals) { cur.next = new ListNode(v); cur = cur.next; }
        return dummy.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (ListNode n = this; n != null; n = n.next) {
            sb.append(n.val);
            if (n.next != null) sb.append(",");
        }
        return sb.append("]").toString();
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        for (int i = 0; i <= n; i++) fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeNthFromEnd(ListNode.of(1, 2, 3, 4, 5), 2));
        System.out.println(s.removeNthFromEnd(ListNode.of(1, 2), 1));
    }
}
