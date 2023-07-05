import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp != 0) {
				pq.add(tmp);
			} else if (tmp == 0) {
				if (!pq.isEmpty()) {
					sb.append(pq.poll());
					sb.append("\n");
				} else {
					sb.append("0");
					sb.append("\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

}
