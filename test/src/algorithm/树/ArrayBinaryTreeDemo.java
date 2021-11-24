package algorithm.树;

/**
 * @Author: ruan
 * Date: 2021/11/24 22:11
 * @Description: 顺序存储二叉树
 */
public class ArrayBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder();
        System.out.println("==");
        arrayBinaryTree.postOrder();
    }
}
class ArrayBinaryTree{
    //存取节点的数组
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }


    public void postOrder(){
        this.postOrder(0);
    }

    /**
     * 顺序存储二叉树(前序)
     */
    public void preOrder(int index){
        //数组为空或者arr.length = 0;
        if (arr == null || arr.length == 0){
            System.out.println("数组为空");
        }
        //输出当前元素
        System.out.println(arr[index]);
        //想左递归遍历
        if ((index * 2 + 1) < arr.length){
            preOrder(2 * index + 1);
        }
        if ((index * 2 + 2) < arr.length){
            preOrder(2 * index + 2);
        }
    }

    /**
     * 后续
     * @param index
     */
    public void postOrder(int index){
        //数组为空或者arr.length = 0;
        if (arr == null || arr.length == 0){
            System.out.println("数组为空");
        }
        //先输出左节点值
        if ((index * 2 + 1) < arr.length){
            postOrder(index * 2 + 1);
        }
        //在输出右结点
        if ((index * 2 + 2) < arr.length){
            postOrder(index * 2 + 2);
        }
        //输出当前元素
        System.out.println(arr[index]);
    }
}

