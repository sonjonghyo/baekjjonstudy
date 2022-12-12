import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken()); //지구를 나타내는 수 최대 15
		int S = Integer.parseInt(st.nextToken()); //태양을 나타내는 수 최대 28
		int M = Integer.parseInt(st.nextToken()); //달을 나타내는 수 최대 19
		
		int e = 0;
		int s = 0;
		int m = 0; //실제로 쌓이는 변수는 소문자로 표시해주었습니다.
		int year = 0;
		while(true) {
			if(E == e && S == s && M == m)
				break;
			e++;
			s++;
			m++;
			if(e > 15)
				e = 1;
			if(s > 28)
				s = 1;
			if(m > 19)
				m = 1;
			year++;
		}
		System.out.println(year);
	}
}