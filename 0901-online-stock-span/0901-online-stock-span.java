class StockSpanner {
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        // While the stack is not empty and the current price is greater than 
        // or equal to the price at the top of the stack, pop it and add its span.
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        
        // Push the current price and its total accumulated span onto the stack
        stack.push(new int[]{price, span});
        
        return span;
    }
}