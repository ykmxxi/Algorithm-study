# 11652번: 카드
- [백준 정렬 알고리즘 11652번: 카드](https://www.acmicpc.net/problem/11652)

## 문제
- 숫자 카드 N장
  - 숫자 카드에는 정수가 하나 적혀 있음
  - 적혀있는 수는 -2^62 이상 2^62 이하 (long)
- 가장 많이 가지고 있는 정수를 구하는 프로그램
  - 만약 많이 가지고 있는 정수가 여러개 이면, 작은 것을 출력

## 입력
- 첫째 줄: N (카드 개수)
  - 1 <= N <= 100,000 (int)
- 둘째 줄 ~ N + 1째 줄: 숫자 카드에 적혀있는 정수

## 출력
- 첫째 줄: 가장 많이 가지고 있는 정수

## 예제
- 입력
```text
6
1
2
1
2
1
2
```
- 출력
```text
1
```