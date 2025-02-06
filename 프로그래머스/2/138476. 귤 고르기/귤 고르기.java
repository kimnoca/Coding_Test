import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int t : tangerine) {
            int now = map.getOrDefault(t, 0) + 1;
            map.put(t, now);
        }
        
        List<Integer> values = new ArrayList<>(map.values());
        
        Collections.sort(values, Collections.reverseOrder());
        
        int now = 0;
        
        for (int value : values) {
            now += value;
            
            if (now < k) {
                answer ++;
            }
            
            if (now >= k) {
                answer++;
                break;
            }
        }
        
        return answer;
    }
}