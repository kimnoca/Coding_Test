import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= 9; i++) {
			if (isPrime(i)) {
				dfs(i, 1);
			}
		}

	}

	static void dfs(int number, int size) {
		if (size == n) {
			System.out.println(number);
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (isPrime(number * 10 + i)) {
				dfs(number * 10 + i, size + 1);
			}
		}
	}

	static boolean isPrime(int number) {
		if (number == 1) {
			return false;
		}

		if (number == 2) {
			return true;
		}

		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}