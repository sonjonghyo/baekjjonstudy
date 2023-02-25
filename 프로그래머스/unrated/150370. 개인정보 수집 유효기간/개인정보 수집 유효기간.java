import java.util.ArrayList;
import java.util.List;

class Solution {
    public List solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        String nowday[] = today.split("\\.");
		int year = Integer.valueOf(nowday[0]);
		int month = Integer.valueOf(nowday[1]);
		int tday = Integer.valueOf(nowday[2]);
		int realday = (year * 10000 + month * 100 + tday);
		for(int i = 0; i < privacies.length; i++) {
			String day[] = privacies[i].split(" ");
			int protectperiod = 0; //terms에 있는 보호기간 찾기
			for(int j = 0; j < terms.length; j++) {
				String term[] = terms[j].split(" ");
				if(day[1].equals(term[0])) { //만약 두개가 서로 같으면?
					protectperiod = Integer.valueOf(term[1]);
					break; //더이상 볼 필요가 없으므로.
				}
			}
			String ymd[] = day[0].split("\\."); //현재의 년도 월 일을 .을 기준으로 나누기.
			//문자열을 다 더하려니 오히려 더 꼬임. 차라리 처음에 int로 바꿔줘서 하는게 더 효율적 일 것 같음.
			int protectyear =  Integer.valueOf(ymd[0]);
			int protectmonth =  Integer.valueOf(ymd[1]) + protectperiod;
			int protectday =  Integer.valueOf(ymd[2]) - 1;
			if(protectday == 0) { //일수가 0일때.
				protectmonth -= 1;
				protectday = 28;
			}
			if(protectmonth == 0) { //달이 0일때
				protectyear -= 1;
				protectmonth = 12;
			}
			while(protectmonth > 12) { //달이 12개월보다 클때.
				protectyear += 1;
				protectmonth -= 12;
			}
			int realprotectday = (protectyear * 10000 + protectmonth * 100 + protectday);
			if(realday > realprotectday) {
				answer.add(i+1);
			}
		}
        return answer;
    }
}