class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
		int s1 = 0;
		int s2 = 0;
		for(int i = 0; i < goal.length; i++) {
			if(s1 < cards1.length && cards1[s1].equals(goal[i])) {
				s1++;
			}else if(s2 < cards2.length && cards2[s2].equals(goal[i])) {
				s2++;
			}else {
				answer = "No";
				break;
			}
			if(i == goal.length-1)
				answer = "Yes";
		}
        return answer;
    }
}