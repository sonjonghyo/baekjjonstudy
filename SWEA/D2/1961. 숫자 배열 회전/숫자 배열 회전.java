import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //test케이스 반복횟수 설정.
		for(int tc = 1; tc<=T; tc++) { //1부터 출력하기 위해 1부터 <=T까지.
			int N = sc.nextInt(); //2차원 배열의 크기.
			int arr[][] = new int[N][N];
			String result[][] = new String[N][N];
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					arr[i][j] = sc.nextInt();
					result[i][j] = ""; //전부 빈칸으로 만들어줌.
				}
			}
			//이후로는 규칙을 찾아 회전시킨다.
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<3; j++) {
					for(int z= 0; z<N; z++) {
						if(j==0) {
							result[i][j] += String.valueOf(arr[N-1-z][i]);						
						}else if(j%2==1) {
							result[i][j] += String.valueOf(arr[N-1-i][N-1-z]);
						}else if(j%2==0) {
							result[i][j] += String.valueOf(arr[z][N-1-i]); 
						}	
					}
				}
			}
			System.out.println("#" + tc);
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					System.out.print(result[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}