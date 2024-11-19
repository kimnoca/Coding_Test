import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String n = br.readLine();
		String input = br.readLine();

		char[] array = input.toCharArray();

		int sum = 0;

		for (char c : array) {
			sum += Integer.parseInt(String.valueOf(c));
		}

		System.out.println(sum);
	}
}