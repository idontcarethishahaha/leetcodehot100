package problem146_LRU;

import java.util.HashMap;
import java.util.Map;

/**class LRUCache {

 public LRUCache(int capacity) {

 }

 public int get(int key) {

 }

 public void put(int key, int value) {

 }
 }**/
/*
 LRU 缓存机制：
最近最少使用的缓存淘汰策略
get /put 都必须 O (1) 时间
用 哈希表 + 双向链表 组合实现

整体结构：两个核心组件
HashMap：快速查找 key 对应的节点（O (1)）
双向链表：维护使用顺序
头部：最近刚使用
尾部：最久没使用（要被淘汰）
 */



class LRUCache {
    // 双向链表节点,内部类
    class DLinkedNode{
        int key;
        int value;

        DLinkedNode prev;//前驱
        DLinkedNode next;//后继

        DLinkedNode(){}
        DLinkedNode(int k, int v){
            this.key=k;
            this.value=v;
        }
    }

    private Map<Integer,DLinkedNode> cache=new HashMap<>();//哈希表：key->节点
    private int size;//当前缓存大小
    private int capacity;//缓存最大容量
    private DLinkedNode head,tail;//伪头，伪尾（便于操作）

    // 构造方法：初始化
    public LRUCache(int capacity) {
        // 建立一个空的双向链表  head<->tail 便于后续的插入/删除，有伪头&尾，不用判空
        this.size=0;
        this.capacity=capacity;

        head=new DLinkedNode();
        tail=new DLinkedNode();

        head.next=tail;
        tail.prev=head;
    }

    // 核心方法 1
    public int get(int key){
       DLinkedNode node=cache.get(key);//哈希表查key
       if(node==null) return -1;//找不到

       moveToHead(node);// 刚用->移到头部，表示最近使用
        return  node.value;//返回值
    }

    // 核心方法 2
    public void put(int key,int value){
        DLinkedNode node=cache.get(key);

        if(node==null){//1. key不存在
            // 新增节点，加入哈希表
            DLinkedNode newNode=new DLinkedNode(key,value);
            cache.put(key,newNode);
            addToHead(newNode);//加到链表头部
            size++;

            //如果超容量->删除尾部节点(最久未使用)
            if(size>capacity){
                // 删除双向链表的尾部节点
                DLinkedNode tail=removeTail();
                // 删除哈希表中的对应的项
                cache.remove(tail.key);
                size--;
            }
        }else{//2. key已存在
            //更新
            node.value=value;
            moveToHead(node);
        }
    }

    // 4个双向链表的工具方法
    // 1. 把节点加到链表头部
    private void addToHead(DLinkedNode node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }

    // 2.从链表删除该节点
    private void removeNode(DLinkedNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    // 3. 先删，再加到头部
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    // 4. 删除尾部节点（最久未使用）
    private DLinkedNode removeTail(){
        DLinkedNode res=tail.prev;
        removeNode(res);//把尾部节点的前驱删掉
        return res;
        /*
        关于为什么要return res
        因为要拿着这个被删掉的节点，去HashMap里把它也删掉
        看put方法里
          DLinkedNode tail=removeTail();
                cache.remove(tail.key);
         */
    }
}
