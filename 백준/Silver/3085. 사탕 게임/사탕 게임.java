import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N; //보드의 크기 N
	static char candy[][];
	static int maxSum;
	static boolean finish; //끝났는지 확인해주는 함수.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		candy = new char[N][N]; //사탕을 담아줍니다.
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				candy[i][j] = s.charAt(j);
			}
		}
		//가로 먼저 비교
		//비교하기 전 먼저 확인
		maxSum = 0;
		checkRow();
		if(!finish)
			checkCol();
		
		if(finish) {
			System.out.println(N);
		}else {
			System.out.println(maxSum);
		}
	}
	private static void checkCol() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N-1; j++) { //2칸씩 비교할 것이므로 마지막 -1까지만 확인해줍니다.
				if(finish) //이미 최대가 나왔다면 더 볼필요가 없다. 끝내주기.
					return;
				if(candy[j][i] == candy[j+1][i]) { //만약 두개의 색이 같다면? 
					continue; //고를필요없으니 내두기.
				}else { //두개의 색이 다르다면?
					changeColCandy(j,i); //사탕바꿔주기.
					//바꿔준후 가로,세로 이어지는 것 계산.
					calculCandy();
					changeColCandy(j,i);
				}
			}
		}
		
	}
	private static void changeColCandy(int j, int i) {
		char tmp = candy[j][i];
		candy[j][i] = candy[j+1][i];
		candy[j+1][i] = tmp;
		
	}
	private static void checkRow() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N-1; j++) { //2칸씩 비교할 것이므로 마지막 -1까지만 확인해줍니다.
				if(finish) //이미 최대가 나왔다면 더 볼필요가 없다. 끝내주기.
					return;
				if(candy[i][j] == candy[i][j+1]) { //만약 두개의 색이 같다면? 
					continue; //고를필요없으니 내두기.
				}else { //두개의 색이 다르다면?
					changeRowCandy(i,j); //사탕바꿔주기.
					//바꿔준후 가로,세로 이어지는 것 계산.
					calculCandy();
					changeRowCandy(i,j); //되돌려놓기
				}
			}
		}
		
	}
	private static void calculCandy() { //가로세로 전부 계산할것.
		char compare = ' ';
		int cnt = 1;
		for(int i = 0; i < N; i++) { //가로 계산
			cnt = 1; //무조건 1개는 있으므로.
			for(int j = 0; j < N; j++) {
				if(j == 0) {
					compare = candy[i][j];
				}else {
					if(compare == candy[i][j]) { //비교하는 두개의 사탕색이 같다면?
						cnt++;
					}else { //두개의 사탕색이 다르다면?
						compare = candy[i][j]; //비교할 사탕을 바꿔주고
						if(maxSum < cnt) //cnt가 가장 긴것보다 크다면
							maxSum = cnt; //그것으로 변경해줍니다.
						cnt = 1; //그러고 cnt는 초기화.
					}
					if(maxSum < cnt) //cnt가 가장 긴것보다 크다면
						maxSum = cnt; //그것으로 변경해줍니다.
				}
				if(cnt == N) { //만약 N까지 증가했다면?
					finish = true;
					return; //함수 끝내주기. (이것보다 긴것이 없으므로.)
				}
			}
		}
		
		for(int i = 0; i < N; i++) { //세로계산
			cnt = 1; //무조건 1개는 있으므로.
			for(int j = 0; j < N; j++) {
				if(j == 0) {
					compare = candy[j][i];
				}else {
					if(compare == candy[j][i]) { //비교하는 두개의 사탕색이 같다면?
						cnt++;
					}else { //두개의 사탕색이 다르다면?
						compare = candy[j][i]; //비교할 사탕을 바꿔주고
						if(maxSum < cnt) //cnt가 가장 긴것보다 크다면
							maxSum = cnt; //그것으로 변경해줍니다.
						cnt = 1; //그러고 cnt는 초기화.
					}
					if(maxSum < cnt) //cnt가 가장 긴것보다 크다면
						maxSum = cnt; //그것으로 변경해줍니다.
				}
				if(cnt == N) { //만약 N까지 증가했다면?
					finish = true;
					return; //함수 끝내주기. (이것보다 긴것이 없으므로.)
				}
			}
		}
	}
	private static void changeRowCandy(int i, int j) {
		char tmp = candy[i][j];
		candy[i][j] = candy[i][j+1];
		candy[i][j+1] = tmp;
	}
}