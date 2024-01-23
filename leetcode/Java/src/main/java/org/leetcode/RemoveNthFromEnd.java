package org.leetcode;
import java.util.*;
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i=1;i<=n+1;i++){
            first = first.next;
        }
        while(first!=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;

    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveNthFromEnd solution = new RemoveNthFromEnd();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        ListNode result1 = solution.removeNthFromEnd(head1, 2);
        printList(result1);

        ListNode head2 = new ListNode(1);
        ListNode result2 = solution.removeNthFromEnd(head2, 1);
        printList(result2);

        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        ListNode result3 = solution.removeNthFromEnd(head3, 1);
        printList(result3);
    }


}
