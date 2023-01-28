# 1764번: 듣보잡
- [백준 이분 탐색(binary search) 1764번: 듣보잡](https://www.acmicpc.net/problem/1764)

## 복잡도
- 시간 복잡도
  - A 배열 정렬: O(N log N)
  - B 배열에 A 배열의 요소가 존재하는지 탐색 (이분 탐색 이용): O(M * log N)
  - 총 시간 복잡도: O(M log N)

## 문제
- 듣도 못한 사람과 보도 못한 사람의 명단이 주어짐
- 듣도 보도 못한 사람의 명단을 구하는 문제 (두 명단의 교집합)

## 입력
- 첫째 줄: N(듣도 못한 사람의 수) M(보도 못한 사람의 수)
  - 1 <= N, M <= 500,000 자연수
- 둘째 줄 ~: N개의 줄에 걸쳐 듣도 못한 사람의 이름, M개의 줄에 걸쳐 보도 못한 사람의 이름
  - 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어짐
  - 이름의 길이는 20 이하

## 출력
- 첫째 줄: 듣보잡의 수
- 둘째 줄 ~: 듣보잡 명단의 이름을 사전순으로 출력

## 예제
- 입력
```text
3 4
ohhenrie
charlie
baesangwook
obama
baesangwook
ohhenrie
clinton
```
- 출력
```text
2
baesangwook
ohhenrie
```
