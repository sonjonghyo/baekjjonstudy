import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long result = least(a,b);
			sb.append(result);
			if(i != N-1)
				sb.append("\n");
		}
		System.out.println(sb);
	}
	static long least(int A, int B) { //유클리드 호제법을 사용함.
		long Big = 0; //큰수
		long Small = 0; //작은수 (비교해서 큰수를 작은수로 나누어야하기때문이다.)
		long RealBig = 0;
		long RealSmall = 0;
		if(A<B) {
			Big = B;
			RealBig = B;
			Small = A;
			RealSmall = A;
		}else {
			Big = A;
			RealBig = A;
			Small = B;
			RealSmall = B;
		}
		long temp = 0; //비교해줄 수.
		do {
			if(Big%Small != 0) { //만약 큰수에서 작은수를 나눈 나머지가 0이아니라면
				temp = Big%Small; //두개를 나눈 나머지를 temp에 저장하고.
				Big = Small; //큰수는 작은수로 바뀌고
				Small = temp; //작은수는 나머지로 바뀌는 것을 나머지가 0이 될때까지 반복하는 것이 유클리드 호제법이다.
			}else {
				long LCM = (RealBig * RealSmall) / Small;
				return LCM;
			}
		} while(true);
	}
}