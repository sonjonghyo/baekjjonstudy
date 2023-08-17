class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right-left + 1)];
        int cnt = 0;
        long share = 0; //몫(열의 위치)
        long remain = 0; //나머지(행의 위치)
        for(long i = left; i <= right; i++) {
            share = i/n;
            remain = i%n;
            answer[cnt++] = (int)Math.max(share,remain) + 1;
        }
        return answer;
    }
}