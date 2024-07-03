import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> map = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            map.get(x).add(y);
            map.get(y).add(x);

        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] answers = new int[n + 1];

        queue.add(new int[]{1, 1});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int start = now[0];
            int end = now[1];

            answers[end] = start;

            for (Integer i : map.get(end)) {
                if (!visited[i]) {
                    queue.add(new int[]{end, i});
                    visited[i] = true;
                }
            }

        }

        for (int i = 2; i <= n; i++) {
            System.out.println(answers[i]);
        }

    }
}