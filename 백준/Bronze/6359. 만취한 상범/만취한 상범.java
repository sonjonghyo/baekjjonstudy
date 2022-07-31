import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int sum = 0;
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int x = 1; x <= n; x++) {
				for (int y = 1; y <= n; y++) {
					if (x * y > n)
						break;
					if ((x * y) % x == 0) {
						if (arr[x * y - 1] == 0) {
							arr[x * y - 1] = 1;
						} else {
							arr[x * y - 1] = 0;
						}
					}
				}
			}
			for (int z = 0; z < n; z++) {
				sum += arr[z];
			}
			System.out.println(sum);
		}
	}
}
