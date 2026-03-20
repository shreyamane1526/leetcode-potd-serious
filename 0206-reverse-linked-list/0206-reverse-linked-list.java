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
    public ListNode reverseList(ListNode head) {
        /*********************** naive tc=O(2*n) sc=O(n)
        if(head==null || head.next==null){
            return head;
        }
        ArrayDeque<Integer> s=new ArrayDeque<>();
        ListNode cur=head;
        while(cur!=null){
            s.push(cur.val);
            cur=cur.next;
        }
        cur=head;
        while(cur!=null){
            cur.val=s.pop();
            cur=cur.next;
        }
        return head;
        ****************/

        /**************better tc=O(1) swap approach 
        if(head==null || head.next==null){
            return head;
        }
        ListNode cur=head.next;
        ListNode prev=head;
        while(cur!=null){
            ListNode temp=cur.next;
            if(temp==null){
                cur.next=prev;
                head.next=null;
                return cur;
            }
            cur.next=prev;
            prev=cur;
            cur=temp;           
        }
        head.next=null;
        return cur;
        *************************/
        if(head==null || head.next==null){
            return head;
        }
        return reverse(head);

    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode newNode=reverse(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newNode;
    }
}