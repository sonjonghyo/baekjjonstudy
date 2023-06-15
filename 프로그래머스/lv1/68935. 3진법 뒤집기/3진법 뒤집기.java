import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
         StringBuilder sb = new StringBuilder();
        while(n != 0) {
            sb.append((n%3));
            n /= 3;
        }
        String three = sb.reverse().toString();
        for(int i = 0; i < three.length(); i++) {
        	answer += Math.pow(3, i) * (three.charAt(i) - '0');
        }
        return answer;
    }
}