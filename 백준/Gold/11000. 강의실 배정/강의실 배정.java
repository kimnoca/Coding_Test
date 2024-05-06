import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> startQueue = new PriorityQueue<>();
        PriorityQueue<Integer> endQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] split = input.split(" ");

            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);

            startQueue.add(start);
            endQueue.add(end);
        }

        int answer = 1;
        int start = startQueue.poll();
        int end = endQueue.poll();

        while (!startQueue.isEmpty()) {

            start = startQueue.poll();

            if (start < end) {
                answer++;
            } else {
                end = endQueue.poll();
            }
        }

        System.out.println(answer);


    }
}
