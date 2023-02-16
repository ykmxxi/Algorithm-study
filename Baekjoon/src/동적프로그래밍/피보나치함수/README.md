# 1003번: 피보나치 함수
- [백준 동적 프로그래밍(Dynamic Programming) 1003번: 피보나치 함수](https://www.acmicpc.net/problem/1003)

## 풀이
- 가짜문제 정의
  - 진짜 문제: fibonacci(n) 을 호출했을 때 0과 1이 출력되는 횟수 -> Dy[n][0] Dy[n][1]
  - 가짜 문제: fibonacci(i) 을 호출했을 때 0과 1이 출력되는 횟수 -> Dy[i][0] Dy[i][1]
- 초기값
  - Dy[0][0] = 1, Dy[0][1] = 0, Dy[1][0] = 0, Dy[1][1] = 1
- 점화식
  - Dy[i][0] = Dy[i - 1][0] + Dy[i - 2][0]
  - Dy[i][1] = Dy[i - 1][1] + Dy[i - 2][1]


## 문제
- N번 째 피보나치 수를 구하는 C++ 함수
```text
int fibonacci(int n) {
    if (n == 0) {
        printf("0");
        return 0;
    } else if (n == 1) {
        printf("1");
        return 1;
    } else {
        return fibonacci(n‐1) + fibonacci(n‐2);
    }
}
```
- fibonacci(3) 을 호출하면 다음과 같은 일이 일어난다.
  - fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.
  - fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.
  - 두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.
  - fibonacci(0)은 0을 출력하고, 0을 리턴한다.
  - fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.
  - 첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
  - fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.
  - 1은 2번 출력, 0은 1번 출력
- fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는 지 구하는 문제

## 입력
- 첫째 줄: 테스트 케이스의 개수 T
- 각 테스트 케이스는 한 줄, N이 주어진다
  - 0 <= N <= 40 정수

## 출력
- 각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력

## 예제
- 입력
```text
3
0
1
3
```
- 출력
```text
1 0
0 1
1 2
```