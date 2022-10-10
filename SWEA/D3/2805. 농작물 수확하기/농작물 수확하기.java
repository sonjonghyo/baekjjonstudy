import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			for(int i = 0; i<N; i++) {
				String s = sc.next();
				for(int j = 0; j<N; j++) {
					arr[i][j] = s.charAt(j) - '0';
				}
			}
			int half = N/2; //N크기의 범위의 중앙에서 x,y좌표 거리의 합이 N/2보다 작아야 범위이내.
			int sum = 0;
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					int mi = Math.abs(half-i);
					int mj = Math.abs(half-j);
					if(mi+mj > half) { //두개의 합이 절반보다 클경우엔 범위 밖.
						continue;
					}else { //절반보다 작을시에 범위이내이므로 그때 i,j좌표를 sum에 누적시킴..
						sum += arr[i][j];
					}
				}
			}
			sb.append(sum);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}