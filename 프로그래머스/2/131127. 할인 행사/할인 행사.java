import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
    
        HashMap<String, Integer> wantMap = new HashMap();
        
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> buyMap = new HashMap();
            for (int k = i; k < i + 10; k++) {
                int count = buyMap.getOrDefault(discount[k], 0) + 1;
                buyMap.put(discount[k], count);
            }
            int buyItemCount = 0;
            
            
            for (String key : wantMap.keySet()) {
                if (wantMap.get(key) == buyMap.getOrDefault(key, 0)) {
                    buyItemCount ++;
                }
            }
            
            if (buyItemCount == want.length) {
                answer ++;
            }
        }
        
        return answer;
    }
}