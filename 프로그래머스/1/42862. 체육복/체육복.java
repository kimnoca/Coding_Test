import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();
        
        answer = n;
        
        for (int i : lost) {
            lostSet.add(i);
            answer --;
        }
        
        for (int i : reserve) {
            if (!lostSet.contains(i)) {
                 set.add(i);
            } else {
                answer++;
                lostSet.remove(i);
            }
        }
        
        
        Arrays.sort(lost);
        
        for (int i : lostSet) {
            if (set.contains(i)) {
                answer++;
                set.remove(i);
                continue;
            }
            
            if (set.contains(i- 1)) {
                answer ++;
                set.remove(i - 1);
                continue;
            }
            if (set.contains(i + 1)) {
                answer ++;
                set.remove(i + 1);
                continue;
            }
        }
        
        return answer;
    }
}