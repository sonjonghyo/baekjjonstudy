class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int start = 5;
		//달에 따른 요일 변경을 case문으로 처리
		switch(a) {
		case 1  :
			start = 5;
			break;
		case 2:
			start = 1;
			break;
		case 3:
			start = 2;
			break;
		case 4:
			start = 5;
			break;
		case 5:
			start = 0;
			break;
		case 6:
			start = 3;
			break;
		case 7:
			start = 5;
			break;
		case 8:
			start = 1;
			break;
		case 9:
			start = 4;
			break;
		case 10:
			start = 6;
			break;
		case 11:
			start = 2;
			break;
		case 12:
			start = 4;
			break;
		}
		//1일부터 시작이므로 1을 빼고 1주일은 7일이므로 7의 나머지 계산하기. 
		int day = b - 1 + start;
		day %= 7;
		switch(day) { //마지막 날짜에 대해 요일 찾기.
		case 0:
			answer = "SUN";
			break;
		case 1:
			answer = "MON";
			break;
		case 2:
			answer = "TUE";
			break;
		case 3:
			answer = "WED";
			break;
		case 4:
			answer = "THU";
			break;
		case 5:
			answer = "FRI";
			break;
		case 6:
			answer = "SAT";
			break;
		}
        return answer;
    }
}