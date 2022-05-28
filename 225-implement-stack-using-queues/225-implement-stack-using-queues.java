class MyStack {

    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        // push into q1
        q1.add(x);
        
        // empty q2 and push all elements from q2 to q1
        while(!q2.isEmpty()) {
            q1.add(q2.poll())   ;
        }        
        // empty q1, push all elements from q1 to q2
        while(!q1.isEmpty()) {
            q2.add(q1.poll());
        }
    }
    
    public int pop() {
        return q2.poll();
    }
    
    public int top() {
        return q2.peek();
    }
    
    public boolean empty() {
        if(q1.isEmpty() && q2.isEmpty()) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */