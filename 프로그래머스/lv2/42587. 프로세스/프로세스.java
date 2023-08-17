import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int lo = 0; //현재의 위치를 나타내줄 변수입니다.
        int[] copy = new int[priorities.length];
        for(int i = 0; i < priorities.length; i++) {
            copy[i] = priorities[i];
        }
        Arrays.sort(copy);
        int endpoint = copy.length-1;
        while(true) {
            if(priorities[lo] == 0) { //값이 0인것은 이미 본 우선순위이므로 패스. 다음순서로.
                lo++;
                lo = lo % priorities.length;
                continue;
            }
            if(priorities[lo] == copy[endpoint]) { //만약 현재 위치의 값이 가장 큰값과 같다면?
                answer++;
                if(lo == location) {
                    break;
                }
                priorities[lo] = 0;
                lo++;
                endpoint--;
            }else { //값이 다르다면? 즉 작은 것이라면.
                lo++; //위치만 옮겨라
            }
            lo = lo % priorities.length;
        }
        return answer;
    }
}