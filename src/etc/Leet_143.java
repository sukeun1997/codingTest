package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Reorder List
 */
public class Leet_143 {
    public class ListNode {
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


    public void reorderList(ListNode head) {

        ArrayList<ListNode> list = new ArrayList<>();

        ListNode end = head;
        while (end != null) {
            list.add(end);
            end = end.next;
        }

        end = head;
        int count  = 1;
        int hi = list.size() - 1;
        while (count < list.size()) {

            if (count % 2 == 1) {
                end.next = list.get(hi);
                hi--;
            } else {
                end.next = list.get(count / 2);
            }
            end = end.next;
            count++;
        }

        end.next = null;

    }


    @Test
    void tset() {
//        reorderList(new ListNode(1 , new ListNode(2 , new ListNode(3 , new ListNode(4)))));
        reorderList(new ListNode(1 , new ListNode(2 , new ListNode(3 , new ListNode(4 , new ListNode(5))))));
    }

}
