class Solution {
    public StringBuilder solution(int[] food) {
        StringBuilder answer = new StringBuilder();
		for(int i = 1; i <= food.length-1; i++) {
			food[i] /= 2;
		}
		for(int i = 1; i <= food.length-1; i++) {
			checkfood(i, food, answer);
		}
		answer.append(0);
		for(int i = food.length-1; i >= 1; i--) {
			checkfood(i, food, answer);
		}
        return answer;
    }
    private static void checkfood(int i, int[] food, StringBuilder sb) {
		if(food[i] != 0) {
			for(int j = 0; j < food[i]; j++) {
				sb.append(i);
			}
		}
	}
}