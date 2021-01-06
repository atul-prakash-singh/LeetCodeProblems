package datastructures.list.linked;

//https://leetcode.com/problems/palindrome-linked-list/
public class PalindromeLinkedList {

    public static void main(String[] args) {

    }

    private static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        // first pass
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalfStart = slow;
        if (fast != null) {
            secondHalfStart = slow.next;
        }

        ListNode pp = null;
        ListNode p = head;
        ListNode c = head.next;

        // second pass
        while (p != slow) {
            p.next = pp;
            pp = p;
            p = c;
            c = c.next;
        }

        // third pass
        while (secondHalfStart != null) {
            if (secondHalfStart.val != pp.val) {
                return false;
            }

            secondHalfStart = secondHalfStart.next;
            pp = pp.next;
        }

        return true;
    }
}
