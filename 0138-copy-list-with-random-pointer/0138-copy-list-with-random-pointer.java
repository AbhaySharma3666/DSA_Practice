/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    // Step 1: Create deep copy without random pointers
    public Node deepCopy(Node head1) {
        Node temp1 = head1;
        Node dummy = new Node(-1);
        Node temp2 = dummy;

        while (temp1 != null) {
            temp2.next = new Node(temp1.val);
            temp2 = temp2.next;
            temp1 = temp1.next;
        }
        return dummy.next;
    }

    // Step 2: Merge both lists alternatively
    public void merge(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            Node next1 = temp1.next;
            Node next2 = temp2.next;

            temp1.next = temp2;
            temp2.next = next1;

            temp1 = next1;
            temp2 = next2;
        }
    }

    // Step 3: Connect random pointers
    public void randomConnections(Node head1) {
        Node temp = head1;

        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
    }

    // Step 4: Separate original and copied lists
    public Node split(Node head1) {
        Node dummy = new Node(-1);
        Node copyTail = dummy;

        Node temp = head1;

        while (temp != null) {
            Node copy = temp.next;
            Node nextOriginal = copy.next;

            copyTail.next = copy;
            copyTail = copy;

            temp.next = nextOriginal;

            temp = nextOriginal;
        }
        return dummy.next;
    }

    public Node copyRandomList(Node head1) {

        if (head1 == null)
            return null;

        // Step 1
        Node head2 = deepCopy(head1);
        
        // Step 2
        merge(head1, head2);

        // Step 3
        randomConnections(head1);

        // Step 4
        return split(head1);
    }
}