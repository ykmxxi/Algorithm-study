# 20291번: 파일 정리
- [백준 정렬 알고리즘 20291번: 파일 정리](https://www.acmicpc.net/problem/20291)

## 문제
- 파일을 확장자 별로 정리해서 몇 개씩 있는지
- 확장자들을 사전 순으로 정렬

## 입력
- 첫째 줄: N(파일의 개수)
  - 1 <= N <= 50,000 (int)
- 둘째 줄 ~ N + 1째 줄: 파일의 이름
  - 파일의 이름은 알파벳 소문자와 점 `.` 으로만 구성
    - example.txt
  - 점은 정확히 한 번만 등장, 점은 파일 이름의 첫 글자 또는 마지막 글자로 오지 않음
  - 각 파일의 이름의 길이: 최소 3, 최대 100

## 출력
- 확장자의 이름과 그 확장자 파일의 개수를 한 줄에 하나씩 출력, 공백으로 구분
  - 확장자가 여러 개 있는 경우 확장자 이름의 사전 순으로 출력

## 예제
- 입력
```text
8
sbrus.txt
spc.spc
acm.icpc
korea.icpc
sample.txt
hello.world
sogang.spc
example.txt
```
- 출력
```text
icpc 2
spc 2
txt 3
world 1
```