import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int u[] = {-1,0}; //1번
	static int r[] = {0, 1}; //2번
	static int d[] = {1, 0}; //3번
	static int l[] = {0, -1}; //4번
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); //홀수인 자연수가 들어올수있음.
		int X = Integer.parseInt(br.readLine()); //찾아올 좌표값.
		int startx = N/2; //시작위치 x,y
		int starty = N/2;
		int arr[][] = new int[N][N]; //수를 넣을 공간.
		int idx = 2; //배열안에 넣을 수.
		int i = startx;
		int j = starty;
		arr[i][j] = 1;
		int dir = 1;
		int num = 1;
		while(idx-1!=N*N) {
			if(dir==5) 
				dir = 1;
				if(dir==1) {
					for(int b = 0; b<num; b++) {
						i += u[0]; //c
						j += u[1]; //r
						arr[i][j] = idx++;
						if(idx-1==N*N) break;
					}
					dir++;
				}else if(dir==2) {
					for(int b = 0; b<num; b++) {
						i += r[0];
						j += r[1];
						arr[i][j] = idx++;
						if(idx-1==N*N) break;
					}
					num++;
					dir++;
				}else if(dir==3) {
					for(int b = 0; b<num; b++) {
						i += d[0];
						j += d[1];
						arr[i][j] = idx++;
						if(idx-1==N*N) break;
					}
					dir++;
				}else if(dir==4) {
					for(int b = 0; b<num; b++) {
						i += l[0];
						j += l[1];
						arr[i][j] = idx++;
						if(idx-1==N*N) break;
					}
					dir++;
					num++;
				}
		}
		
		int rex = 0;
		int rey = 0;
		for(int a = 0; a<N; a++) {
			for(int b = 0; b<N; b++) {
				sb.append(arr[a][b]).append(" ");
				if(arr[a][b]==X) {
					rex = a+1; //좌표값이므로 배열은 0부터시작하니 +1해서 넣어주어야한다.
					rey = b+1;
				}
			}
			sb.append("\n");
		}
		sb.append(rex).append(" ").append(rey);
		System.out.println(sb);
	}
}