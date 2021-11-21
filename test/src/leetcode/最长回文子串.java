package leetcode;

/**
 * @Author: ruan
 * Date: 2021/11/20 18:44
 * @Description:
 */
public class 最长回文子串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }


    private static boolean isPalindrome(String s){
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 -i)){
                return false;
            }
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        //遍历字符串，拆出所有子串
        String ans = "";
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i,j);
                //判断是否是回文串
                if (isPalindrome(str) && str.length() > maxLength){
                    ans = str;
                    maxLength = Math.max(maxLength,str.length());
                }
            }
        }
        return ans;
    }
}
