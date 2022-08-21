import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int arr[] = new int[N];
		int max = 0;
		int sum = 0;
		for(int i = 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		loop:
		for(int i = 0; i<N-2; i++) {
			for(int j = i+1; j<N-1; j++) {
				for(int z = j+1; z<N; z++) {
					sum = arr[i] + arr[j] + arr[z];
					if(sum == M) {
						max = sum;
						break loop;
					}else {
						if((sum > max) && (sum < M)) {
							max = sum;
						}
					}
				}
			}
		}
		System.out.println(max);
	}
}
