import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i = 0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			int cnt = 0;
			for(int i = 1; i<N-1; i++) {
				if(arr[i]>arr[i-1] && arr[i]>arr[i+1]) {
					continue;
				}else if(arr[i]<arr[i-1] && arr[i]<arr[i+1]) {
					continue;
				}else {
					cnt++;
				}
			}
			sb.append(cnt);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}