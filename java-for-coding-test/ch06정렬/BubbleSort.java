package ch06정렬;

import java.util.Arrays;

public class BubbleSort {

	static void bubbleSort(int[] arr) {
		int temp = 0;

		for (int i = 0; i < arr.length; i++) { // 제외될 원소의 갯수, i번째 순회가 끝나면 i + 1번째 순회때 i개가 제외

			for (int j = 1; j < arr.length - i; j++) { // j는 현재 원소를 가리키고, j - 1은 이전 원소

				if (arr[j - 1] > arr[j]) { // 현재 원소와 이전 원소를 비교, 만약 이전 원소가 더 크면 교환
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}

		}
		System.out.println("정렬 완료: " + Arrays.toString(arr));
	}

	public static void main(String[] args) {
		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 99 + 1);
		}

		System.out.println("처음 상태: " + Arrays.toString(arr));
		bubbleSort(arr);
	}

}
