import java.util.*;

class Solution {
    public boolean checkQueue(PriorityQueue<Integer> queue, int K) {
        for (Integer i : queue) {
            if (i < K) return false;
        }
        return true;
    }
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Integer i : scoville) {
            queue.add(i);
        }        
        while (!checkQueue(queue, K)) {
            if (queue.size() == 1) {
                return -1;
            }
            int x = queue.poll();
            int y = queue.poll();
            int temp = x + (y * 2);
            queue.add(temp);
            answer ++;
        }
        
        return answer;
    }
}