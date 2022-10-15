import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); //고정 비용
		int B = Integer.parseInt(st.nextToken()); //가변 비용
		int C = Integer.parseInt(st.nextToken()); //노트북의 가격.
		int sum = 0;
		if(B>=C) {
			System.out.println(-1);
		}else {
			sum = A / (C-B);
			System.out.println(sum+1);
		}	
	}
}