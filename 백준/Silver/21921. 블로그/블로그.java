import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int visitor[] = new int[N];
		int maxsum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N;i ++) {
			visitor[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < X; i++) {
			maxsum += visitor[i];
		}
		int cnt = 1; //최대로 나온 횟수
		int sum = maxsum;
		for(int i = X; i < N; i++) {
			sum += visitor[i];
			sum -= visitor[i-X];
			if(sum > maxsum) {
				maxsum = sum;
				cnt = 1;
			}else if(sum == maxsum)
				cnt++;
		}
		if(maxsum == 0) {
			System.out.println("SAD");
		}else {
			System.out.println(maxsum);
			System.out.println(cnt);
		}
	}
}