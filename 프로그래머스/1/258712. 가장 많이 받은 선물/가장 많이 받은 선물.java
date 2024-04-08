import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, Integer> score = new HashMap<>();
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
        
     
        for (String friend : friends) {
            score.put(friend, 0);
        }
                    
        for (String friend : friends) {
            map.put(friend, new HashMap<>());
        }
        
        for (String gift : gifts) {
            String[] tmp = gift.split(" ");
            String from  = tmp[0];
            String to = tmp[1];
            
            HashMap<String, Integer> tempMap = map.get(from);
            
            int count = tempMap.getOrDefault(to, 0);
            tempMap.put(to, ++count);
            
            map.put(from, tempMap);           
            
        }
                
        for(String gift : gifts) {
            String[] tmp = gift.split(" ");
            String from  = tmp[0];
            String to = tmp[1];
            int fromScore = score.get(from);
            int toScore = score.get(to);
            score.put(from, ++fromScore);
            score.put(to, --toScore);
        }
        
        HashMap<String, Integer> result = new HashMap<>();
        
        for (String s : friends) {
            result.put(s, 0);
        }
        
        for (String from : friends) {
            for (String to : friends) {
                if (!from.equals(to)) {
                    int fromScore = map.get(from).getOrDefault(to, 0);
                    int toScore = map.get(to).getOrDefault(from, 0);
                    
                    if(fromScore > toScore) {
                        result.put(from, result.get(from) + 1);
                    } else if (fromScore == toScore && score.get(from) > score.get(to)) {
                        result.put(from, result.get(from) + 1);
                    }
                }
            }
        }

        return Collections.max(result.values());
    }
}