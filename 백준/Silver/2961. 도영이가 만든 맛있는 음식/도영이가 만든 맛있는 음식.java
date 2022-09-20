import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int taste[][];
	static int sour; //신맛을 저장해줄 변수
	static int salty; //짠맛을 저장해줄 변수
	static int min = Integer.MAX_VALUE; //신맛과 짠맛의 차가 가장작은것을 정해주기.
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		taste = new int[N][2];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken()); //신맛 저장(사용한 재료의 신맛의 곱)
			taste[i][1] = Integer.parseInt(st.nextToken()); //쓴맛 저장(합)
		}
		bitmask();
		System.out.println(min);
	}
	public static void bitmask() {
		for(int i = 0; i < (1<<N); i++) {
			sour = 0;
			salty = 0;
			for(int j = 0; j<N; j++) {
				if((i & (1<<j)) > 0) {
					if(sour==0)
						sour = 1;
					sour *= taste[j][0];
					salty += taste[j][1];
				}
			}
			if(sour!=0 || salty !=0)
				min = Math.min(min, Math.abs(sour-salty));
		}
	}
}