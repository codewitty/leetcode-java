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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseList(ListNode.of(1, 2, 3, 4, 5)));
    }
}
