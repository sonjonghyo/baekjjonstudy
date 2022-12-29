import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //2019년부터 N년까지 누적되는 13일의 금요일을 출력하기위한 수.
		int day = 6; //월 0  화 1 수 2 목 3 금 4 토 5 일 6  (2019년 1월 13일은 일요일이다.) 
		int friday = 0; //13일의 금요일.
		int month = 0;
		for(int year = 2019; year <= N; year++) { //년수 계산.
			for(int i = 1; i <= 12; i++) { //1월부터 12월 계산.
				if(i == 1) {
					month = 12;
				}else {
					month = i-1;
				}
				if(year == 2019 && i == 1)
					continue;
				switch(month) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					day += 3; //요일 3개가 지나므로 3개를 더해줌.
					if(day > 6)
						day -= 7;
					if(day == 4)
						friday++;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					day += 2; //2개를 더해줌.
					if(day > 6)
						day -= 7;
					if(day == 4)
						friday++;
					break;
				case 2: //2월일 경우엔 윤년 계산.
					if((year % 4 == 0) && (year % 100 != 0) || (year % 400) == 0)  {	//윤년이라면?
						day += 1;
						if(day > 6)
							day -= 7;
						if(day == 4)
							friday++;
					}else { //윤년이아니라면?
						if(day == 4)
							friday++;
					}
				}
			}
		}
		System.out.println(friday);
	}
}