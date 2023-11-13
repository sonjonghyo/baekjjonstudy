class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        //전체 플레이시간만큼 배열만들어주기.
		int pt = changeTime(play_time);
		int time[] = new int[pt + 2];
		//우선 log의 시간대 별로 다 초로 변환하여 넣어주기.
		for(int i = 0; i < logs.length; i++) {
			//시작하는 시간
			int st = changeTime(logs[i].split("-")[0]);
			//끝나는 시간
			int et = changeTime(logs[i].split("-")[1]);
			//시작시간은 더해주고
			time[st]++;
			//종료시간은 빼주자
			time[et]--;
			//위처럼 하는 이유는 누적합을 하기 위해서.
		}
		//누적합 해주기.
		for(int i = 1; i <= pt; i++) {
			time[i] += time[i-1];
		}
		int result = 0;
		long sum = 0;
		//먼저 adv_time을 초로 변환해주자.
		int adv = changeTime(adv_time);
		//먼저 광고시간까지 누적합 구해주고?
		for(int i = 0; i < adv; i++) {
			sum += time[i];
		}
		//광고시간 증가시키면서 비교하기.
		int adt = adv;
		//현재의 최대값을 누적된 합으로 저장시켜놓은 후
		long max = sum;
		//최대 전체상영시간 - 광고시간까지
		for(int i = 0; i < pt - adv; i++) {
			//누적합에 슬라이딩 윈도우식으로 계산.
			sum += time[adt++] - time[i];
			//최대값나오면 max에 저장
			if(max < sum) {
				max = sum;
				//+1을 해준 이유는 내 현재시간이 아닌 다음 시간이 시작시간이므로 +1을 해준다.
				result = i + 1;
			}
				
		}
        return returnTime(result);
    }
    private static int changeTime(String str) {
		//split으로 쪼개면 시간, 분, 초 3개가 나오니 그거 배열순으로 저장해서 return해주기.
		int h = Integer.parseInt(str.split(":")[0]);
		int m = Integer.parseInt(str.split(":")[1]);
		int s = Integer.parseInt(str.split(":")[2]);
		return h * 3600 + m * 60 + s;
	}
	
	private static String returnTime(int time) {
		String h = String.format("%02d", time / 3600);
		time %= 3600;
		String m = String.format("%02d", time / 60);
		String s = String.format("%02d", time % 60);
		return h + ":" + m + ":" + s;
	}
}