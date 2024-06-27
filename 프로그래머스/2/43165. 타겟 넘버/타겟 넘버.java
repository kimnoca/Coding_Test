import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<int []> queue = new LinkedList<>();
        
        queue.add(new int[]{numbers[0], 1});
        queue.add(new int[]{numbers[0] * -1, 1});
        
        int index = 1;
        
        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            
            if (now[1] == numbers.length) {
                break;
            }
            
            queue.add(new int[]{now[0] + numbers[now[1]], now[1] +1});
            queue.add(new int[]{now[0] - numbers[now[1]], now[1] +1});
        }
        for (int[] i: queue) {
            if (i[0] == target) {
                answer ++;
            }
        }
        
        return answer;
    }
}


