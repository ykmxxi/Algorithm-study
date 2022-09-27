package ch01;

// p.19 연습문제 1
public class Practice1 {

    static int max4(int a, int b, int c, int d) {
        int max = a;

        if (max < b)
            max = b;
        if (max < c)
            max = c;
        if (max < d)
            max = d;

        return max;
    }

    static int min3(int a, int b, int c) {
        int min = a;

        if (min > b)
            min = b;
        if (min > c)
            min = c;

        return min;
    }

    static int min4(int a, int b, int c, int d) {
        int min4 = a;

        if (min4 > b)
            min4 = b;
        if (min4 > c)
            min4 = c;
        if (min4 > d)
            min4 = d;

        return min4;
    }

    public static void main(String[] args) {

        System.out.println(max4(133, 331, 531, 29));
        System.out.println(min3(29, 18, 301));
        System.out.println(min4(19, 293, 291, 38));
    }

}
