import java.util.*;

public class LRUCache{

    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key,int value){
            this.key=key;
            this.value=value;
        }

    }

    private int capacity;
    private int size;
    private Map<Integer,DLinkedNode> cache = new HashMap<>();
    private DLinkedNode head,tail;

    public LRUCache(int capacity){
        this.size=0;
        this.capacity=capacity;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key){
        DLinkedNode node = cache.get(key);
        if (node==null){
            return -1;
        }
        movetohead(node);
        return node.value;
    }

    public void put(int key ,int value){
        DLinkedNode node = cache.get(key);
        if (node==null){
            DLinkedNode newnode = new DLinkedNode(key,value);
            cache.put(key,newnode);
            addtohead(newnode);
            size++;
            if (size>capacity){
                DLinkedNode tail = removetail();
                cache.remove(tail.key);
                size--;
            }
        }else {
            node.value=value;
            movetohead(node);
        }

    }

    private void addtohead(DLinkedNode node){
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;
    }

    private void removenode(DLinkedNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void movetohead(DLinkedNode node){
        removenode(node);
        addtohead(node);
    }

    private DLinkedNode removetail(){
        DLinkedNode res = tail.prev;
        removenode(res);
        return res;
    }
}
