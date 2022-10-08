import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			int K = sc.nextInt();
			int arr[] = new int[K];
			int cnt = 0;
			for(int i = 0; i<N; i++) {
				if(cnt==K) {
					cnt = 0;
				}
				arr[cnt++]++;
			}
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for(int i  = 0; i<K; i++) {
				if(max < arr[i])
					max = arr[i];
				if(min > arr[i])
					min = arr[i];
			}
			sb.append(max-min);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}