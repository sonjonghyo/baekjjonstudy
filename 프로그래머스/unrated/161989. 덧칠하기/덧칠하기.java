class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int paint[] = new int[n+1];
		for(int i = 0; i < section.length; i++) {
			paint[section[i]] = 1; //페인트 칠해야하는 곳은 1로 만들기.
		}
		int roller = 0; //롤러
		for(int i = 1; i < paint.length; i++) {
			if(paint[i] == 1) { //페인트를 칠해야 하는 공간이라면?
				if(roller == 0) {
					roller = 1;
					answer++;
				}else {
					roller++;
				}
			}else { //칠하지 않아도 된다면?
				if(roller != 0) { //만약 페인트를 칠하는 중이었다면.
					roller++;
				}
			}
			if(roller == m) { //칠할 수 있는 길이를 다 썼다면
				roller = 0; //다시 초기화 해주자.
			}
		}
        return answer;
    }
}