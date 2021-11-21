package algorithm.树;

/**
 * @Author: ruan
 * Date: 2021/11/21 14:55
 * @Description: 二叉树
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建节点
        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        //先手动创建二叉树，后期递归创建二叉树
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(node1);
        System.out.println("==前序==");
        binaryTree.preOrder();
        System.out.println("==中序==");
        binaryTree.modOrder();
        System.out.println("==后续==");
        binaryTree.postOrder();


    }
}

/**
 * 创建节点
 */
class HeroNode{
    /**
     * 序号
     */
     private int no;
    /**
     * 姓名
     */
    private String name;
    /**
     * 左子节点
     */
    private HeroNode left;
    /**
     * 右子节点
     */
    private HeroNode right;
    /**
     * 构造方法
     */
    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
    /**
     * 前序遍历
     * 父，左，右
     */
    public void preOrder(){
        System.out.println(this);
        //递归想左子树前序遍历
        if (this.left != null){
            this.left.preOrder();
        }
        //递归向又子树前序遍历
        if (this.right != null){
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     * 左，父，右
     */
    public void midOrder(){
        //向左子树中序遍历
        if (this.left != null){
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null){
            this.right.midOrder();
        }
    }
    /**
     * 后续遍历
     */
    public void postOrder(){
        //向左子节点递归
        if (this.left != null){
            this.left.postOrder();
        }
        if (this.right != null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
}

/**
 * 创建二叉树
 */
class BinaryTree{
    /**
     * 根节点
     */
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }
    /**
     * 前序遍历
     */
    public void preOrder(){
        if (this.root != null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
    /**
     * 中序遍历
     */
    public void modOrder(){
        if (this.root != null){
            this.root.midOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
    /**
     * 后序遍历
     */
    public void postOrder(){
        if (this.root != null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
}
