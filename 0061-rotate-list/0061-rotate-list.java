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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null){
            return head;
        }
        ListNode temp=head;
        ListNode tail=temp;
        int len=0;
        while(temp!=null){
            len++;
            tail=temp;
            temp=temp.next;      
        }
        k=k%len;
        if(k==0){
            return head;
        }
        int dif=len-k;
        tail.next=head;
        temp=head;
        for(int i=1;i<dif;i++){
            temp=temp.next;
        }
        ListNode start=temp.next;
        temp.next=null;
        return start;
    }
}