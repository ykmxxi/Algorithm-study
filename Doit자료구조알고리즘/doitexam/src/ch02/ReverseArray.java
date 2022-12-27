package ch02;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = new int[10];

        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(reverse(arr)));
    }

    static int[] reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, arr.length - i - 1);
        }
        return arr;
    }

    static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
