import java.util.Scanner;

public class Solution {
	static int arr[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			arr = new int[N][2];
			for(int i = 0; i<N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			int cnt = 0;
			for(int i = 0; i<N-1; i++) {
				for(int j = i+1; j<N; j++) {
					if(arr[i][0] > arr[j][0] && arr[i][1] < arr[j][1]) {
						cnt++;
					}else if(arr[i][0] < arr[j][0] && arr[i][1] > arr[j][1]) {
						cnt++;
					}
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