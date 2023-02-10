import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //응모한 수
		int W = Integer.parseInt(st.nextToken()); //크기의 직사각형
		int H = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken()); //소 한마리당 차지하는 공간
		
		int result = 0;
		result = (W / L) * (H / L);
		if(result > N) {
			result = N;
		}
		System.out.println(result);
	}
}