package ch01;

public class Practice8 {

    static int sumof(int a, int b) {
        int sum = 0;

        if (a >= b) {
            for(int i = b; i <= a; i++) {
                sum += i;
            }
        } else {
            for (int i = a; i <= b; i++) {
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumof(3, 5));
        System.out.println(sumof(6, 4));
    }
}
