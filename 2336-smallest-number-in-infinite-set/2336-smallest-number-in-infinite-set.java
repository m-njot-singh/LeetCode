class SmallestInfiniteSet {
    TreeSet<Integer> set;
    int count=1;
    public SmallestInfiniteSet() {
        set=new TreeSet<>();
        for(int i=1;i<1001;i++)set.add(i);
    }
    
    public int popSmallest() {
        if(set.isEmpty()){
         return count++;
        }
        return set.pollFirst();
    }
    
    public void addBack(int num) {
        if(!set.contains(num))set.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */