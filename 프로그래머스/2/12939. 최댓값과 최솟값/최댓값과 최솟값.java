import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
 	    String[] split = s.split(" ");
        
		Integer[] array = Arrays.stream(split)
            .map(Integer::parseInt)
            .toArray(Integer[]::new);
        
        Arrays.sort(array);
        
        return array[0] + " " + array[array.length-1];
    }
}