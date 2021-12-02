package leetcode;

/**
 * @Author: ruan
 * Date: 2021/11/29 13:51
 * @Description:
 */
public class 正则表达式匹配 {
    public static void main(String[] args) {

    }
    public boolean isMatch(String s, String p) {
        //首先判断是否存在通配符等问题
        char[] Schars = s.toCharArray();
        char[] Pchars = p.toCharArray();
        if (s.indexOf('*') < 0 || s.indexOf('.') < 0){
            for (int i = 0; i < Pchars.length; i++) {
                if (Pchars[i] != Schars[i]){
                    return false;
                }else {
                    return true;
                }
            }
        }
    }
}
