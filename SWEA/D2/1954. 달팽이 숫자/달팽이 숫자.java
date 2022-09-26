import java.util.Scanner;

public class Solution {
	static int dx[] = {-1,0,1,0}; //상, 우, 하, 좌 순
	static int dy[] = {0,1,0,-1};
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			System.out.println("#" + tc);
			int N = sc.nextInt();
			int arr[][] = new int[N][N];
			int cnt = 1;
			arr[0][0] = cnt++;
			int sx = 0;
			int sy = 0;
			while(cnt!=N*N+1) {
				for(int i = 0; i<4; i++) {
					int cx = sx + dx[i];
					int cy = sy + dy[i];
					if(cx<0 || cy<0 || cx>=N || cy>=N)
						continue;
					if(arr[cx][cy]==0) {
						while(true) {
							arr[cx][cy] = cnt++;
							cx=cx+dx[i];
							cy=cy+dy[i];
							if(cx<0 || cy<0 || cx>=N || cy>=N)
								break;
							if(arr[cx][cy]!=0)
								break;
						}
						sx = cx-dx[i];
						sy = cy-dy[i];
					}
				}
			}
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}