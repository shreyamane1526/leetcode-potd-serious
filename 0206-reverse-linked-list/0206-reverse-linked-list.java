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
    }
}