package leetcode;

import java.util.HashSet;
import java.util.Set;

class ListNode2 {

    int val;
    ListNode2 next;

    ListNode2(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {

    public boolean hasCycle(ListNode2 head) {
        Set<ListNode2> nodeSet = new HashSet<>();
        while (head != null) {
            if (!nodeSet.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
