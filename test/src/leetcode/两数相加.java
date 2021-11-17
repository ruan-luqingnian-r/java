package leetcode;

/**
 * @Author: ruan
 * Date: 2021/11/17 13:12
 * @Description: 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 两数相加 {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //创建结果集
        ListNode result = new ListNode();
        //获取首节点
        ListNode resTemp = result;
        //创建进位
        int nextSum = 0;
        //标识位，是否进位
        int flag = 0;
        //遍历链表数据处理
        while (l1 != null && l2 != null){
            int ans = 0;
            //如果不需要进位
            if (flag == 0){
                ans = l1.val + l2.val;
                resTemp.val = ans % 10;
                nextSum = ans / 10;
                flag++;
            }else {
                //如果需要进位
                ans = l1.val + l2.val + nextSum;
                resTemp.next = new ListNode(ans % 10);
                resTemp = resTemp.next;
                nextSum = ans / 10;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null){
            int ans = l1.val + nextSum;
            resTemp.next = new ListNode(ans % 10);
            resTemp = resTemp.next;
            nextSum = ans / 10;
            l1 = l1.next;
        }
        while (l2 != null){
            int ans = l2.val + nextSum;
            resTemp.next = new ListNode(ans % 10);
            resTemp = resTemp.next;
            nextSum = ans / 10;
            l2 = l2.next;
        }
        if (nextSum != 0){
            resTemp.next = new ListNode(nextSum);
        }
        return result;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
