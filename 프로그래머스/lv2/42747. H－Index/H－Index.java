import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int max = 0;
        for(int i = 0; i < citations.length; i++) {
            int middle = citations.length - i;
            if(middle <= citations[i]) {
                answer = middle;
                break;
            }
        }
        return answer;
    }
}