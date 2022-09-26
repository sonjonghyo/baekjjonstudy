import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int cnt = 0; //감소한 횟수
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int idx = N-1;
		while(idx!=0) {
			if(arr[idx]>arr[idx-1]) {
				idx--;
			}else {
				int minus = arr[idx-1]-arr[idx];
				if(arr[idx-1]-minus-1<=0) {
					while(arr[idx-1]!=1) {
						arr[idx-1]--;
						cnt++;
					}
				}else {
					arr[idx-1] = arr[idx-1]-minus-1;
					cnt+=minus+1;
				}
				idx--;
			}
		}			
		System.out.println(cnt);					
	}
}