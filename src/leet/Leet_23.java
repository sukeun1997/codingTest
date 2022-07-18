package leet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k Sorted Lists
 */
public class Leet_23 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /*public ListNode mergeKLists(ListNode[] lists) {

        int length = lists.length;
        ListNode base = new ListNode(0);
        ListNode cur = base;

        while (true) {
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                min = Math.min(lists[i].val, min);
            }

            if (min == Integer.MAX_VALUE) {
                break;
            }

            int l = 0;
            while (l < length) {
                if (lists[l] != null) {
                    int a = lists[l].val;

                    if (a == min) {
                        cur.next = new ListNode(a);
                        cur = cur.next;
                        lists[l] = lists[l].next;
                    }
                }
                l++;
            }
        }

        return base.next;
    }*/

    /**
     * 우선순위큐 풀이
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            while (list != null) {
                queue.add(list);
                list = list.next;
            }
        }

        ListNode base = new ListNode(0);
        ListNode cur = base;


        while (!queue.isEmpty()) {

            ListNode poll = queue.poll();

            cur.next = new ListNode(poll.val);
            cur = cur.next;
        }

        return base.next;
    }


    @Test
    void test() {
        Assertions.assertEquals(mergeKLists(new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                        new ListNode(2, new ListNode(6))
                }), new ListNode(3));
    }
}
