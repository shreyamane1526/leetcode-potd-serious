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
    }
}