package ch04구현.시각;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;

	static boolean check(int hour, int minute, int sec) {
		// hour: 23 13 03
		// minute, sec: 03, 13, 23, 43, 53, 30 ~ 39
		if (hour % 10 == 3 || minute / 10 == 3 || minute % 10 == 3 || sec / 10 == 3 || sec % 10 == 3) {
			return true;
		}
		return false;
	}

	static void pro() {
		int count = 0;
		for (int hour = 0; hour <= N; hour++) {
			for (int minute = 0; minute <= 59; minute++) {
				for (int sec = 0; sec <= 59; sec++) {
					if (check(hour, minute, sec)) {
						count++;
					}
				}
			}
		}

		System.out.println(count);
	}

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		pro();
	}
}
