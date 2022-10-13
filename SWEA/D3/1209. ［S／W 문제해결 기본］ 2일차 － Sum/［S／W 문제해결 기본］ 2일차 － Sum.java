import java.util.Scanner;

public class Solution {
	static int arr[][];
	static int resultmax, rowmax, colmax, dalmax;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=10; tc++) {
			sb.append("#").append(tc).append(" ");
			int T = sc.nextInt();
			arr = new int[100][100];
			for(int i = 0; i<100; i++) {
				for(int j = 0; j<100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			resultmax = 0;
			rowmax = 0;
			colmax = 0;
			dalmax = 0;
			rowsum();
			colsum();
			dalsum();
			resultmax = Math.max(Math.max(rowmax, colmax), dalmax);
			sb.append(resultmax);
			if(tc!=10)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	private static void dalsum() {
		int dalsum = 0;
		for(int i = 0; i <10; i++) {
			dalsum += arr[i][i];
		}
		if(dalsum > dalmax)
			dalmax = dalsum;
		
		dalsum = 0;
		int cnt = 0;
		for(int i = 9; i>=0; i--) {
			dalsum += arr[i][cnt];
			cnt++;
		}
		if(dalsum > dalmax)
			dalmax = dalsum;
		
	}
	private static void colsum() {
		int colsum;
		for(int i = 0; i<100; i++) {
			colsum = 0;
			for(int j = 0; j<100; j++) {
				colsum += arr[j][i];
			}
			if(colmax < colsum)
				colmax = colsum;
		}
		
	}
	private static void rowsum() {
		int rowsum;
		for(int i = 0; i<100; i++) {
			rowsum = 0;
			for(int j = 0; j<100; j++) {
				rowsum += arr[i][j];
			}
			if(rowmax < rowsum)
				rowmax = rowsum;
		}
		
	}
}