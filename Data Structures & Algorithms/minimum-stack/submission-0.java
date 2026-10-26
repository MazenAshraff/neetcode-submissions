class MinStack {
    private ArrayDeque<Integer> stack;
    private ArrayDeque<Integer> min;
    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.addFirst(val);
        if(min.isEmpty() || val <= min.peek()) min.addFirst(val);
    }
    
    public void pop() {
        int val = stack.removeFirst();
        if(val == min.peek()) min.removeFirst();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
