/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
//         ListNode slow=head,fast=head;
//         while(fast!=null && fast.next!=null){
//             slow=slow.next;
//             fast=fast.next.next;
//             if(fast==null){
//                 return null;
//             }
//             if(fast==slow){
//                 slow=head;
//                 while(slow!=fast){
//                     slow=slow.next;
//                     fast=fast.next;
//                 }
//                 return slow;
//             }
//         }
//         return null;

    HashMap<ListNode,Integer> hm=new HashMap<>();
    ListNode cur=head;
    int c=0;
    while(cur!=null){
        if(!hm.containsKey(cur)){
            hm.put(cur,++c);
        }
        else{
            return cur;
        }
        cur=cur.next;
    }
    return null;
    }
}