import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int row = 100;
			int arr[] = new int[row];
			int l = 0;
			int s = 0;
			int max = 0;
			int min = 0;
			for (int i = 0; i < row; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 0; i < T; i++) {
				max = Integer.MIN_VALUE;
				min = Integer.MAX_VALUE;
				for (int a = 0; a < row; a++) {
					if (max < Math.max(arr[a], max)) {
						max = Math.max(arr[a], max);
						l = a;
					}
					if (min > Math.min(arr[a], min)) {
						min = Math.min(arr[a], min);
						s = a;
					}
				}
				arr[l]--;
				arr[s]++;
			}
			max = arr[l];
			min = arr[s];
			for (int a = 0; a < row; a++) {
				if (max < Math.max(arr[a], max)) {
					max = Math.max(arr[a], max);
				}
				if (min > Math.min(arr[a], min)) {
					min = Math.min(arr[a], min);
				}
			}
		System.out.println("#" + tc + " " + (max - min));
		}
		sc.close();
	}
}