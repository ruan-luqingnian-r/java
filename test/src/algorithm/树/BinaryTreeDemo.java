package algorithm.树;

/**
 * @Author: ruan
 * Date: 2021/11/21 14:55
 * @Description: 二叉树
 */
public class BinaryTreeDemo {
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
