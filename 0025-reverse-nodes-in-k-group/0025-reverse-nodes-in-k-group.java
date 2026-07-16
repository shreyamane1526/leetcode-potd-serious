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
    ListNode reverseSection(ListNode start,ListNode prev,int k){
        int cur=0;
        ListNode head=start;
        while(cur!=k){
            cur++;
            ListNode temp=start.next;
            start.next=prev;
            prev=start;
            if(cur==k){
                return start;
            }
            start=temp;
        }
        return null;
    }
    public ListNode reverseKGroup(ListNode head, int k){
        int cur=0;
        ListNode temp=head;
        ListNode start=head,prev=null;
        boolean first=true;
        while(temp!=null){
            cur++;
            ListNode next=temp.next;
            if(cur==k){               
               ListNode rev=reverseSection(start,null,k); 
               if(first){
                head=rev;
               }
               if(prev!=null){
                prev.next=rev;
               }
               prev=start;
               start=next;
               first=false;
               cur=0;
            }
            temp=next;
        }
        if(cur!=0){
            prev.next=start;
        }
        return head;
    }
}