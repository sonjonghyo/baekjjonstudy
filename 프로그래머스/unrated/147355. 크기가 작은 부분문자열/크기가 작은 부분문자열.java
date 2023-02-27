class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long tlength = t.length();
		long plength = p.length();
		long pint = Long.parseLong(p);
		String comparet = "";
		long comparetlong = 0;
		for(int i = 0; i < tlength-plength+1; i++) {
			comparet = t.substring(i, (int) (i+plength));
			comparetlong = Long.parseLong(comparet);
			if(comparetlong <= pint) {
				answer++;
			}
		}
        return answer;
    }
}