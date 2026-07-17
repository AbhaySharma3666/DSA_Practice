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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        ListNode A = headA;
        while(A != null){
            countA++;
            A = A.next;
        }
        int countB = 0;
        ListNode B = headB;
        while(B != null){
            countB++;
            B = B.next;
        }

        A = headA;
        B = headB;
        if(countA>countB){
            for(int i=0 ; i<countA-countB;i++) {
                A = A.next;
            }
        } else {
            for(int i=0 ; i<countB-countA;i++) {
                B = B.next;
            }
        }
        
        while(A!=B){
            A = A.next;
            B = B.next;
        }
        return A;
    }
}