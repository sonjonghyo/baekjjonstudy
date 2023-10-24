import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        //가장 오래걸리는 시간.
        long max = (long)n * times[times.length-1];
        answer = binarySearch(times, 0, max, n);
        return answer;
    }
    private static long binarySearch(int times[], long l, long h, int n) {
        //쓰일 수 있는 사람의 수
        long cnt = 0;
        //마지막 값을 저장해줄 변수.
        long result = 0;
        //l이 h보다 같거나 커지면 끝.
        while(l <= h) {
            //계속 사람 초기화 시켜줌.
            cnt = 0;
            //중간값 설정.
            long mid = (l + h)/2;
            //시간에 대해 쓰일 수 있는 사람을 구해줍니다.
            for(int i = 0; i < times.length; i++) {
                //mid에 시간을 나누어 사용될 수 있는 사람 누적합으로 더해주기.
                cnt += mid / times[i];
            }
            //만약 사람이 n명보다 적다면?
            if(cnt < n) {
                //사람이 부족하므로 l의 값을 mid + 1로 변경해준다.
                l = mid + 1;
            //사람이 더 많거나 같다면
            }else {
                //사람이 충분하므로 h의 값을 mid -1로 설정하고
                h = mid - 1;
                //결과값을 mid로 저장해놓습니다.
                result = mid;
            }
        }
        //이렇게 while문이 끝나고 나온 result의 값을 반환해 줍니다.
        return result;
    }
}