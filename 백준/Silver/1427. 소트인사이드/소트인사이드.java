import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] numbers = br.readLine().toCharArray();
		ArrayList<Integer> array = new ArrayList<>();

		for (char number : numbers) {
			array.add(Character.getNumericValue(number));
		}

		array.sort(Collections.reverseOrder());

		StringBuilder sb = new StringBuilder();

		for (int a : array) {
			sb.append(a);
		}

		System.out.println(sb);
	}
}