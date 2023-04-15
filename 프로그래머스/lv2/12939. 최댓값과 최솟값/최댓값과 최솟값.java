class Solution {
    public String solution(String s) {
        String answer = "";
        String split[] = s.split(" ");
		long max = Long.MIN_VALUE;
		long min = Long.MAX_VALUE;
		for(int i = 0; i < split.length ; i++) {
			if(Long.parseLong(split[i]) > max) {
				max = Long.parseLong(split[i]);
			}
			if(Long.parseLong(split[i]) < min) {
				min = Long.parseLong(split[i]);
			}
		}
        answer = min + " " + max;
        return answer;
    }
}