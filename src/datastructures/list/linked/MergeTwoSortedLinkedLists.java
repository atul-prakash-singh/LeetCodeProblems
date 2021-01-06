package datastructures.list.linked;

public class MergeTwoSortedLinkedLists {

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedNode;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            mergedNode = l1;
            mergedNode.next = mergeTwoLists(l1.next, l2);
        } else {
            mergedNode = l2;
            mergedNode.next = mergeTwoLists(l1, l2.next);
        }

        return mergedNode;
    }
}
