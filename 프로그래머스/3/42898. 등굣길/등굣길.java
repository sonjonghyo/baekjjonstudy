class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        //1,1부터 시작이니까 +1 씩 더해주자.
		int dp[][] = new int[n+1][m+1];
		for(int i = 0; i < puddles.length; i++) {
			//물웅덩이라 못가는 구간.
			dp[puddles[i][1]][puddles[i][0]] = -1;
		}
		dp[1][1] = 1;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
                //만약 현재 구간이 -1 이라면 물웅덩이니 다음으로.
				if(dp[i][j] == -1) continue;
                //내 위에 길이 있다면 그 아래도 길이 될수 있으니 더해주기.
				if(dp[i -1][j] > 0)
					dp[i][j] += dp[i-1][j] % 1000000007;
                //내 왼쪽에 길이 있다면 그 오른쪽도 갈수 있으니 더해주기.
				if(dp[i][j-1] > 0)
					dp[i][j] += dp[i][j-1] % 1000000007;
			}
		}
        return dp[n][m] % 1000000007;
    }
    
}