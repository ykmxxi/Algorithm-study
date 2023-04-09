package 그리디.잃어버린괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static String input;
	static String[] expressions;

	static void input() throws IOException {
		input = br.readLine();

		// -로 문자열을 쪼개면 expressions[0] - expressions[1] - ... - expressions[마지막]
		// 쪼갠 부분식의 더한 값들을 첫 번째 부분식에서 빼주면 됨
		expressions = input.split("-");
	}

	static void pro() {
		int answer = 0;
		if (!expressions[0].equals("")) {
			String[] subExpression = expressions[0].split("\\+");
			for (String num : subExpression) {
				answer += Integer.parseInt(num);
			}
		}

		for (int i = 1; i < expressions.length; i++) {
			int sum = 0;

			String[] subExpression = expressions[i].split("\\+");
			for (String num : subExpression) {
				sum += Integer.parseInt(num);
			}

			answer -= sum;

		}

		System.out.println(answer);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
