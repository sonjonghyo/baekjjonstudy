import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String card[][]; //카드를 [][0]에는 알파벳을 [][1]에는 숫자를 담을 2차원배열을 생성해준다.
	static int num[]; //1~9까지 몇번나왔는지 횟수를 담을 num배열을 만들어준다.
	static int rcnt = 0; //알파벳 R이 나오는 횟수체크
	static int bcnt = 0; //알파벳 B가 나오는 횟수체크
	static int gcnt = 0; //알파벳 G가 나오는 횟수체크
	static int ycnt = 0; //알파벳 Y가 나오는 횟수체크
	static int nummax = 0; //num배열에서 가장많이 나온 횟수를 저장해줄 변수를 만들어준다.
	static int maxidx = 0; //가장많이 나온 수를 저장해준다.
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		card = new String[5][2];
		for(int i = 0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			card[i][0] = st.nextToken();//색깔 넣는 곳.
			card[i][1] = st.nextToken(); //숫자 넣는곳.
		}
		num = new int[10];
		encard();
		numcard();
		if(rcnt == 5 || bcnt == 5 || gcnt == 5 || ycnt == 5) { //1,4번 조건 (카드5장이 모두 같은색일때)
			boolean check = true; //1번조건을 만족하면 false로 만들어 4번조건을 실행하지 못하게 만듦.
			for(int i = 1; i<num.length-4; i++) { //5까지만 비교해주면됌. 5,6,7,8,9까지가 최대로 연속해서 나올수있는 수이기 때문에.
				if(num[i]==1) {
					if(num[i+1] == 1 && num[i+2] == 1 && num[i+3] == 1 && num[i+4] == 1) {
						sb.append(900+i+4); //가장 큰 점수. 1번에 해당
						check = false;
						break;
					}
				}
			}
			if(check) { //만약 연속해서 수가 나오지않았다면 4번조건이므로
				int max = 0; //가장 높은수를 찾기위해 max변수 사용.
				for(int i = 0; i<num.length; i++) {
					if(num[i]!=0) { //0이 아닌 수를 찾아서 가장 마지막에 0이아닌수가 가장 높은수이다.
						max = i;
					}
				}
				sb.append(600+max);
			}
			
		}else if(nummax==4) { //2번조건 (4개의 수가 같은경우)
			sb.append(800+maxidx);
		}else if(nummax==3) { //3번조건 6번조건 (3개의 수가 같은경우)
			int min = 0;
			boolean check = false; 
			for(int i = 0; i<num.length; i++) {
				if(num[i]==2) { //만약 2가 있다면 3번의 조건을 만족하는것이므로
					min = i; //2가 있는 수를 min에 저장하고
					check = true; //check를 true로 만들어 3번조건을 실행하게 해준다
				}
			}
			if(check) { //check가 true이면 3번조건
				sb.append(700+(10*maxidx)+min);
			}else { //else면 6번조건
				sb.append(400+maxidx);
			}
		}else if(nummax==2){ //7번조건, 8번조건 실행.
			int idx = 0; //num[i]가 2가 또 나오는 것을 알기위해서.
			int max = 0;
			int min = 0;
			boolean check = true;
			for(int i = 0; i<num.length; i++) { //먼저 7번조건부터 해준다.
				if(num[i]==2) {
					if(idx==0) { //idx가 0이라는 것은 2장의 수가 같은것이 2개가있다고 가정했을때 1번째 수.
						min = i;
						idx++; //idx++시켜서 다음번에 2가 나오는 수는 else문에 걸리게 해준다.
					}else { //idx가 0이아니라는것은 2개중 2번째수 이므로 max에 저장해준다.
						max = i; //더 큰수이므로 max에 i를 넣고
						check = false; //이 구문이 동작했다는 것은 7번조건이 동작했으므로 더이상 밑은 볼필요가없으므로 false로 만들어준다.
						break; //두번이 다 나왔으니 더이상 for문을 굴릴필요가 없다. 바로 끝내줌.
					}
				}
			}
			if(check) { //만약 7번조건이 실행이 되지않았다면 8번조건 실행.
				sb.append(200+maxidx); //8번조건이 실행된다.
			}else {				
				sb.append(300+(max*10)+(min)); //check가 false이면 7번조건이다.
			}
		}else { //5번조건과 9번조건을 실행해준다.
			boolean check = true;
			for(int i = 1; i<num.length-4; i++) { //5까지만 비교해주면됌. 5,6,7,8,9까지가 최대로 연속해서 나올수있는 수이기 때문에.
				if(num[i]==1) {
					if(num[i+1] == 1 && num[i+2] == 1 && num[i+3] == 1 && num[i+4] == 1) {
						sb.append(500+i+4); //가장 큰 점수. 1번에 해당
						check = false;
						break;
					}
				}
			}
			if(check) { //모든 조건을 만족하지 못했으므로
				sb.append(100+maxidx); //9번조건을 실행해준다.
			}
		}
		System.out.println(sb);
	}
	public static void encard() {
		for(int i = 0; i<5; i++) {
			switch(card[i][0]) {
			case "R" :
				rcnt++;
				break;
			case "B" :
				bcnt++;
				break;
			case "Y" :
				ycnt++;
				break;
			case "G" :
				gcnt++;
				break;
			}
		}
	}
	public static void numcard() {
		for(int i = 0; i<5; i++) {
			int n = Integer.parseInt(card[i][1]);
			switch(n) {
			case 1:
				num[n]++;
				break;
			case 2:
				num[n]++;
				break;
			case 3:
				num[n]++;
				break;
			case 4:
				num[n]++;
				break;
			case 5:
				num[n]++;
				break;
			case 6:
				num[n]++;
				break;
			case 7:
				num[n]++;
				break;
			case 8:
				num[n]++;
				break;
			case 9:
				num[n]++;
				break;		
			}
		}
		for(int i = 0; i<num.length; i++) {
			if(nummax<=num[i]) {
				nummax = num[i];
				maxidx = i;
			}
		}
		
	}
}