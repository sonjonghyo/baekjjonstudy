import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int tc = 1; ;tc++) { //무한 반복문 (L,P,V가 0이 나오면 끝냄.)
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			if(L == 0 && P == 0 && V == 0) {
				break;
			}
			long remainder = V%P;
			if(remainder > L) {
				remainder = L;
			}
			long vacation = (V/P)*L + remainder; //(휴가쓸수있는기간/연속휴가기간)*연속된 기간동안 쓸수있는 날짜 + (휴가쓸수있는기간%연속휴가기간) ->즉 나머지. 
			System.out.println("Case " + tc + ": " + vacation);
		}
	}
}
