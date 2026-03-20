/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode firstOverlap(ListNode curA,ListNode curB,int dif){           
            ListNode cur=curA;
            int c=0;
            while(cur!=null){                
                if(c==dif){
                    break;
                }
                c++;
                cur=cur.next;
            }
            curA=cur;
            while(curA!=null && curB!=null){
                if(curA==curB){
                    return curA;
                }
                curA=curA.next;
                curB=curB.next;
            }
            return null;
    }
    public int findLength(ListNode head){
        int c=0;
        ListNode cur=head;
         while(cur!=null){
            c++;
            cur=cur.next;
        }
        return c;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){      
        //find length of listA and listB
        int lenA=findLength(headA),lenB=findLength(headB);

        //find greater list and move the nodes of greater list by the differnece and then iterate to find 
        boolean greaterA=true;
        if(lenA<lenB){
            greaterA=false;
        }
        if(greaterA){
            int dif=lenA-lenB;
            return firstOverlap(headA,headB,dif);
        }
        else{
            int dif=lenB-lenA;
            return firstOverlap(headB,headA,dif);
        }
    }
}