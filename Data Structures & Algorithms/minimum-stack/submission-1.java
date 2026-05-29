class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(!stack.isEmpty() && stack.pop() <= minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        return 0;
    }
    
    public int getMin() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return 0;
    }
}
