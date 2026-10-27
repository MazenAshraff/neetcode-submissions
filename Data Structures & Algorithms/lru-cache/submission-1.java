class LRUCache {
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> cache;
    private int size;
    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.after = tail;
        tail.before = head;
        cache = new HashMap<>();
        size = capacity;
    }

    public int get(int key) {
        Node cur = getNode(key);
        if (cur != null)
            return cur.value;
        return -1;
    }

    private Node getNode(int key) {
        if (cache.containsKey(key)) {
            Node cur = cache.get(key);
            cur.before.after = cur.after;
            cur.after.before = cur.before; // adjusting old node connections
            head.after.before = cur;
            cur.after = head.after;
            cur.before = head;
            head.after = cur;
            return cur;
        } else {
            return null;
        }
    }

    public void put(int key, int value) {
        Node cur = getNode(key);
        if (cur != null) {
            cur.value = value;
        } else {
            if (cache.size() == size) {
                Node toRemove = tail.before;
                tail.before.before.after = tail;
                tail.before = tail.before.before;
                cache.remove(toRemove.key);
            }
            Node newNode = new Node(key, value, head, head.after);
            head.after.before = newNode;
            head.after = newNode;
            cache.put(key, newNode);
        }
    }

    static class Node {
        int key;
        int value;
        Node before;
        Node after;
        public Node(int key, int val) {
            value = val;
            this.key = key;
        }
        public Node(int key, int val, Node before, Node after) {
            this.key = key;
            value = val;
            this.before = before;
            this.after = after;
        }
        public String toString() {
            return "<- " + key + ": " + value + " ->";
        }
    }
}
