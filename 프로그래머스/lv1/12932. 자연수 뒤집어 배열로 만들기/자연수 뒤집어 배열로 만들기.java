import java.util.*;

class Solution {
    public List solution(long n) {
        List<Long> answer = new ArrayList<>();
        long tmp = 0;
        while(n != 0) {
            tmp = n%10;
            answer.add(tmp);
            n /= 10;
        }
        return answer;
    }
}