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
    public ListNode swapAndJoin(ListNode odd,ListNode even){
        ListNode startOdd=odd;
        ListNode startEven=even;
        while(odd!=null && even!=null){
            ListNode temp=even.next;
            if(temp==null  ){
                break;
            }
            odd.next=temp;
            odd=temp;
            if(temp.next==null ){
                break;
            }
            even.next=temp.next;   
            even=temp.next;
                    
        }
        even.next=null;
        odd.next=startEven;
        return startOdd;
    }
    public ListNode oddEvenList(ListNode head) {
        if(head==null ||head.next==null || head.next.next==null){
            return head;
        }
        ListNode odd=head;
        ListNode even=head.next;
        return swapAndJoin(odd,even);
    }
}