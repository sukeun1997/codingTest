package leet;

public class Leet_234 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }


        slow = reverse(slow);

        while (slow != null) {
            if (slow.val != head.val) {
                return false;
            }

            slow = slow.next;
            head = head.next;
        }


        return true;

    }

    private ListNode reverse(ListNode slow) {

        ListNode prev = null;

        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        return prev;
    }


}
