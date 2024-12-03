import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Class> queue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			queue.add(new Class(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}

		int currTime = 0;
		int answer = 0;

		while (!queue.isEmpty()) {
			Class time = queue.poll();
			int startTime = time.startTime;
			int endTime = time.endTime;

			if (startTime >= currTime) {
				currTime = endTime;
				answer++;
			}
		}

		System.out.println(answer);
	}
}

class Class implements Comparable<Class> {

	int startTime;
	int endTime;

	Class(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Class o) {

		if (this.endTime == o.endTime) {
			return this.startTime - o.startTime;
		}

		return Integer.compare(this.endTime, o.endTime);
	}

}