import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int money[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		money = new int[N];
		st = new StringTokenizer(br.readLine());
		int max = Integer.MIN_VALUE; //가장 작은 값 저장
		int result = 0; // 결과값 저장하기위한 변수
		for(int i = 0; i<N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
			if(money[i] > max)
				max = money[i];
		}
		M = Integer.parseInt(br.readLine());
		result = binaryresearch(0, max);
		System.out.println(result);
	}
	private static int binaryresearch(int left, int right) {
		int mid = 0;
		while(left <= right) {
			mid =  (left + right)/2;
			long sum = 0;
			for(int i = 0; i<N; i++) {
				if(money[i] < mid) {
					sum += money[i];
				}else {
					sum += mid;
				}
			}
			if(M < sum) {
				right = mid - 1;  
			}else {
				left = mid + 1;
			}
		}
		return right;
	}
}