import java.util.* ;

class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
		int answer[] = new int[numbers.length];
		for(int i=0 ; i<numbers.length ; i++) {
			if(stack.isEmpty() || numbers[i]<numbers[i-1]) { //비어있거나 전것보다 작다면?
				stack.push(i); //현재 위치를 넣어줘.
			} else { //만약 전 것 보다 크거나 같다면?
				while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]) { //전 것보다 커질때 까지 빼줘.
					answer[stack.pop()] = numbers[i]; //그리고 뺀 곳에 현재 값 저장.
				}
				stack.push(i); //그러고 마지막에 현재의 위치 넣어주기.
			}
		}
		while(!stack.isEmpty()) { //안한 건 전부 -1이다.
			answer[stack.pop()] = -1;
		}
        return answer;
    }
}