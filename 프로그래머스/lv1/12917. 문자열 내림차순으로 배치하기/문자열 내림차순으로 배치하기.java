import java.util.*;

class Solution {
    public StringBuilder solution(String s) {
        StringBuilder answer = new StringBuilder();
        char alpha[] = new char[s.length()];
        for(int i = 0; i < s.length(); i++) {
            alpha[i] = s.charAt(i);
        }
        Arrays.sort(alpha);
        for(int i = alpha.length-1; i >= 0 ; i--) {
            answer.append(alpha[i]);
        }
        return answer;
    }
}