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
            temp.next = newNode;
            newNode.pre = temp;
        }
        size++;
    }

    /**
     * 根据节点删除数据
     * @param key
     * @return
     */
    public V remove(K key){
        //获取该节点
        Node<K, V> node = getNodeFromKey(key);
        if (node == null){
            return null;
        }
        //判断该节点状态
        if (node.next == null && node.pre == null){
            //上下都为空，只有该节点一个，置空节点
            table[hash(key)] = null;
        }else if (node.next == null){
            //节点下一个为空，说明是最后一个节点
            node.pre.next = null;
        }else if (node.pre == null){
            //节点上一个为空，说明第一个节点
            node.next.pre = null;
            table[hash(key)] = node.next;
        }else {
            //中间节点
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.value;
    }

    /**
     * 修改
     * @param key
     * @param value
     * @return
     */
    public V set(K key, V value){
        Node<K, V> node = getNodeFromKey(key);
        if (node == null){
            return null;
        }
        V v = node.value;
        node.value = value;
        return v;
    }

    public V get(K key){
        Node<K, V> node = getNodeFromKey(key);
        if (node == null){
            return null;
        }
        return node.value;
    }


    /**
     * 根据key获取节点
     * @param key
     * @return
     */
    private Node<K, V> getNodeFromKey(K key){
        //获取hash值
        int index = hash(key);
        Node<K, V> node = table[index];
        if (node == null){
            return null;
        }else {
            Node<K, V> temp = node;
            while (node.next != null){
                if (node.key.equals(key)){
                    return node;
                }
                node = node.next;
            }
        }
        return null;

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

