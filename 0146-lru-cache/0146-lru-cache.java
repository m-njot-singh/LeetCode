
class Node{
    Node next;
    Node prev;
    int val;
    int key;
    Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}
class LRUCache {
    public static HashMap<Integer,Node> map;
    public static Node head;
    public static Node tail;
    public static int cap;
    
    
    public LRUCache(int capacity) {
        map=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1); 
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    public static void add(Node temp){
        Node newnode=head.next;
        temp.next=newnode;
        temp.prev=head;
        head.next=temp;
        newnode.prev=temp;
    }
    
    public static void del(Node temp){
        Node nxt=temp.next;
        Node back=temp.prev;
        back.next=nxt;
        nxt.prev=back;
        
    }
    
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node resNode=map.get(key);
            int ans=resNode.val;
            map.remove(key);
            del(resNode);
            add(resNode);
            
            map.put(key,head.next);
            return ans;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr=map.get(key);
            map.remove(key);
            del(curr);
        }
        if(map.size()==cap){
            map.remove(tail.prev.key);
            del(tail.prev);
        }
        
        add(new Node(key,value));
        map.put(key,head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */