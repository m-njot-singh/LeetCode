class MyStack {

    Queue q1;
    Queue q2;
    int size=0;
    public MyStack() {
        q1=new LinkedList<Integer>();
        q2=new LinkedList<Integer>();
    }
     public boolean empty() {
        return (size==0);
    }
  
    public void push(int x) {
        while(!q1.isEmpty()){
           
            q2.add((int) q1.remove());
        }
        q1.add(x);
        size++;
        while(!q2.isEmpty()){
           
            q1.add((int)q2.remove());
        }
    }
    
    public int pop() {
        if(q1.isEmpty()){
            return -1;
        }
        size--;
        return (int)q1.remove();
        
    }
    
    public int top() {
        return (int) q1.peek();
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