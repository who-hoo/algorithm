package leetcode;

class ListNode1 {

    int val;
    ListNode1 next;

    ListNode1() {
    }

    ListNode1(int val) {
        this.val = val;
    }

    ListNode1(int val, ListNode1 next) {
        this.val = val;
        this.next = next;
    }
}

public class RemoveDuplicates {

    public ListNode1 deleteDuplicates(ListNode1 head) {
        if (head == null) {
            return null;
        }
        ListNode1 newHead = new ListNode1(head.val);
        ListNode1 i = newHead;
        while (head != null) {
            if (i.val != head.val) {
                i.next = new ListNode1(head.val);
                i = i.next;
            }
            head = head.next;
        }
        return newHead;
    }

    public void test(ListNode1 head) {
        while (head != null) {
            System.out.printf("%d->", head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode1 n1 = new ListNode1(1);
        ListNode1 n2 = new ListNode1(1);
        ListNode1 n3 = new ListNode1(2);
        n1.next = n2;
        n2.next = n3;

        RemoveDuplicates solution = new RemoveDuplicates();
        ListNode1 removed = solution.deleteDuplicates(n1);
        solution.test(removed);
    }
}
