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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.of(3, 2, 0, -4);
        head.next.next.next.next = head.next;
        System.out.println(s.hasCycle(head));
        System.out.println(s.hasCycle(ListNode.of(1)));
    }
}
