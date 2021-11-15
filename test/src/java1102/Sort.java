package java1102;

import java.util.Arrays;

/**
 * @Author: ruan
 * Date: 2021/11/2 13:54
 * @Description:
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
        }
        System.out.println("排序前：" + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    /**
     * 冒泡排序
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
     */
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int minvalue = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minvalue){
                    minIndex = j;
                    minvalue = arr[j];
                }
            }
            if (i != minIndex){
                arr[minIndex] = arr[i];
                arr[i] = minvalue;
            }
        }
    }

    /**
     * 插入排序
     */
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int index = i - 1;
            int value = arr[i];
            while (index >= 0 && arr[index] > value ){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
        }
    }

    public static void shellSort(int[] arr){
        for (int gap = (arr.length / 2); gap > 0; gap /= 2){
            for (int i = gap; i < arr.length; i++) {
                int index = i - gap;
                int value = arr[i];
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

    private static void quick(int[] arr, int left, int right){
        int l = left;
        int r = right;
        int mod = arr[(left + right) / 2];
        while (l < r){
            while (arr[l] < mod){
                l++;
            }
            while (arr[r] > mod){
                r--;
            }
            if (l >= r){
                break;
            }
            arr[l] = arr[l] ^ arr[r];
            arr[r] = arr[r] ^ arr[l];
            arr[l] = arr[l] ^ arr[r];
            if (arr[l] == mod){
                r--;
            }
            if (arr[r] == mod){
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
