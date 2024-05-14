import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int index;
    int cost;

    Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class Main {
    static int n;
    static int m;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    static int startIndex;
    static int endIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);

            graph.get(start).add(new Node(end, cost));
        }

        String[] temp = br.readLine().split(" ");

        startIndex = Integer.parseInt(temp[0]);
        endIndex = Integer.parseInt(temp[1]);

        System.out.println(dijkstra(startIndex));
    }

    public static int dijkstra(int startIndex) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] distance = new int[n + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[startIndex] = 0;
        queue.add(new Node(startIndex, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int index = node.index;
            int cost = node.cost;

            if (cost > distance[index]) {
                continue;
            }

            for (Node next : graph.get(index)) {
                if ((cost + next.cost) < distance[next.index]) {
                    distance[next.index] = cost + next.cost;
                    queue.add(new Node(next.index,  distance[next.index]));
                }
            }
        }
        return distance[endIndex];
    }
}
