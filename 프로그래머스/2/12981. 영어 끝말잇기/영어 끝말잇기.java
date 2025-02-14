import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[] count = new int[n];
        
        HashSet<String> answerSet = new HashSet<>();
        
        count[0] ++;
        answerSet.add(words[0]);
        String last = words[0];
        
        for(int i = 1; i < words.length; i++) {
            count[i % n] ++;

            if(answerSet.contains(words[i]) || 
               words[i].charAt(0) != last.charAt(last.length() - 1)) {
                answer[0] = (i % n) + 1;
                answer[1] = count[i % n];
                break;
            }
           
            else {
                answerSet.add(words[i]);
            }
            
            last = words[i];
        }
        


        return answer;
    }
}