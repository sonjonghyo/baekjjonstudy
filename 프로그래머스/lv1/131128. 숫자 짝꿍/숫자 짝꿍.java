class Solution {
    public StringBuilder solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
		int xnum[] = new int[10]; //X의 0~9까지의 숫자들을 저장해줄 배열
		int ynum[] = new int[10]; //Y의 0~9까지의 숫자들을 저장해줄 배열
		
		//먼저 X의 0~9까지의 개수 누적
		for(int i = 0; i < X.length(); i++) {
			xnum[X.charAt(i)-'0']++;
		}
		
		//Y의 0~9까지의 개수 누적
		for(int i = 0; i < Y.length(); i++) {
			ynum[Y.charAt(i)-'0']++;
		}
		
		int cnt = 9;
		while(cnt != -1) { //-1까지 내려간다면.
			if(xnum[cnt] != 0 && ynum[cnt] != 0) { //둘다 0이 아닐때만 작동해야함.
				answer.append(cnt); //stringbuiler에 해당 수를 추가시켜주고
				//x와 y의 개수를 감소시켜줍니다.
				//0은 한번만 감소.
				if(cnt == 0 && answer.length()==1) {
					ynum[0] = 0;
					xnum[0] = 0;
				}else {
					xnum[cnt]--; 
					ynum[cnt]--; 					
				}
			}else { //만약 둘중 하나라도 0이라면 cnt감소.
				cnt--;
			}
		}
		if(answer.length() == 0) {
            answer.append(-1);
		}
        return answer;
    }
}