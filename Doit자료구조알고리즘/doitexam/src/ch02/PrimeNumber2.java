package ch02;

// 소수를 배열에 저장, n이 소수인지 아닌지 확인할 때 그때까지 저장한 소수로 나누어 확인
public class PrimeNumber2 {
    public static void main(String[] args) {
        int counter = 0;
        int lineFeed = 0;
        int ptr = 0;
        int[] prime = new int[500];

        prime[ptr++] = 2;
        prime[ptr++] = 3;

        for (int n = 5; n <= 1000; n += 2) { // 짝수 중 소수는 존재하지 않음
            boolean flag = false;
            for (int i = 1; prime[i] * prime[i] <= n; i++) { // 소수는 n의 제곱근 이하의 어떤 소수로도 나누어떨어지지 않는다.
                counter += 2;
                if (n % prime[i] == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                prime[ptr++] = n;
                counter++;
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

