package datastructures.list.linked;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }
        head = previous;

        return head;
    }
}
