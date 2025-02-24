import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<String> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			list.add(br.readLine());
		}

		list.sort((o1, o2) -> {
			if (o1.length() == o2.length()) {
				int o1Sum = 0;
				int o2Sum = 0;
				for (int i = 0; i < o1.length(); i++) {
					if (Character.isDigit(o1.charAt(i))) {
						o1Sum += Integer.parseInt(String.valueOf(o1.charAt(i)));
					}
					if (Character.isDigit(o2.charAt(i))) {
						o2Sum += Integer.parseInt(String.valueOf(o2.charAt(i)));
					}
				}
				if (o1Sum != o2Sum) {
					return Integer.compare(o1Sum, o2Sum);
				} else {
					return o1.compareTo(o2);
				}
			} else {
				return Integer.compare(o1.length(), o2.length());
			}
		});

		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s).append("\n");
		}

		System.out.println(sb);
	}
}