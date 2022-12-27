package ch02;

import java.util.Arrays;

public class CopyArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] copyArr = new int[arr.length];
        int[] reverseCopyArr = new int[arr.length];

        copyArr = copy(copyArr, arr);
        reverseCopyArr = reverseCopy(reverseCopyArr, arr);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(copyArr));
        System.out.println(Arrays.toString(reverseCopyArr));
    }

    static int[] copy(int[] copyArr, int[] original) {
        for (int i = 0; i < original.length; i++) {
            copyArr[i] = original[i];
        }
        return copyArr;
    }

    static int[] reverseCopy(int[] reverseCopyArr, int[] original) {
        for (int i = 0; i < original.length / 2; i++) {
            swap(original, i, original.length - i - 1);
        }
        return copy(reverseCopyArr, original);
    }

    static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
