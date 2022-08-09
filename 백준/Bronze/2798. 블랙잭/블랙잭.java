import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int arr[] = new int[N];
		int sum = 0;
		int max = 0;
		for(int i =0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		for(int a = 0;a<N-2;a++) {
			int fd = arr[a];
			for(int b=1+a;b<N-1;b++) {
				int sd = arr[b];
				for(int c=1+b;c<N;c++) {
					int td = arr[c];
					sum = fd+sd+td;
					if(sum==M) {
						System.out.println(sum);
						System.exit(0);
					}
					if(sum>max && sum<=M) {
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
	}
}