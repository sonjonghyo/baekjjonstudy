import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static int S;
	static int N;
	static int arr[];
	static int result; //현재 나의 위치와 최대공약수의 차가 가장 작은것을 저장할것임.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken()); //문제에는 X, S갈려나오넹..
		arr = new int[N];
		st = new StringTokenizer(br.readLine()); 
		for(int i = 0; i<N; i++) {
			arr[i] = Math.abs(Integer.parseInt(st.nextToken())-S);
		}
		GCD();
		System.out.println(result);
	}
	public static void GCD() {
		if(N==1) {
			result = arr[0];
			return;
		}
		for(int i = 0; i<arr.length-1; i++) {
			int b = 0;
			int s = 0;
			if(arr[i] > arr[i+1]) {
				b = arr[i];
				s = arr[i+1];
			}else {
				b = arr[i+1];
				s = arr[i];
			}
			int tmp = 0;
			while(true) {
				if(b%s != 0) {
					tmp = b%s;
					b = s;
					s = tmp;
				}else {
					arr[i+1] = s;
					break;
				}
			}			
		}
		result = arr[arr.length-1];
	}
}