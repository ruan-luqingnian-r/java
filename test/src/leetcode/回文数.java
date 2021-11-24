package leetcode;

/**
 * @Author: ruan
 * Date: 2021/11/24 23:08
 * @Description: 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 回文数 {
    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        String s = x + "";
        char[] chars = s.toCharArray();
        int index = 0;
        while (index < chars.length){
            if (chars[index] != chars[chars.length - index - 1]){
                return false;
            }
            index++;
        }
        return true;
    }


}
