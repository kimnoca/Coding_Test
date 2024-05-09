import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();

            arr = arr.replace("[", "");
            arr = arr.replace("]", "");

            String[] numbers = arr.split(",");

            Deque<Integer> queue = new ArrayDeque<>();

            for (String s : numbers) {
                if (!s.equals("")) {
                    queue.add(Integer.parseInt(s));
                }
            }

            boolean isReversed = false;
            boolean isError = false;
            for (int j = 0; j < cmd.length(); j++) {
                if (cmd.charAt(j) == 'R') {
                    isReversed = !isReversed;
                } else {
                    if (queue.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        queue.pollLast();
                    } else {
                        queue.pollFirst();
                    }
                }
            }
            if (isError) {
                sb.append("error").append("\n");
                continue;
            }

            if (queue.isEmpty()) {
                sb.append("[").append("]").append("\n");
                continue;
            }

            sb.append("[");
            if (isReversed) {
                sb.append(queue.pollLast());
                while (!queue.isEmpty()) {
                    sb.append(",").append(queue.pollLast());
                }
            } else {
                sb.append(queue.pollFirst());
                while (!queue.isEmpty()) {
                    sb.append(",").append(queue.pollFirst());
                }
            }
            sb.append("]").append("\n");
        }
        System.out.println(sb);
    }
}
