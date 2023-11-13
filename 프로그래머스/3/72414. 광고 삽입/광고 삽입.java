class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
		//총 100시간(99시간59분59초)을 쓰므로 360,000칸의 배열이 필요하다.
		int time[] = new int[360000];
		//우선 log의 시간대 별로 다 초로 변환하여 넣어주기.
		for(int i = 0; i < logs.length; i++) {
			//시작하는 시간
			int st = ((logs[i].charAt(0) - 48) * 10 + logs[i].charAt(1) - 48) * 3600 + ((logs[i].charAt(3)-48) * 10 + logs[i].charAt(4)-48) * 60 + ((logs[i].charAt(6)-48) * 10 + logs[i].charAt(7)-48);
			//끝나는 시간
			int et = ((logs[i].charAt(9) - 48) * 10 + logs[i].charAt(10) - 48) * 3600 + ((logs[i].charAt(12)-48) * 10 + logs[i].charAt(13)-48) * 60 + ((logs[i].charAt(15)-48) * 10 + logs[i].charAt(16)-48);
			//시작하는 시간과 끝나는 시간까지 time배열 1씩 증가시켜주기.
			for(int a = st; a < et; a++) {
				time[a]++;
			}
		}
		long result = 0;
		//time배열에서 adv_time구간동안 제일 높은 누적이 제일 크다.
		//먼저 adv_time을 초로 변환해주자.
		int adv = ((adv_time.charAt(0)-48) * 10 + adv_time.charAt(1)-48) * 3600 + ((adv_time.charAt(3)-48) * 10 + adv_time.charAt(4)-48) * 60 + ((adv_time.charAt(6)-48) * 10 + adv_time.charAt(7)-48);
		//cnt를 주어 cnt == adv가 되었을때 그때부터 맨끝에거 증가하면 맨아래 감소하는 식으로 계산.
		int cnt = 0;
		//맨끝과 시작부분을 알려줄 변수 last와 start.
		int last = 0;
		int start = 0;
		int tmpanswer = 0;
		//누적으로 더해져있는 수를 알기 위한 sum 변수.
		long sum = 0;
		//time 배열의 길이만큼 for문을 돌려주자.
		for(int i = 0; i < 360000; i++) {
			//광고시간만큼 다 보고있다면?
			if(cnt == adv) {
                if(result < sum) {
					result = sum;
					tmpanswer = start;
				}
				//끝은 증가시키고 시작부분은 감소(슬라이딩 윈도우)
				sum += time[last++];
				sum -= time[start++];
			}else {
				cnt++;
				sum += time[last++];
			}
			//result가 sum보다 큰지 확인. 크면 result에 sum 저장.
		}
        
		int hour = tmpanswer / 3600 ;
		int minute = (tmpanswer/60) % 60;
		int second = tmpanswer % 60;
		if(hour < 10) {
			sb.append(0).append(hour).append(":");
		}else {
			sb.append(hour).append(":");
		}
		if(minute < 10) {
			sb.append(0).append(minute).append(":");
		}else {
			sb.append(minute).append(":");
		}
		if(second < 10) {
			sb.append(0).append(second);
		}else {
			sb.append(second);
		}
        answer = sb.toString();
        return answer;
    }
}