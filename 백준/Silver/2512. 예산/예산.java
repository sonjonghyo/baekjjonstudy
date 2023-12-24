import java.io.*;
import java.util.*;

public class Main {
	static int max = 0;
	static int N;
	static int money[];
	static int limit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		money = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(st.nextToken());
			//최댓값 계속 갱신하기.
			if(money[i] > max)
				max = money[i];
		}
		limit = Integer.parseInt(br.readLine());
		System.out.println(binarySearch());
	}
	private static int binarySearch() {
		int left = 1;
		int right = max;
		int sum = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			sum = 0;
			for(int i = 0 ; i < N; i++) {
				if(money[i] > mid) {
					sum += mid;
				}else {
					sum += money[i];
				}
			}
			if(sum > limit) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return right;
	}
}