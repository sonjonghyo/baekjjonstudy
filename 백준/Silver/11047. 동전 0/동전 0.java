import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int cnt = 0;
		while(K!=0) {
			if(K>=arr[--N]) {
				K -= arr[N];
				N = arr.length;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}