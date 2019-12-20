package cn.wqd.cache;


import java.util.*;



/**
 * Created by dell on 2019/12/20.
 */
public class MyHashMap<K,V> {

    transient Node<K,V>[] table;

    static final int TREEIFY_THRESHOLD = 8;

    public void putTest(int hash,K key,V value,boolean onlyIfAbsent ,boolean evict){
        Node<K,V> [] tab; int n;//临时数组，长度
        Node<K,V> p;int i;//临时节点，可能的下标

        //初始化
        if((tab =table)==null || (n=table.length)==0){
            n = (tab = resize()).length;
        }
        //没有产生碰撞，则直接新建一个挂在到i位置（注意，这里不是靠是否有对应值做判断条件，而是依靠是否产生碰撞）
        if((p = tab[i = (n-1) & hash]) ==null){

        }else {//产生了碰撞，解决碰撞
            Node<K,V> e; K k;
            if(p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k)))){
                e = p;
            } else if(p instanceof Object){//是树节点
                //放到树里
            }else {
                //遍历，判断是修改还是新增
                for (int binCount =0 ; ; ++binCount){
                    //新增
                    if((e=p.next) ==null){
                        p.next = newNode(hash,key,value,null);
                        if(binCount>= TREEIFY_THRESHOLD - 1){
                            //构建数
                        }
                    }
                    //修改
                    if(p.hash == hash &&
                            ((k = p.key) == key || (key != null && key.equals(k)))){
                        p = e;
                    }
                }
            }
        }


    }
    Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
        return new Node<>(hash, key, value, next);
    }
    //扩容
    final Node<K,V>[] resize() {return null;
    }
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }




}
