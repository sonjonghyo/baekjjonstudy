import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int arrA[];
	static int arrB[];
	static int result = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		arrA = new int[N];
		arrB = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		selectsort(N);
		System.out.println(result);
	}
	
	static void selectsort(int N) {
		compare(N);
		for(int i = N-1; i>=1; i--) {
			int swapcnt = i;
			int max = arrA[i];
			for(int j = i-1; j>=0; j--) {
				if(max < arrA[j]) {
					max = arrA[j];
					swapcnt = j;
				}
			}
				if(swapcnt != i) {
					int tmp = arrA[i];
					arrA[i] = arrA[swapcnt];
					arrA[swapcnt] = tmp;
					compare(N);
				}
			}
		}
	static void compare(int N) {
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			if(arrA[i] == arrB[i]) {
				cnt++;
			}else {
				break;
			}
			if(cnt==N) {
				result++;
			}
		}
	}
}