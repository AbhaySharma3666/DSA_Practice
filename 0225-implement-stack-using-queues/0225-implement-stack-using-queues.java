class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        int size = q.size();
        for (int i = 1; i <= size - 1; i++) {
            q.add(q.remove());
        }
        return q.remove();
    }
    
    public int top() {
        int size = q.size();
        for (int i = 1; i <= size - 1; i++) {
            q.add(q.remove());
        }
        int val = q.peek();
        q.add(q.remove()); 
        return val;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}