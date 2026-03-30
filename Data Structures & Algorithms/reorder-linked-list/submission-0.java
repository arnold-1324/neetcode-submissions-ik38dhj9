/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode SecHead=slow.next,prev=null;
        slow.next=null;
        while(SecHead!=null)
        {
            ListNode next=SecHead.next;
            SecHead.next=prev;
            prev=SecHead;
            SecHead=next;
        }
        SecHead=prev;
        slow=head;
        while(SecHead!=null)
        {
            ListNode fnxt=slow.next,snxt=SecHead.next;
            slow.next=SecHead;
            SecHead.next=fnxt;
            slow=fnxt;
            SecHead=snxt;
        }
    }
}
