import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int s = Integer.parseInt(input[0]);
		int p = Integer.parseInt(input[1]);

		String string = br.readLine();
		int[] check = new int[4];
		int[] answer = new int[4];

		input = br.readLine().split(" ");

		for (int i = 0; i < 4; i++) {
			answer[i] = Integer.parseInt(input[i]);
		}

		for (int i = 0; i < p; i++) {
			if (string.charAt(i) == 'A') {
				check[0]++;
			}
			if (string.charAt(i) == 'C') {
				check[1]++;
			}
			if (string.charAt(i) == 'G') {
				check[2]++;
			}
			if (string.charAt(i) == 'T') {
				check[3]++;
			}
		}
		int count = 0;

		if (check(answer, check)) {
			count ++;
		}

		for (int i = 0; i < s - p; i++) {

			if (string.charAt(i) == 'A') {
				check[0]--;
			}
			if (string.charAt(i) == 'C') {
				check[1]--;
			}
			if (string.charAt(i) == 'G') {
				check[2]--;
			}
			if (string.charAt(i) == 'T') {
				check[3]--;
			}

			int k = i + p;

			if (string.charAt(k) == 'A') {
				check[0]++;
			}
			if (string.charAt(k) == 'C') {
				check[1]++;
			}
			if (string.charAt(k) == 'G') {
				check[2]++;
			}
			if (string.charAt(k) == 'T') {
				check[3]++;
			}

			if (check(answer, check)) {
				count++;
			}
		}

		System.out.println(count);

	}

	static boolean check(int[] answer, int[] check) {
		for (int i = 0; i < 4; i++) {
			if (answer[i] > check[i]) {
				return false;
			}
		}
		return true;
	}
}
