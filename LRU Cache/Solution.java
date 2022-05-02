/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 * */

class LRUCache {

    private Map<Integer, DLinkedList> ref = new HashMap<>();
    private int capacity;
    private DLinkedList head;
    private DLinkedList tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedList();
        tail = new DLinkedList();
        head.next = tail;
        tail.prev = head;

    }

    private void add(DLinkedList node){
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void remove(DLinkedList node){
        DLinkedList prev = node.prev;
        DLinkedList next = node.next;

        prev.next = next;
        next.prev = prev;

    }


    public int get(int key) {
        DLinkedList node = ref.get(key);
        if(node!= null){
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLinkedList node = ref.get(key);
        if(node == null){
            node = new DLinkedList(value, key);
            ref.put(key, node);
            add(node);
            if(ref.size()> capacity){
                ref.remove(tail.prev.key);
                remove(tail.prev);

            }
        }else{
            node.val = value;
            remove(node);
            add(node);
        }
    }
}

class DLinkedList {
    DLinkedList next;
    DLinkedList prev;
    int key;
    int val;

    public DLinkedList (){

    }
    public DLinkedList (int val , int key){
        this.val = val;
        this.key =key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */