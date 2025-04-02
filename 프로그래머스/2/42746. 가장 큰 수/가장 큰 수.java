import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> stringNumbers = new ArrayList<>();
        
        for (int num : numbers) {
            stringNumbers.add(String.valueOf(num));
        }
        
        Collections.sort(stringNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        StringBuilder sb = new StringBuilder();
        
        for (String str : stringNumbers) {
            sb.append(str);
        }
        
        String str = sb.toString();
        
        if (str.charAt(0) == '0') str = "0";
        
        return str;
    }
}