class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++) {
			int cnt = 0;
			for(int j = 1; j <= i/2; j++) {
				if(i % j == 0) {
					if(j * j == i) {
						cnt += 1;
					}else {
						cnt += 2;
					}
				}
			}
			if(i == 1) {
				answer -= 1;
			}else {
				if(cnt % 2 == 0) {
					answer += i;
				}else {
					answer -= i;
				}				
			}
		}
        return answer;
    }
}