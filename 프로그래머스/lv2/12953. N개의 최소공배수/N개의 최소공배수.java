import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        Stack<Integer> num = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            num.push(arr[i]);
        }
        while(num.size() != 1) {
            int acnt = 2;
            int bcnt = 2;
            int A = num.pop();
            int B = num.pop();
            int comA = A;
            int comB = B;
            while(true) {
                if(comA==comB) { //두개의 수가 같을시에 최소공배수가 되므로
                    num.push(comA); //둘중 아무수나 추가를 해주고
                    break; //함수를 끝내준다.
                }
                if(comA>comB) { //만약 comA가 comB보다 크다면
                    comB = B*bcnt; //더 작은수를 먼저 수를 하나씩 늘려가며 곱해주어야하므로 처음에 2부터 곱해준다.
                    bcnt++; //그러고 bcnt를 1늘려주어 다음에 더 작을시에는 원래수에서 3을 곱하게 해준다.
                }else {
                    comA = A*acnt; //위와 반대이다.
                    acnt++;
                }
		    }
        }
        answer = num.pop();
        return answer;
    }
}