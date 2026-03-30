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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head,prevlast=null;
        while(temp!=null)
        {
           ListNode kthNode=getKthNode(temp,k);
           if(kthNode==null)
           {
             if(prevlast!=null) prevlast.next=temp;
             break;
           }
        
        ListNode newNode=kthNode.next;
        kthNode.next=null;
        reverselList(temp);
        if(temp==head)
        {
            head=kthNode;
        }else
        {
            prevlast.next=kthNode;
        }
        prevlast=temp;
        temp= newNode;
    }
    return head;
    }

    private ListNode getKthNode(ListNode head,int k)
    {
        k-=1;
        while(head!=null && k>0)
        {
            k--;
            head=head.next;
        }
        return head;
    }

    private ListNode reverselList(ListNode head)
    {
        ListNode prev=null,curr=head;
        while(curr!=null)
        {
            ListNode nxt=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
}
