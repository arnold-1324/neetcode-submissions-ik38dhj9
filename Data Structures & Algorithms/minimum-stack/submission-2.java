class MinStack {
     private Deque<Integer> value;
     private Deque<Integer> min;
    public MinStack() {
        value=new ArrayDeque<>();
        min=new ArrayDeque<>();
    }
    
    public void push(int val) {
       value.push(val);
       if(min.isEmpty() || val<=min.peek())
           min.push(val);
    }
    
    public void pop() {
        if(value.isEmpty()) return;
       int x=value.pop();
       if(x==min.peek()) min.pop();
    }
    
    public int top() {
        if(value.isEmpty()) return -1;
        return value.peek();
    }
    
    public int getMin() {
        if(min.isEmpty()) return -1;
        return min.peek();
    }
}
