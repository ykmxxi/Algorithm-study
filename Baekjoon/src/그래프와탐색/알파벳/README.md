# 1987번: 알파벳
- [백준 그래프 탐색 알고리즘 1987번: 알파벳](https://www.acmicpc.net/problem/1987)

## 문제
- 세로 R칸 (행), 가로 C칸(열) 표 모양의 보드 (격자형 배열)
- 보드의 각 칸에는 대문자 알파벳이 하나씩 적혀 있고, 좌측 상단 (1, 1)에 말이 놓여 있다.
- 상하좌우 인접한 네 칸 중 하나로 이동 가능
  - 새로 이동한 칸에 적혀있는 알파벳은 지금까지 지나온 모든 칸에 적혀 있는 알파벳과는 달라야 한다.
- 좌측 상단 시작, 말이 최대 몇 칸 지날 수 있는지를 구하는 문제 (상단의 칸도 포함)
  - 시작 값: 1

## 입력
- 첫째 줄: R C
  - 1 <= R, C <= 20
- 둘째 줄 부터 R개의 줄에 걸쳐 C개의 문자 알파벳들이 빈칸 없이 주어진다

## 출력
- 말이 지날 수 있는 최대의 칸 수

## 예제
- 입력
```text
5 5
IEFCJ
FHFKC
FFALF
HFGCF
HMCHH
```
- 출력
```text
10
```