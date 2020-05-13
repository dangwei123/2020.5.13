蓄水池算法
public class GetKRands {
    Random random=new Random();
    public int[] getKRands(int n,int k){
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=i+1;
        }
        for(int i=k+1;i<=n;i++){
            if(random.nextInt(i)<k){
                res[random.nextInt(k)]=i;
            }
        }
        return res;
    }
}

设计一个含有setAll()方法的哈希
public class MyHashMap<K,V> {
    private static class Node<V>{
        V val;
        long time;
        public Node(V val,long time){
            this.val=val;
            this.time=time;
        }
    }
    private Map<K,Node<V>> map;
    private long time;
    private Node<V> setAll;
    public MyHashMap(){
        this.map=new HashMap<>();
        this.time=0;
        this.setAll=new Node<V>(null,-1);
    }

    public boolean contains(K key){
        return map.containsKey(key);
    }

    public void put(K key,V value){
        map.put(key,new Node<V>(value,time++));
    }

    public void setAll(V val){
        this.setAll=new Node<V>(val,time++);
    }

    public V get(K key){
        if(map.containsKey(key)){
            if(map.get(key).time>setAll.time){
                return map.get(key).val;
            }
            return setAll.val;
        }
        return null;
    }
}


左部分最大值跟右部分最大值差的最大绝对值
public class MaxABS {
    public int maxABS(int[] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        return max-Math.min(arr[0],arr[arr.length-1]);
    }
}

LRU
public class LRUCache {
    private static class Node{
        int key;
        int val;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    Map<Integer,Node> map=new HashMap<>();
    LinkedList<Node> list=new LinkedList<>();
    int capacity;
    int size;
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        list.remove(node);
        list.addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            list.remove(node);
            list.addFirst(node);
            node.val=value;
        }else{
            if(size==capacity){
                Node delete=list.removeLast();
                map.remove(delete.key);
                size--;
            }
            Node node=new Node(key,value);
            map.put(key,node);
            list.addFirst(node);
            size++;
        }
    }
}


public class RandomPoll {
    Map<Integer,Integer> keyMap=new HashMap<>();
    Map<Integer,Integer> indexMap=new HashMap<>();
    private int size;
    public RandomPoll(){

    }
    public void insert(int key){
        if(!keyMap.containsKey(key)){
            keyMap.put(key,size);
            indexMap.put(size++,key);
        }
    }

    public void delete(int key){
        if(keyMap.containsKey(key)){
            int index=keyMap.get(key);
            keyMap.remove(key);
            indexMap.remove(index);
            int update=indexMap.get(size-1);
            keyMap.put(update,index);
            indexMap.put(index,update);
        }
    }

    public int getRandom(){
        int num=(int)(Math.random()*size);
        return indexMap.get(num);
    }
}


调整[0,x)区间上数出现的概率
public class RandXPowK {
    public double randX(int k){
        double res=-1;
        for(int i=0;i<k;i++){
            res=Math.max(res,random());
        }
        return res;
    }
    private double random(){
        return Math.random();
    }
}
