import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean check = false;
	static int H;
	static int W;
	static int storage[][];
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		storage = new int[W][H];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<W; i++) {
			int f = Integer.parseInt(st.nextToken());
			f-=1; //인덱스가 0부터 시작하므로 1감소.
			for(int j = 0; j<=f; j++) {
				storage[i][j]++;
			}
		}
		calcul();
		System.out.println(result);
	}
	public static void calcul() {
		for(int i = 0; i<H; i++) {
			int cnt = 0; //빗물이 얼마나 담겼는지 알려주는 변수
			check = false;
			for(int j = 0; j<W; j++) {
				if(storage[j][i]==1 && !check) { //빗물을 담을 준비가 되었다.
					check = true;
					continue;
				}
				if(check) {
					if(storage[j][i]==0) {
						cnt++;
					}else {
						result += cnt;
						cnt = 0;
					}
				}
			}
		}		
	}
}