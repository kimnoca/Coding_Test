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
    static int v;
    static int e;
    static int start;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        v = Integer.parseInt(temp[0]);
        e = Integer.parseInt(temp[1]);

        start = Integer.parseInt(br.readLine());

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        distance = new int[v + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < e; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            graph.get(u).add(new Node(v, w));
        }

        dijkstra(start);

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                System.out.println(distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }

    public static void dijkstra(int startIndex) {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(startIndex, 0));
        distance[startIndex] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int index = node.index;
            int cost = node.cost;

            if (cost > distance[index]) {
                continue;
            }

            for (Node next : graph.get(index)) {
                if (cost + next.cost < distance[next.index]) {
                    distance[next.index] = cost + next.cost;
                    queue.add(new Node(next.index, distance[next.index]));
                }
            }
        }

    }
}
