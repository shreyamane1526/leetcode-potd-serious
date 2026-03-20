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
    public boolean hasCycle(ListNode head) {
        /**************  Naive Approach T.C. = O(n) , S.C. = O(n)
        Set<ListNode> s=new HashSet<>();
        ListNode cur=head;
        while(cur!=null){
            if(s.contains(cur)){
                return true;
            }
            s.add(cur);
            cur=cur.next;
        }
        return false;
        *****************/

        ListNode slow=head;
        ListNode fast=head;
        if(fast==null || fast.next==null ){
            return false;
        }
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==null){
                return false;
            }
            if(fast==slow){
                return true;
            }
            
        }
        return false;
    }
}