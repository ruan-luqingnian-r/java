package leetcode;

import java.util.ArrayList;

/**
 * @Author: ruan
 * Date: 2021/11/22 10:47
 * @Description: 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Z字型变换 {
    public static void main(String[] args) {

    }
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        ArrayList<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < Math.max(s.length(),numRows); i++){
            list.add(new StringBuffer());
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            list.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }
        StringBuffer ret = new StringBuffer();
        for (StringBuffer stringBuffer : list) {
            ret.append(stringBuffer);
        }
        return ret.toString();
    }
}
