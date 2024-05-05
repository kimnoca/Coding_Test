import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }
        int answer = 0;

        while (!queue.isEmpty()) {
            if (queue.size() < 2) {
                break;
            }
            int x = queue.poll();
            int y = queue.poll();
            answer += (x + y);
            queue.add(x + y);
        }
        
        System.out.println(answer);
    }
}
