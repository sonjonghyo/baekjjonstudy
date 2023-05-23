class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int zeroCount = 0;
        int changeCount = 0;
        while(s.length() != 1) {
            int count = 0;
            int length = s.length();
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') {
                    count++;
                }
            }
            zeroCount += count;
            length -= count;
            s = Integer.toBinaryString(length);
            changeCount++;
        }
        answer[0] = changeCount;
        answer[1] = zeroCount;
        return answer;
    }
}