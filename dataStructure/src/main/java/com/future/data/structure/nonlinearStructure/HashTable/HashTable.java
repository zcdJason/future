package com.future.data.structure.nonlinearStructure.HashTable;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author: Cock a doodle doo
 * 哈希表主要解决两个问题
 * 1-hash函数的设计问题
 * 2-hash冲突的解决（一般的链地址冲突，和参考java8的链表变为红黑树的高级解决方案）
 */
public class HashTable<K, V> {
    TreeMap<K, V>[] hashTable;

    //定义素数容量，这些是通过数学理论研究得出的素数，它表达了一定数据量的情况下取那些素数让hashcode比较平均。
    private final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    //定义上容和下容
    private static final int upperTol = 10;
    private static final int lowerTol = 2;

    //扩容索引
    private static  int capacityIndex = 0;

    private int M;//容量
    private int size;//大小

    public HashTable(int M){
        this.M = M;
        this.size = 0;
        hashTable = new TreeMap[M];
        for(int i = 0 ; i < M; i++){
            hashTable[i] = new TreeMap();
        }
    }

    public int hash(K key){
        return (key.hashCode()& 0X7fffffff % M);
    }

    public HashTable(){
        this(97);
    }

    private int getSize(){
        return  size;
    }
    public void add(K k, V v){
      TreeMap  map =  hashTable[hash(k)];
      if(map.containsKey(k))
          map.put(k, v);
      else{
          map.put(k, v);
          size ++;
          if(size > upperTol * M && capacityIndex + 1 < capacity.length){
              //进行扩容
              capacityIndex ++;
              resize(capacity[capacityIndex]);
          }
      }
    }

    public void resize(int newM){
        TreeMap[] newHashTable = new TreeMap[newM];
        for(int i=0 ; i < newM; i++){
            newHashTable[i] = new TreeMap();
        }
        int oldM = M;
        this.M = newM;
        for(int i= 0; i< oldM; i++){
            TreeMap<K, V>  map = hashTable[i];
            for(K key: map.keySet())
                newHashTable[hash(key)].put(key, map.get(key));
        }
        this.hashTable = newHashTable;
    }

    public V remove(K k){
        V ret = null;
        TreeMap<K, V>  map =  hashTable[hash(k)];
        if(map.containsKey(k)){
            ret = map.remove(k);
            size --;
            if(size < lowerTol * M && capacityIndex -1 >= 0){
                capacityIndex --;
                resize(capacity[capacityIndex]);
            }
        }

        return ret;
    }

    public V get(K k){
        return hashTable[hash(k)].get(k);
    }

    public boolean contains(K k){
        return hashTable[hash(k)].containsKey(k);
    }

}
