/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
       if(head==null) return null;
       insertCopyBtw(head);
       ConnectCopywithRand(head); 
       return GetDeepCopy(head);
    }

    private void insertCopyBtw(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            Node next=temp.next;
            Node copyNode=new Node(temp.val);
            temp.next=copyNode;
            copyNode.next=next;
            temp=copyNode.next;
        }
    }

    private void ConnectCopywithRand(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            Node copyNode=temp.next;
            if(temp.random!=null)copyNode.random=temp.random.next;
            else copyNode.random=null;
            temp=copyNode.next;
        }
    }

    private Node GetDeepCopy(Node head)
    {
        Node temp=head;
        Node dummy=new Node(0);
        Node res=dummy;
        while(temp!=null)
        {
            res.next=temp.next;
            res=res.next;
            temp.next=temp.next.next;
            temp=temp.next;
        }
        return dummy.next;
    }
}
