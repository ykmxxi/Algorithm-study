package 일차원배열;
/*
 백준 2562번. 최대값 찾기
 100 이하 인 9개의 정수를 입력받아 최대값을 출력하고 몇 번째 숫자인지 출력
*/
import java.util.Scanner;

public class no2562 {

    public static int max(int[] arr) {
        int index = 0;
        int tmp = arr[0];

        for (int i = 1; i < 9; i++) {
            if (tmp < arr[i]) {
                tmp = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }

        int result = max(arr);
        System.out.println(arr[result]);
        System.out.println(result + 1);

    }
}
