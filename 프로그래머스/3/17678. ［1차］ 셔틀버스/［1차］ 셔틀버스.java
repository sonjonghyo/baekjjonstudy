import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int sumMinute[] = new int[timetable.length];
		String split[] = new String[2];
		for(int i = 0; i < timetable.length; i++) {
			split = timetable[i].split(":");
			int ho = Integer.parseInt(split[0]) * 60; 
			int mi = Integer.parseInt(split[1]);
			sumMinute[i] = ho + mi;
		}
		Arrays.sort(sumMinute); //시간순 정렬
		boolean flag = true;
		//시작 시간 09:00 => 분으로 바꿀시 540 시작.
		int start = 540;
		//현재까지 총 탄 사람들.
		int cnt = 0;
		//지금 버스에 타고있는 사람
		int nowbus = 0;
		//버스 운행 횟수
		int busnum = 0;
		//현재 탄 사람의 시간.
		int nowtime = 0;
		while(flag) {
			//버스 시간이 현재 시간보다 작을때 사람 추가.
			while(start >= sumMinute[cnt]) {
				nowtime = sumMinute[cnt];
				nowbus++;
				cnt++;
				//현재 탄 사람의 수와 총 탈 수 있는 사람이 딱 맞다면?
				if(nowbus == m) {
					//태울수 없으니 일단 while문 끝내주기.
					break;
				}
				//만약 끝까지 다 태웠으면?
				if(cnt == timetable.length) {
					flag = false;
					break;
				}
			}
            if(!flag)
                continue;
			//저 안에서 나오면 운행을 한번 한것이니까 운행횟수 추가.
			busnum++;
			//운행횟수랑 총 운행할수 있는 횟수랑 맞게 떨어진다면?
			if(busnum == n) {
				flag = false; //운행 끝.
				continue;
			}
			//다음 배차로 보내주기.
			start += t;
			nowbus = 0; //다음배차로 갈땐 사람 다 내리고 가니까 현재 버스 사람 0으로 만들어주자.
			
		}
		StringBuilder sb = new StringBuilder();
		int hou = 0;
		int min = 0;
		//내가 탈수 있는지 부터 확인.
		if(nowbus < m) { //가장 늦은 시간에 탈 수 있다. 즉 start시간에 탑승가능.
			hou = start / 60;
			min = start % 60;
		//꽉 차서 탈 수 없다면 마지막에 탄 사람보다 1분 빨리 나오기.
		}else {
			nowtime -= 1;
			hou = nowtime / 60;
			min = nowtime % 60;
		}
		if(hou < 10) {
			sb.append("0").append(hou);
		}else {
			sb.append(hou);
		}
		sb.append(":");
		if(min < 10) {
			sb.append("0").append(min);
		}else {
			sb.append(min);
		}
        answer = sb.toString();
        return answer;
    }
}