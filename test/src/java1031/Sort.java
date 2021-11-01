package java1031;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/10/31 20:59
 * @Description: 排序算法
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 100 + 1);
        }
        System.out.println("排序前：" + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 冒泡
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j + 1] ^ arr[j];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            //保存最小值和下标
            int minIndex = i;
            int minValue = arr[i];
            //遍历数组找到真的最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (minValue > arr[j]){
                    minIndex = j;
                    minValue = arr[j];
                }
            }
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = minValue;
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //保存数据和下标
            //待插入数据
            int value = arr[i];
            //下标
            int index = i - 1;
            //遍历链表找到待插入位置
            while (index >= 0 && arr[index] > value){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
        }
    }

    public static void hellSort(int[] arr){
        for (int gap = (arr.length / 2); gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++) {
                int value = arr[i];
                int index = i - gap ;
                while (index >= 0 && arr[index] > value){
                    arr[index + gap] = arr[index];
                    index = index - gap;
                }
                arr[index + gap] = value;
            }
        }
    }
    public static void quickSort(int[] arr){
        quick(arr,0, arr.length - 1);
    }

    private static void quick(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int median = arr[(left + right) / 2];
        while (l < r){
            while (arr[l] < median){
                l++;
            }
            while (arr[r] > median){
                r--;
            }
            if (l >= r){
                break;
            }
            arr[l] = arr[l] ^ arr[r];
            arr[r] = arr[r] ^ arr[l];
            arr[l] = arr[l] ^ arr[r];
            if (arr[l] == median){
                r--;
            }
            if (arr[r] == median){
                l++;
            }
        }
        if (l == r){
            l++;
            r--;
        }
        if (l < right){
            quick(arr, l, right);
        }
        if (left < r){
            quick(arr, left, r);
        }
    }
}
