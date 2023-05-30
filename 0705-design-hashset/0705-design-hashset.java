class MyHashSet {
    List<Integer> l;
    int index=0;
    public MyHashSet() {
        l=new ArrayList<>();
    }
    
    public void add(int key) {
        if(contains(key)==false){
            l.add(key);
        }
    }
    
    public void remove(int key) {
        
        if(contains(key)==true){
             l.remove(index);
        }
    }
    
    public boolean contains(int key) {
        for(int i=0;i<l.size();i++){
            if(l.get(i)==key){
                index=i;
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */