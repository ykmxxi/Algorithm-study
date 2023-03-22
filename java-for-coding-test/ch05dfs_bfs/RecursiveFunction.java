package ch05dfs_bfs;

public class RecursiveFunction {

	static void rec_func(int k) {
		if (k == 100) { // 종료조건 명시
			return;
		}

		System.out.println(k + "번째 재귀 함수에서 " + (k + 1) + "번째 재귀함수를 호출");
		rec_func(k + 1);
		System.out.println(k + "번째 재귀 함수를 종료");
	}

	static int factorial(int n) {
		if (n <= 1) { // 종료조건 명시
			return 1;
		}

		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		rec_func(1);
		System.out.println();

		System.out.println(factorial(5));
	}

}
