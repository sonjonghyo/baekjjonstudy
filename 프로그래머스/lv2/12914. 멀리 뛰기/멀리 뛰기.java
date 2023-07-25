class Solution {
    public long solution(int n) {
        long answer = 0;
        long sum[] = new long[n+1];
        sum[1] = 1;
        if(n >=2) {
            sum[2] = 2;
        }
        for(int i = 3; i <= n; i++) {
            sum[i] = (sum[i-1] + sum[i-2])%1234567;
        }
        answer = sum[n];
        return answer;
    }
}