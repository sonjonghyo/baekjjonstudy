import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int arr[];
	static int minus;
	static int plus;
	static int result;
	static int mcnt;
	static int pcnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		check(N,M);
		System.out.println(result);
	}
	public static void check(int N, int M) {
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] > 0) { //양수부분에 있는지 음수부분에 있는지 체크.
				plus++;
			}else {
				minus++;
			}
		}
		int direction = 0;
		if(minus!=0 && plus!=0) { //둘다 0개가 아니라면?
			if(Math.abs(arr[0]) > Math.abs(arr[N-1])) {
				direction = -1; //-1이면 음수방향
			}else {
				direction = 1; //1이면 양수방향.
			}
		}else {
			if(minus==0)
				direction = 1;
			else
				direction = -1;
		}
		if(direction == -1) {
			if((minus/M)!=0) {
				minus -= M;
				result += Math.abs(arr[0]);
				mcnt += M;
			}else {
				minus -= (minus%M);
				result += Math.abs(arr[0]);
			}
		}else {
			if((plus/M)!=0) {
				plus -= M;
				result += Math.abs(arr[N-1]);
				pcnt += M;
			}else {
				plus -= (plus%M);
				result += Math.abs(arr[N-1]);
			}
		}
		//여기까지가 최대거리 자른것.
		while(minus!=0 || plus!=0) {
			if(direction == -1) {
				if(minus==0)
					direction = 1;
				while(minus!=0) {
					if(minus/M>0) {
						minus -= M;
						result += Math.abs(arr[mcnt]*2);
						mcnt += M;
					}else {
						minus -= (minus%M);
						result += Math.abs(arr[mcnt]*2);
						direction = 1;
					}		
				}
			}else {
				if(plus==0)
					direction = -1;
				while(plus!=0) {
					if(plus/M>0) {
						plus -= M;
						result += Math.abs(arr[N-1-pcnt]*2);
						pcnt += M;
					}else {
						plus -= (plus%M);
						result += Math.abs(arr[N-1-pcnt]*2);
						direction = -1;
					}		
				}
			}			
		}
	}
}