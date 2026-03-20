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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int c=0;
        ListNode temp=head;
        ListNode cur=temp;
            if(n==1 && cur.next==null){
                head=null;
                return head;
            }
        while(cur!=null){
            c++;
            if(n==1 && cur.next.next==null){
                cur.next=null;
                return head;
            }
            
            if(c>n+1){
                temp=temp.next;
            }
            cur=cur.next;
        }
        if(c==n && temp==head){
            head=head.next;
            return head;
        }
        else{
            ListNode store=temp.next;
            temp.next=temp.next.next;
            store=null;
            return head;
        }
    }
}