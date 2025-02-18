import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);

		String[] numbersInput = br.readLine().split(" ");

		boolean[] set = new boolean[1002];

		if (!numbersInput[0].equals("")) {
			for (String num : numbersInput) {
				set[Integer.parseInt(num)] = true;
			}
		}

		int answer = 1000 * 1000 * 1000;

		for (int i = 1; i <= 1001; i++) {
			if (set[i]) {
				continue;
			}
			for (int j = 1; j <= 1001; j++) {
				if (set[j]) {
					continue;
				}
				for (int k = 1; k <= 1001; k++) {
					if (set[k]) {
						continue;
					}
					int abs = Math.abs(n - (i * j * k));
					answer = Math.min(answer, abs);
				}
			}
		}

		System.out.println(answer);
	}
}
