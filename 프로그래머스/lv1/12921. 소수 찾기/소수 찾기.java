class Solution {
    //처음에 범위인 1백만 까지의 배열을 생성해줍니다.
	static int decimal[] = new int[1000001];
    public int solution(int n) {
        int answer = 0;
        //2~100만까지 소수 체크해주는 함수 싱생
		checkdecimal();
		for(int i = 2; i <= n; i++) {
			if(decimal[i] == 1)
				answer++;
		}
        return answer;
    }
    private static void checkdecimal() {
		//소수인지 체크해줄 flag입니다.
		boolean flag = true;
		for(int i = 2; i < decimal.length; i++) {
			//소수인지 체크할 수가 바뀔때 마다 flag를 true로 변경해줍니다.
			flag = true;
			for(int j = 2; j <= Math.sqrt(i); j++) {
				if(i%j == 0) {
					//만약 나누어 떨어진다면 false로 바꾸어줍니다.
					flag = false;
					//그러고 break를 걸어 j에 대한 for문을 끝내줍니다.
					break;
				}
			}
			//j에 대한 for문이 끝나고서 flag가 true면 소수 아니면 false
			if(flag) {
				decimal[i] = 1;
			}
		}
    }
}