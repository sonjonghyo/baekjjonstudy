class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = 0;
        int min = 0;
        for(int i = 0; i < sizes.length; i++) {
            int tmpMax = Math.max(sizes[i][0], sizes[i][1]);
            int tmpMin = Math.min(sizes[i][0], sizes[i][1]);
            max = Math.max(max, tmpMax);
            min = Math.max(min, tmpMin);
        }
        answer = max * min;
        return answer;
    }
}