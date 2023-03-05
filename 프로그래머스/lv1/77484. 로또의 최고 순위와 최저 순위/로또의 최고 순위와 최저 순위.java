class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int answer[] = new int[2];
		int zeros = 0;
		int correct = 0;
		int mynum[] = new int[46]; //1~45의 숫자가 있는지 담을 배열
		for(int i = 0; i < 6; i++) {
			mynum[lottos[i]]++;
			if(lottos[i] == 0)
				zeros++; //알아볼수 없는것 개수 추가.
		}
		for(int i = 0; i < 6; i++) {
			if(mynum[win_nums[i]] != 0) { //내가 가지고 있는 수라면?
				correct++;
			}
		}
		if(zeros == 0) {
			checkcorrect(correct, answer);
		}else {
			checkcorrect(correct, answer);
			correct += zeros;
			checkzcorrect(correct, answer);
		}
        return answer;
    }
    private static void checkzcorrect(int correct, int[] answer) {
		if(correct == 6) {
			answer[0] = 1;
		}else if(correct == 5) {
			answer[0] = 2;
		}else if(correct == 4) {
			answer[0] = 3;
		}else if(correct == 3) {
			answer[0] = 4;
		}else if(correct == 2) {
			answer[0] = 5;
		}else {
			answer[0] = 6;
		}		
	}

	private static void checkcorrect(int correct, int[] answer) {
		if(correct == 6) {
			answer[0] = 1;
			answer[1] = 1;
		}else if(correct == 5) {
			answer[0] = 2;
			answer[1] = 2;
		}else if(correct == 4) {
			answer[0] = 3;
			answer[1] = 3;
		}else if(correct == 3) {
			answer[0] = 4;
			answer[1] = 4;
		}else if(correct == 2) {
			answer[0] = 5;
			answer[1] = 5;
		}else {
			answer[0] = 6;
			answer[1] = 6;
		}
	}
}