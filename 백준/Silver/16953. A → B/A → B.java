import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] i = br.readLine().split(" ");

        long a = Long.parseLong(i[0]);
        long b = Long.parseLong(i[1]);

        boolean[] visited = new boolean[Integer.parseInt(String.valueOf(b)) + 1];

        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{a, 1L});

        long answer = -1;

        while (!queue.isEmpty()) {

            long[] now = queue.poll();

            if (now[0] == b) {
                answer = now[1];
                break;
            }

            if ((now[0] * 10 + 1) <= b && !visited[Integer.parseInt(String.valueOf(now[0] * 10 + 1))]) {
                visited[Integer.parseInt(String.valueOf(now[0] * 10 + 1))] = true;
                queue.add(new long[]{now[0] * 10 + 1, now[1] + 1});
            }

            if ((now[0] * 2) <= b && !visited[Integer.parseInt(String.valueOf(now[0] * 2))]) {
                visited[Integer.parseInt(String.valueOf(now[0] * 2))] = true;
                queue.add(new long[]{now[0] * 2, now[1] + 1});
            }

        }
        System.out.println(answer);
    }
}
