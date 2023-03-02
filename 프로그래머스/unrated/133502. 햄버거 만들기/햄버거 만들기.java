import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> hambuger = new Stack<>();
		Stack<Integer> remain = new Stack<>();
		for(int i = 0; i < ingredient.length; i++) {
			hambuger.add(ingredient[i]);
			if(hambuger.size() >= 4) {
				if(hambuger.peek() == 1) {
					remain.add(hambuger.pop());
					for(int j = 1; j < 4; j++) {
						if(j == 1) {
							check(hambuger, remain, 3);
							if(remain.size() == 0)
								break;
						}else if(j == 2) {
							check(hambuger, remain, 2);
							if(remain.size() == 0)
								break;
						}else if(j == 3) {
							if(hambuger.peek() == 1) {
								hambuger.pop();
								remain.removeAllElements();
								answer++;
							}else {
								while(!remain.isEmpty()) {
				hambuger.add(remain.pop());
			}
							}
						}
					}
				}
			}
		}
        return answer;
    }
    private static void check(Stack<Integer> hambuger, Stack<Integer> remain, int num) {
		if(hambuger.peek() == num) {
			remain.add(hambuger.pop());
		}else {
			while(!remain.isEmpty()) {
									hambuger.add(remain.pop());									
								}
		}
	}
}