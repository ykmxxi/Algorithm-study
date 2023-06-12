package 정렬.나이순정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int N;
	static Person[] infos;

	static void input() throws IOException {
		N = Integer.parseInt(br.readLine());

		infos = new Person[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			infos[i] = new Person(st.nextToken(), st.nextToken());
		}
	}

	static void pro() {
		Arrays.sort(infos);

		for (Person person : infos) {
			sb.append(person.age).append(' ').append(person.name).append('\n');
		}

		System.out.print(sb);
	}

	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

	static class Person implements Comparable<Person> {

		String age;
		String name;

		public Person(String age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			return Integer.parseInt(this.age) - Integer.parseInt(o.age);
		}

	}

}
