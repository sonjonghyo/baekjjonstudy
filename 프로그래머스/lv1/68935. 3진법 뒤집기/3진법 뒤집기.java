import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while(true) {
            if(Math.pow(3,cnt) >= n) {
                break;
            }else {
                cnt++;
            }
        }
        if(Math.pow(3, cnt) == n) {
        	sb.append(1);
        	n = 0;
        }
        cnt--;
        while(cnt != -1) {
            int num = (int)Math.pow(3,cnt--);
            int a = n / num;
            n = n - (num * a);
            sb.append(a);
        }
        String three = sb.toString();
        for(int i = 0 ; i < three.length(); i++) {
        	int a = three.charAt(i)-48;
        	answer += (int)Math.pow(3, i) * a;
        }
        return answer;
    }
}