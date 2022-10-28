import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken()); //시간 저장
		int M = Integer.parseInt(st.nextToken()); //분 저장
		
		int C = Integer.parseInt(br.readLine()); 
		int sum = M+C;
		while(sum >= 60) {
			sum -= 60;
			H += 1;
			if(H >= 24)
				H = 0;			
		}
		sb.append(H).append(" ").append(sum);
		System.out.println(sb);
		
	}
}