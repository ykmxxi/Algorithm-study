# 프로그래머스 Level 1: 숫자 문자열과 영단어
- [프로그래머스 Level 1: 숫자 문자열과 영단어(KAKAO)](https://school.programmers.co.kr/learn/courses/30/lessons/81301)

## 풀이
- 방법1: 완전 탐색
- 방법2: 완전 탐색 + String 클래스의 `replaceAll()`메서드
  - 0 부터 9 까지의 숫자를 저장한 문자열 배열을 생성한 후 `replaceAll()`을 이용해 단어를 숫자로 바꿔준다
  - s.replaceAll(strArr[i], Integer.toString(i));

## 문제
- 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네면 프로도는 원래 숫자를 찾는 문제
- 예시
  - `1478` → `one4seveneight`
  - `234567` → `23four5six7`
  - `10203` → `1zerotwozero3`
- 예시처럼 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어짐
- s가 원래 숫자를 return 하도록하는 함수 완성

## 제한사항
- `s`의 길이는 1 이상 50 이하
- `s`가 `zero` or `0` 으로 시작하는 경우는 없음
- 정답이 1 이상 20억 이하의 올바른 정수만 나오도록 주어짐
  - int

## 예제
- 입력
```text
one4seveneight

23four5six7

2three45sixseven

123
```
- 출력
```text
1478

234567

234567

123
```
