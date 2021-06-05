package TOP100;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xushu
 * @create 5/28/21 10:41 PM
 * @desc
 */
public class Q146_LRUCache {

    class Node{
        int key;
        int value;
        Node next;
        Node pre;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node();
    private Node tail = new Node();

    private int capacity;

    public Q146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null){
            return -1;
        }

        addNode(node);

        return node.value;
    }



    public void put(int key, int value) {
        Node node = map.get(key);

        if(node != null){
            node.value = value;
            map.put(key, node);
            addNode(node);
            return;
        }

        if(map.size() + 1 > this.capacity){
            Node removeNode = this.tail.pre;
            removeNode(removeNode);
            map.remove(removeNode.key);
        }

        node = new Node(key, value);
        map.put(key, node);
        addBehindHead(node);
    }

    private void addNode(Node node) {
        removeNode(node);
        addBehindHead(node);
    }

    private void addBehindHead(Node node) {
        Node nextHead = this.head.next;
        node.next = nextHead;
        node.pre = this.head;
        nextHead.pre = node;
        this.head.next = node;
    }

    private void removeNode(Node node){
        Node pre = node.pre;
        Node next = node.next;

        pre.next = next;
        next.pre = pre;

        node.next = null;
        node.pre = null;
    }


    public static void main(String[] args) {
        Q146_LRUCache cache = new Q146_LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));;       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));;       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));;       // 返回 -1 (未找到)
        System.out.println(cache.get(3));;       // 返回  3
        System.out.println(cache.get(4));;       // 返回  4
    }

}
