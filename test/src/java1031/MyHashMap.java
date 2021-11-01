package java1031;

/**
 * @Author: ruan
 * Date: 2021/11/1 20:59
 * @Description:
 */
public class MyHashMap<K, V> {
    /**
     * 用于存放节点
     */
    private Node<K, V>[] table;

    /**
     * 节点数量
     */
    private int size;

    /**
     * 添加数据
     * @param key
     * @param value
     */
    public void put(K key, V value){
        if (table == null || table.length == 0){
            table = new Node[16];
        }
        //组装节点
        Node<K, V> newNode = new Node(key,value,null,null);
        //计算hash值
        int index = hash(key);
        //判断该哈希槽位情况
        if (table[index] == null){
            //无数据，直接插入
            table[index] = newNode;
        }else {
            //有数据，遍历链表找到链表结尾
            Node<K, V> temp = table[index];
            while (temp.next != null){

                if (temp.key.equals(key)){
                    //有重复值，直接替换
                    temp.value = value;
                }
                temp = temp.next;
            }
            //此时，找到链表尾部
        }

    }


    private int hash(K key){
        return key == null ? 0 : key.hashCode() & (table.length - 1);
    }

    private final class Node<K, V>{
        private K key;
        private V value;
        private Node<K, V> next;
        private Node<K, V> pre;

        public Node(K key, V value, Node next, Node pre) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
    }
}

