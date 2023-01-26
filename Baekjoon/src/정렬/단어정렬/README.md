# 1181번: 단어 정렬
- [백준 정렬 알고리즘 1181번: 단어 정렬](https://www.acmicpc.net/problem/1181)

## 문제
- 알파벳 소문자로 이루어진 N개의 단어를 정렬하는 문제
- 정렬 조건
  1. 길이가 짧은 것 부터
  2. 길이가 같으면 사전 순으로

## 입력
- 첫째 줄: N(단어의 개수)
  - 1 <= N <= 20,000
- 둘째 줄 ~ N+1째 줄: 알파벳 소문자로 이루어진 단어
  - 한 줄에 한개의 단어{
  - 문자열의 길이는 50이하

## 출력
- 정렬 조건에 따라 단어들을 출력
  - 같은 단어가 여러 번 입력된 경우 한 번씩만 출력(중복 허용X)

## 예제
- 입력
```text
13
but
i
wont
hesitate
no
more
no
more
it
cannot
wait
im
yours
```
- 출력
```text
i
im
it
no
but
more
wait
wont
yours
cannot
hesitate
```
