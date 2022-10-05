package lv1another;

import java.util.Arrays;

public class Lv1_12910Lambda {

    int[] divisible(int[] array, int divisor) {

        int[] answer = Arrays.stream(array)
                .filter(factor -> factor % divisor == 0)
                .sorted()
                .toArray();

        if (answer.length == 0) {
            answer = new int[] {-1};
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] array1 = {5, 9, 7, 10};
        int[] array2 = {2, 36, 1, 3};
        int[] array3 = {3, 2, 6};

        Lv1_12910Lambda lvv1_12910Lambda = new Lv1_12910Lambda();
        System.out.println(Arrays.toString(lvv1_12910Lambda.divisible(array1, 5)));
        System.out.println(Arrays.toString(lvv1_12910Lambda.divisible(array2, 1)));
        System.out.println(Arrays.toString(lvv1_12910Lambda.divisible(array3, 10)));
    }
}
