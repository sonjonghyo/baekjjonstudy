import java.util.*;

class Solution {
    public List solution(int[] numbers) {
        Set<Integer> number = new TreeSet<>();
		for(int i = 0; i < numbers.length-1; i++) {
			for(int j = i + 1; j < numbers.length; j++) {
				number.add(numbers[i] + numbers[j]);
			}
		}
		List<Integer> answer = new ArrayList<>(number);
        return answer;
    }
}