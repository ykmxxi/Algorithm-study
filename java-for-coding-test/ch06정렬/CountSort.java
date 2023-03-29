package ch06정렬;

import java.util.Arrays;

public class CountSort {

	static int getMax(int[] arr) {
		int max = -1;

		for (int num : arr) {
			max = Math.max(max, num);
		}
		return max;
	}

	static void countSort(int[] arr) {
		int max = getMax(arr);
		int[] cnt = new int[max + 1];

		for (int i = 0; i < arr.length; i++) {
			cnt[arr[i]] += 1;
		}

		System.out.print("정렬 완료: [");
		for (int i = 0; i <= max; i++) {
			for (int j = 0; j < cnt[i]; j++) {
				System.out.print(i + ", ");
			}
		}

		System.out.print("]" + '\n');
	}

	public static void main(String[] args) {
		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 99 + 1);
		}

		System.out.println("처음 상태: " + Arrays.toString(arr));
		countSort(arr);
	}

}
