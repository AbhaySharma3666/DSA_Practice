public class Node {
    int val;
    Node next;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node next) { this.val = val; this.next = next; }
 }
class MyLinkedList {
    int size=0;
    Node head;
    public MyLinkedList() {
        size=0;
        head = new Node(0);
    }
    
    public int get(int index) {
        if(index < 0 || index >= size ) return -1;
        Node curr = head;
        for(int i = 0 ; i < index+1 ; i++) curr = curr.next;
        return curr.val;
    }
    
    public void addAtHead(int val) { addAtIndex(0,val); }
    
    public void addAtTail(int val) { addAtIndex(size,val); }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 ) index = 0;
        
        size++;

        // Find prev node to be added
        Node prev = head;
        for( int i = 0 ; i < index ; i++) prev = prev.next;

        Node toAdd = new Node(val);

        toAdd.next = prev.next;
        prev.next = toAdd;

    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        
        size--;

        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */