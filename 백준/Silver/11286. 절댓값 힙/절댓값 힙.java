import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positiveQueue = new PriorityQueue<>();
        PriorityQueue<Integer> negativeQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                if (positiveQueue.isEmpty() && negativeQueue.isEmpty()) {
                    System.out.println(0);
                } else if (positiveQueue.isEmpty()) {
                    System.out.println(negativeQueue.poll());
                } else if (negativeQueue.isEmpty()) {
                    System.out.println(positiveQueue.poll());
                } else {
                    if (positiveQueue.peek() >= Math.abs(negativeQueue.peek())) {
                        System.out.println(negativeQueue.poll());
                    } else {
                        System.out.println(positiveQueue.poll());
                    }
                }
                continue;
            }

            if (0 > input) {
                negativeQueue.add(input);
            } else {
                positiveQueue.add(input);
            }
        }
    }
}
