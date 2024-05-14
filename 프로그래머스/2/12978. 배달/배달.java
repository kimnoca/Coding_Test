import java.util.*;
class Node implements Comparable<Node> {
    int index;
    int cost;
    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
    
}


class Solution {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] distance;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[N + 1];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        for (int i = 0; i < road.length ; i++) {
            graph.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
            graph.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
        }
        
        dijkstra(1);
        for (int i = 0; i <= N; i ++) {
            if (distance[i] <= K) answer ++;
        }
        
        return answer;
    }
    public void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        distance[start] = 0;
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int index = node.index;
            int cost = node.cost;
            
            
            if (cost > distance[index]) {
                continue;
            }
            for (Node next : graph.get(index)) {
                if (next.cost + cost < distance[next.index]) {
                    distance[next.index] = next.cost + cost;
                    queue.add(new Node(next.index, distance[next.index]));
                }
            }
        }
    }
}