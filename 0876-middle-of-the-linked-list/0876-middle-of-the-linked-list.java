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
    public ListNode middleNode(ListNode head) {
        // Naive O(2n)
        //int c=0;
        // ListNode cur=head;
        // while(cur!=null){
        //     c++;
        //     cur=cur.next;
        // }
        // int mid=c/2+1;
        // c=0;
        // cur=head;
        // while(cur!=null){
        //     c++;
        //     if(c==mid){
        //         ListNode temp=cur;               
        //         return temp;
        //     }
        //     cur=cur.next;
        // }
        // return cur;

        //better O(n)
        if(head==null){
            return head;
        }
        ListNode cur=head;
        ListNode mid=head;
        int c=0;
        while(cur!=null){
            c++;
            if(c%2==0){
                mid=mid.next;
            }
            cur=cur.next;
        }
        return  mid;
    }
}