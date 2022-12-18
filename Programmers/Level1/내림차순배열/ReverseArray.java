package lv1self.내림차순배열;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12932
    * 자연수 뒤집어 배열로 만들기
    자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴
    ex) n = 12345, return [5, 4, 3, 2, 1]
        - n은 10,000,000,000이하인 자연수

 */

public class ReverseArray {

    int[] solutuion(long n) {
        String len = "" + n;
        int[] answer = new int[len.length()];

        int index = 0;
        while (n != 0) {
            answer[index] = (int) (n % 10);
            n /= 10;
            index++;
        }
        return answer;
    }


    public static void main(String[] args) {
        int n = 12345;
        int arr[];
        ReverseArray reverseArray = new ReverseArray();
        arr = reverseArray.solutuion(n);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }
}
