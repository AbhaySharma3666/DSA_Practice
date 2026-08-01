/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null) return head;
        Node curr = head;
        while(curr!=null){
            if (curr.child == null) curr = curr.next;
            else{
                Node fwd = curr.next;
                Node cld = flatten(curr.child);
                curr.child = null;
                curr.next = cld;
                cld.prev = curr;
                Node temp = cld;
                while ( temp.next!= null ) temp = temp.next;
                temp.next = fwd;
                if(fwd!=null) fwd.prev = temp;
            }
        }
        return head;
    }
}