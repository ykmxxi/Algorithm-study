# 2529번: 부등호
- [백준 완전 탐색(Brute Force), 구현 2529번: 부등호](https://www.acmicpc.net/problem/2529)

## 풀이
- 순열 이용: k + 1개를 중복없이 순서있게 나열해서 부등식을 만족시키는 수를 찾는다. 그 중 최소값과 최대값
- Main2: 완전 탐색 풀이
- Main: 굳이 완전 탐색? 
  - 9 부터 시작해서 0으로 가는 순서로 for문을 돌려 각 자리수를 채울 때, 처음 부등호를 만족하는 수가 최대값
  - 0 부터 시작해서 9로 가는 순서로 for문을 돌려 각 자리수를 채울 때, 처음 부등호를 만족하는 수가 최소값

## 문제
- 두 종류의 부등호 기호 `<`, `>` 가 k개 나열된 순서열 A가 존재
- 이 부등호 앞뒤에 서로 다른 한 자릿수 숫자를 넣어서 모든 부등호 관계를 만족시키려 한다.
  - ex: `< < < > < < > < >`
  - 0 부터 9까지 정수며 선택된 숫자는 모두 달라야 한다.
  - `"3456128790"` 을 대입하면 `3 < 4 < 5 < 6 > 1 < 2 < 8 > 7 < 9 > 0`
  - 이외에도 만족시키는 숫자가 더 존재할 수 있다.
- 제시된 k개의 부등호 순서를 만족하는 (k + 1) 자리의 정수 중 최대값과 최소값을 찾는 문제
  - 들어갈 숫자는 0 이상 9 이하 정수, 선택된 숫자는 모두 달라야 한다.
  - 즉, k + 1개를 중복없이 순서있게 나열해서 부등식을 만족시키는 수를 찾는다. 그 중 최소값과 최대값을  

## 입력
- 첫째 줄: k
  - 2 <= k <= 9
- 둘째 줄: k 개의 부등호가 공백을 기준으로 나열

## 출력
- 첫째 줄: 부등호 관계를 만족시키는 k + 1 자리 숫자의 최대값
- 둘째 줄: 부등호 관계를 만족시키는 k + 1 자리 숫자의 최소값
  - 단 첫 자리가 0인 경우도 정수에 포함되어야 한다.

## 예제
- 입력
```text
// 예제 1
2
< >

// 예제 2
9
> < < < > > > < <
```
- 출력
```text
// 예제 1
897
021

// 예제 2
9567843012
1023765489
```