package leetcode;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: ruan
 * Date: 2021/11/18 20:48
 * @Description: zzz Longest continous valid substrings
 */
public class Test {
    public static void main(String[] args) {
        //!!!这个是读取的文件位置和文件名
        File file = new File("test/src/leetcode/test.txt");
        ArrayList<String> list = read(file);
        System.out.println("读取的结果为:");
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
            String s1 = find(s);
            System.out.println("有效字串为:" + s1);
            //这是输出的文件位置和文件名
            write(s1 + "\n","test/src/leetcode/test_1.txt");
        }
    }

    public static ArrayList<String> read(File file) {
        ArrayList<String> strings = new ArrayList<>();
        try(FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        ) {
            String str = null;
            while ((str = bufferedReader.readLine()) != null){
                //System.out.println(str);
                strings.add(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public static void write(String s,String path ){
        try(FileOutputStream fileOutputStream = new FileOutputStream(path,true);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)
        ) {
            byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
            bufferedOutputStream.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static String find(String s){
        int left = 0;
        int right = 0;
        int mamLength = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || (c == ' ')){
                right++;
            }else {
                left = i;
                right = i;
            }
            if (mamLength < Math.max(mamLength,right - left)){
                mamLength = Math.max(mamLength,right - left);
                l = left;
                r = right;
            }

        }
        return s.substring(l + 1,r + 1);
    }
}
