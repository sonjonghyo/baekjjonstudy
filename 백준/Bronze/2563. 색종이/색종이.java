import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][]arr = new int[100][100];
		int sum = 0;
		int x =0;
		int y =0;
		for(int i = 0; i<N; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			for(int j = x; j<x+10; j++) {
				for(int k = y; k<y+10; k++) {
					arr[j][k] = 1;
				}
			}
		}
		for(int i = 0;i<arr.length; i++) {
			for(int j =0; j<arr[i].length; j++) {
				if(arr[i][j]==1) {
					sum++;
				}
			}
		}
		System.out.println(sum);
		sc.close();
	}
}
