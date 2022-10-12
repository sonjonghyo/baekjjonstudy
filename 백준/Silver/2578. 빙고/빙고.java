import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	//가로검사 i행마다, 세로검사 0번째행만 검사. 대각선은 맨위왼쪽과 맨위오른쪽에서만 (함수3개구현) 
	static int human[][] = new int[5][5];
	static int result = 0; //빙고의 개수
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i = 0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<5; j++) {
				human[i][j] = Integer.parseInt(st.nextToken()); //철수의 판.
			}
		}
		int cnt = 0;
		loop1:
		for(int r = 0; r<5; r++) {
			st = new StringTokenizer(br.readLine());
			for(int k = 0; k<5; k++) {
				int num = Integer.parseInt(st.nextToken());	
				cnt++;
				result = 0;
				loop2:
				for(int i = 0; i<5; i++) {
					for(int j = 0; j<5; j++) {
						if(human[i][j]==num) {
							human[i][j] = 0;
							break loop2;
						}
					}
				}
				//가로, 세로, 대각선 확인.
				row();
				col();
				dia();
				if(result >= 3) {
					break loop1;
				}
			}
		}
		System.out.println(cnt);
		
	}
	private static void row() { //가로에 대한 빙고
		int cnt = 0;
		for(int i = 0; i<5; i++) {
			cnt = 0;
			for(int j = 0; j<5; j++) {
				if(human[i][j]==0)
					cnt++;
			}
			if(cnt==5)
				result++;
		}
		
	}
	private static void col() { //세로에 대한 빙고
		int cnt = 0;
		for(int i = 0; i<5; i++) {
			cnt = 0;
			for(int j = 0; j<5; j++) {
				if(human[j][i]==0)
					cnt++;
			}
			if(cnt==5)
				result++;
		}
		
	}
	private static void dia() { //대각선에 대한 빙고
		if(human[0][0]==0 && human[1][1]==0 && human[2][2]==0 && human[3][3]==0 && human[4][4]==0)
			result++;
		if(human[0][4]==0 && human[1][3]==0 && human[2][2]==0 && human[3][1]==0 && human[4][0]==0)
			result++;
	}
}