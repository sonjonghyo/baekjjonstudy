import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int cnt = 0;
		for(int i = 0; ; ) {
			if(arr[i]%2==0) {
				arr[i]++;
				if(arr[i]==M) {
					break;
				}
				i=i+L;
				if(i>=N) {
					i -= N;
				}
				cnt++;
			}else {
				arr[i]++;
				if(arr[i]==M) {
					break;
				}
				i=i-L;
				if(i<0) {
					i += N;
				}
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}