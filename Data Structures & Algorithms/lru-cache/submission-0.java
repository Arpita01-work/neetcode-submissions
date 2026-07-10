public class Node{
        int key, val;
        Node prev;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    } 

public class LRUCache {

    private int limit;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.limit = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = tail;
        this.tail.prev = head;
    }

    private void addNode(Node newNode){
        Node prev = this.tail.prev;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = this.tail;
        this.tail.prev = newNode;
    }

    private void deleteNode(Node oldNode){
        Node prev = oldNode.prev;
        Node nxt = oldNode.next;
        prev.next = nxt;
        nxt.prev = prev;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            deleteNode(node);
            addNode(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            deleteNode(cache.get(key));
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        addNode(newNode);

        if(cache.size() > limit){
            Node lru = this.head.next;
            deleteNode(lru);
            cache.remove(lru.key);
        }
    }
}

