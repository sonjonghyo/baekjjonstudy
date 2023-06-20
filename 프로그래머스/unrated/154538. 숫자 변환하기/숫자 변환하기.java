class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int dp[] = new int[y+1];
        for(int i = x; i <= y; i++) {
            //처음이 아니면서 0인 구간(현재 나온적이 없는 구간은 -1로 초기화)
            if(i != x && dp[i] == 0) {
                dp[i] = -1;
                continue;
            }
            if(i * 2 <= y) {
                dp[i*2] = (dp[i*2]==0) ? dp[i] + 1 : (Math.min((dp[i]+1), dp[i*2])); 
            }
            if(i * 3 <= y) {
                dp[i*3] = (dp[i*3]==0) ? dp[i] + 1 : (Math.min((dp[i]+1), dp[i*3]));
            }
            if(i + n <= y) {
                dp[i+n] = (dp[i+n]==0) ? dp[i] + 1 : (Math.min((dp[i]+1), dp[i+n]));
            }
        }
        answer = dp[y];
        return answer;
    }
}