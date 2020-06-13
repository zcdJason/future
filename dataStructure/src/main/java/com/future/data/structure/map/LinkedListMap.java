package com.future.data.structure.map;


public class LinkedListMap<K, V> implements IMap<K, V>{
    private class Node{
        public K k;
        public V v;
        public Node next;
        public Node(){
            this(null, null, null);
        }
        public Node(K k, V v, Node next){
            this.k = k;
            this.v = v;
            this.next = next;
        }
        public Node(K k , V v){

        }
    }

    Node dummyHead;
    int size;
    public LinkedListMap(){
        this.dummyHead = new Node();
        this.size =0;
    }

    private Node getNode(K k){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.k.equals(k)){
                //找到节点返回
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }


    @Override
    public void add(K k, V v) {
          Node node =   getNode(k);
          if(node == null){
              //没有找到key的节点，那么新增节点，并维护size大小
              dummyHead.next = new Node(k,v, dummyHead.next);
              size ++;
          }else{
              //否则更新v的值
              node.v = v;
          }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public V remove(K k) {
        Node pre = dummyHead;
        //找到删除节点的前节点
        while (pre.next != null)
        {
            if(pre.next.k.equals(k)){
                //找到节点了
                break;
            }
            pre = pre.next;
        }

        //map中有对应的key
        if(pre.next != null){
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.v;
        }
        return null;
    }

    @Override
    public boolean isContainsKey(K k) {
        Node node = getNode(k);
        if(node == null){
            return false;
        }
        return true;
    }

    @Override
    public V get(K k) {
        Node node = getNode(k);
        return  node == null ? null : node.v;
    }

    @Override
    public void set(K k, V newVal) {
        Node node = getNode(k);
        if(node == null){
            throw new IllegalArgumentException("key not exits");
        }
        node.v = newVal;
    }
}
