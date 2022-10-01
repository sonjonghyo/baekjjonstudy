import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int arr[][] = new int[N][M];
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<M; j++) {
					arr[i][j] = sc.nextInt();
				} 
			}
			int maxscore = Integer.MIN_VALUE; //1등이 푼 문제의 수
			int maxhuman = 0; //1등한 사람의 수.
			if(M==0) {
				maxscore = 0;
				maxhuman = 1;
			}
			for(int i = 0; i<N; i++) {
				int sum = 0;
				for(int j = 0; j<M; j++) {
					sum += arr[i][j];
				}
				if(maxscore < sum) {
					maxscore = sum;
					maxhuman = 1;
				}else if(maxscore == sum) {
					maxhuman++;
				}
			}
			sb.append(maxhuman).append(" ").append(maxscore);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}