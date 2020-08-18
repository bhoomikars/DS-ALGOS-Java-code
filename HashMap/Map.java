import java.util.ArrayList;

public class Map <K, V>{
    ArrayList<MapNode<K, V>> buckets;
    int size;
    int numBuckets;
    public Map(){
        numBuckets = 5;
        buckets = new ArrayList<MapNode<K, V>>();
        for(int i=0;i<numBuckets;i++){
            buckets.add(null);
        }
    }

    private int getBucketIndex(K key){
        int hashCode = key.hashCode();
        return hashCode % numBuckets;
    }

    public int size(){
        return size;
    }

    public V getValue(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }

    public V removeKey(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        if(head.key.equals(key)){
            V value = head.value;
            buckets.set(bucketIndex,head.next);
            size--;
            return value;
        }
        while(head.next != null){
            if(head.next.key.equals(key)){
                V value = head.next.value;
                head.next = head.next.next;
                size--;
                return value;
            }
            head = head.next;
        }
        return null;
    }

    public double loadFactor(){
        return (1.0 * size)/numBuckets;
    }

    private void rehash(){
        System.out.println("Rehashing");
        ArrayList<MapNode<K, V>> temp = buckets;
        buckets = new ArrayList<MapNode<K, V>>();
        for(int i=0;i<2*numBuckets;i++){
            buckets.add(null);
        }
        size = 0;
        numBuckets *= 2;
        for(int i=0;i<temp.size();i++){
            MapNode<K,V> head = temp.get(i);
            while(head!=null){
                K key = head.key;
                V value = head.value;
                insert(key, value);
                head = head.next;
            }
        }
    }

    public void insert(K key, V value){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        while(head!=null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = buckets.get(bucketIndex);
        MapNode<K, V> newElementNode = new MapNode<K, V>(key,value);
        newElementNode.next = head;
        buckets.set(bucketIndex, newElementNode);
        size++;
        double loadFactor = (1.0 * size)/numBuckets;
        if(loadFactor > 0.7)
            rehash();
    }
}
