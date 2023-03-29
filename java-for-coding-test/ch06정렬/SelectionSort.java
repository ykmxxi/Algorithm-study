package ch06정렬;

import java.util.Arrays;

public class SelectionSort {

	static void selectionSort(int[] arr) {
		int indexMin, temp;

		for (int i = 0; i < arr.length - 1; i++) { // 위치를 선택, i번째 순회에서는 i번째 자리를 선택
			indexMin = i;

			for (int j = i + 1; j < arr.length; j++) { // i + 1번째 자리부터 순회 시작
				if (arr[j] < arr[indexMin]) { // 현재 선택한 i번째 숫자보다 작은 숫자가 존재하면
					indexMin = j;
				}
			}

			// swap
			temp = arr[indexMin];
			arr[indexMin] = arr[i];
			arr[i] = temp;
		}

		System.out.println("정렬 완료: " + Arrays.toString(arr));

	}

	public static void main(String[] args) {
		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 99 + 1);
		}

		System.out.println("처음 상태: " + Arrays.toString(arr));
		selectionSort(arr);
	}
}


