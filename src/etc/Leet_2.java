package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Add Two Numbers
 */


public class Leet_2 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode base = new ListNode(0);
        ListNode cur = base;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = 0, b = 0;
            if (l1 != null) {
                a = l1.val;
            }

            if (l2 != null) {
                b = l2.val;
            }

            int sum = carry + a + b;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;

            l1 = l1.next;
            l2 = l2.next;
        }


        return base.next;
    }


    @Test
    void tset() {
        Assertions.assertEquals(
                addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4)))), new ListNode(7, new ListNode(0, new ListNode(8))));
    }
}
