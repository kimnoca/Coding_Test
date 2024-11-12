class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        
        for (int i = 1; i <= sum; i ++) {
            if (sum % i == 0) {
                int temp = sum / i; 
                if ((temp * 2 + i * 2 ) -4 == brown) {
                    answer[1] = i;
                    answer[0] = temp;
                    break;
                }
            }
        }
        return answer;
    }
}