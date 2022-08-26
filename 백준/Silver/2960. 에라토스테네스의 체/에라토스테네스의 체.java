import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int arr[] = new int[N+1];
		for(int i = 2; i<=N; i++) {
			arr[i] = i;
		}
		int idx = 1;
		int che = 2;
		int result[] = new int[N];
		while(cnt != K) {
			idx++;
			if(idx>N) {
				che++;
				idx=che-1;
				continue;
			}
			if(arr[idx]!=0 && arr[idx]%che==0) {
				result[cnt] = arr[idx];
				arr[idx] = 0;
				cnt++;
			}
		}
		System.out.println(result[cnt-1]);	
	}
}