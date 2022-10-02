import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc);
			int N = sc.nextInt();
			int K = sc.nextInt();
			int arr[] = new int[N+1];
			for(int i = 0; i<K; i++) {
				arr[sc.nextInt()]++;
			}
			
			for(int i = 1; i<=N; i++) {
				if(arr[i]==0)
					sb.append(" ").append(i);
			}
			
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		
	}
}