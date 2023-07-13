class MinStack {
    public static List<Integer> l;
    public static int min; 
    public MinStack() {
        l=new ArrayList<>();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        l.add(val);
    }
    
    public void pop() {
        l.remove(l.size()-1);
    }
    
    public int top() {
        return l.get(l.size()-1);
    }
    
    public int getMin() {
        min=Integer.MAX_VALUE;
        for(int i=0;i<l.size();i++){
            min=Math.min(min,l.get(i));
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */