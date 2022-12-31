package ch02;

// 소수를 배열에 저장, n이 소수인지 아닌지 확인할 때 그때까지 저장한 소수로 나누어 확인
public class PrimeNumber1 {
    public static void main(String[] args) {
        int counter = 0;
        int lineFeed = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;

        for (int n = 3; n <= 1000; n += 2) { // 짝수 중 소수는 존재하지 않음
            int i;
            for (i = 1; i < ptr; i++) {
                counter++;
                if (n % prime[i] == 0) {
                    break;
                }
            }
            if (ptr == i) {
                prime[ptr++] = n;
            }
        }

        for (int i = 0; i < ptr; i++) {
            System.out.print(prime[i] + ", ");
            lineFeed++;
            if (lineFeed % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("나눗셈 수행 횟수: " + counter);
    }
}

