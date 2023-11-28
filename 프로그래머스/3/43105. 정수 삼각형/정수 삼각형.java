class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int length = triangle.length;
		//누적값을 축적해줄 dp 배열을 생성.
		int dp[][] = new int[length][length];
		//맨 처음 시작하는 부분인 0,0은 dp에 그대로 넣어주자.
		dp[0][0] = triangle[0][0];
		//1부터 시작해 마지막 삼각형 까지 내려가기.
		for(int i = 1; i < length; i++) {
			//j는 삼각형이므로 1,1 2,2이런식으로 끝이 i와 같으니 i까지만 계산.
			for(int j = 0; j <= i; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][j] + triangle[i][j];
				}else if(j == i) {
					dp[i][j] = dp[i-1][j-1] + triangle[i][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j] , dp[i-1][j] + triangle[i][j]);
				}
				if(dp[i][j] > answer)
					answer =dp[i][j];
			}
		}
        return answer;
    }
}