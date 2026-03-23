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
    public ListNode findMid(ListNode left){
        if(left==null || left.next==null || left.next.next==null){
            return left;
        }
        ListNode slow=left;
        ListNode fast=left.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    } 
    public ListNode merge(ListNode left,ListNode right){
        ListNode temp=new ListNode(-1),cur=temp;
        ListNode cur1=left,cur2=right;
        while(cur1!=null && cur2!=null){
            if(cur1.val<=cur2.val){
                temp.next=cur1;
                temp=temp.next;
                cur1=cur1.next;
            }
            else{
                temp.next=cur2;
                temp=temp.next;
                cur2=cur2.next;
            }
        }
        if(cur1!=null){
            temp.next=cur1;
        }
        else{
            temp.next=cur2;
        }
        return cur.next;
    }
    public ListNode mergeSort(ListNode left){
        if(left==null || left.next==null){
            return left;
        }
        ListNode mid=findMid(left);
        ListNode l=left;
        ListNode r=mid.next;
        mid.next=null;
        ListNode first=mergeSort(l);
        ListNode second=mergeSort(r);
        return merge(first,second);
    } 
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        return mergeSort(head);
    }
}