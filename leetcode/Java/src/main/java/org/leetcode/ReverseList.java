package org.leetcode;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null) {
            // save next
            next = curr.next;
            // reverse
            curr.next = prev;
            // move prev and curr
            prev = curr;
            curr = next;
        }
        return prev;

    }


}
