class Solution {
    public int[] solution(int n) {
        int length = 0;
        for(int i = 1; i <= n; i++) {
            length += i;
        }
        int[] answer = new int[length];
        int cnt = 0;
        int twist = n;
        int dtwist = 0;
        int utwist = n;
        char dir = 'L';
        int i = 0;
        int number = 1;
        while(number != length+1) {
            if(cnt == twist) {
            	if(dir == 'L' || dir == 'R') {
            			cnt = 0;
            			twist--;
            			if(dir == 'L') {
            				dir = 'R';
            				dtwist += 2;
            			}else if(dir == 'R') {
            				dir = 'U';
            			}
            			continue;
            	}else if(dir == 'U') {     
            			cnt = 0;
            			twist--;
            			dir = 'L';
            			utwist--;
            			continue;
            	}            	
            }else {
            	if(dir == 'L') {
            		i += cnt + dtwist ;
            	}else if(dir == 'R') {
            		i++;
            	}else if(dir == 'U') {
            		i -= (utwist - cnt);
            	}
            }
            answer[i] = number++;
            cnt++;
        }
        return answer;
    }
}