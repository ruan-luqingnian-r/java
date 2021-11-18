package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ruan
 * Date: 2021/11/17 21:28
 * @Description:
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int i = lengthOfLongestSubstring2(s);
        System.out.println(i);

    }

    /**
     * 暴力算法
     * 因为只需要判断连续的子字符串有没有重复的元素，很容易想到用Set集合里面的HashSet对象，利用一个index索引来遍历字符串。
     *
     * 如果没有重复元素，将元素加入Set集合中。
     * 如果有重复元素，回退到重复元素较早的那个索引+1处的位置，直至索引到头。
     * 最后比较哪个HashSet对象里面的元素最多即可。
     * 代码如下：
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        Set set = new HashSet();
        //string s的索引
        int index = 0;
        //最长字串数量
        int ans = 0;
        while (index < s.length()){
            while (true){
                if (set.contains(s.charAt(index))){
                    //如果包含重复的字符，index回退到重复元素的后一个位置（不可以用indexOf）
                    index = index - set.size() + 1;
                    break;
                }else {
                    //如果不存在重复的，直接放入
                    set.add(s.charAt(index));
                    index++;
                }
                if (index == s.length()){
                    break;
                }
            }
            if (ans < set.size()){
                ans = set.size();
            }
            //有重复元素重制集合
            set.clear();
        }
        return ans;
    }

    /**
     * 窗口滑动版本
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        //窗口左端点
        int left = 0;
        //窗口右端点
        int right = 0;
        //最大长度
        int maxLength = 0;
        //数据记录
        Set set = new HashSet();

        while (left < s.length() && right < s.length()){
            if (!set.contains(s.charAt(right))){
                //如果集合内无此元素，放入并且右端点前进
                set.add(s.charAt(right++));
                maxLength = Math.max(maxLength,right - left);
            }else {
                //有此元素，左端点前进
                set.remove(s.charAt(left++));
            }
        }
        return maxLength;
    }
}
