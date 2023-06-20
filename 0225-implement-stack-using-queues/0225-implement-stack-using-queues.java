class MyStack {
    public static Queue<Integer> q1;
    public static int ind=0;
    
    public MyStack() {
        q1=new LinkedList<>();
        ind=0;
    }
    
    public void push(int x) {
        q1.add(x);
        for(int i=0;i<ind;i++){
            int top=q1.poll();
            q1.add(top);
        }
        ind++;
        
    }
    
    public int pop() {
        
        ind--;
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        if(q1.size()==0)return true;
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