import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc);
			int N = sc.nextInt();
			int Q = sc.nextInt();
			int arr[] = new int[N+1];
			for(int i = 1; i<=Q; i++) {
				int L = sc.nextInt();
				int R = sc.nextInt();
				for(int c = L; c<=R; c++) {
					arr[c] = i;
				}
			}
			for(int i = 1; i<=N; i++) {
				sb.append(" ").append(arr[i]);
			}
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}