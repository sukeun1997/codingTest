package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Leet_19 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(0);
        start.next = head;
        ListNode p = start;
        ListNode r = start;

        while (n > 0) {
            p = p.next;
            n--;
        }

        while (p.next != null) {
            r = r.next;
            p = p.next;
        }

        r.next = r.next.next;

        return start.next;

    }


    @Test
    void test() {
//        Assertions.assertEquals(removeNthFromEnd(new ListNode(1, new ListNode(2 , new ListNode(3, new ListNode(4, new ListNode(5))))), 2), 2);
//        Assertions.assertEquals(removeNthFromEnd(new ListNode(1, new ListNode(2 )), 1), 2);
        Assertions.assertEquals(removeNthFromEnd(new ListNode(1), 1), 2);
    }
}
