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
        if(head==null){
            return head;
        }
        Node temp=head;
        Map<Node,Node> hm=new HashMap<>();
        while(temp!=null){
            Node copy=new Node(temp.val);
            hm.put(temp,copy);
            temp=temp.next;
        }
        temp=head;
        
        while(temp!=null){
            Node copy=hm.get(temp);
            copy.next=hm.get(temp.next);
            copy.random=hm.get(temp.random);
            temp=temp.next;
        }
        return hm.get(head);
    }
}