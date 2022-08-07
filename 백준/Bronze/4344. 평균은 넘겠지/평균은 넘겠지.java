import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		for(int i = 0; i<C; i++) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			int sum = 0;
			double avg = 0;
			int cnt = 0;
			double rate = 0;
			for(int j = 0; j<N; j++) {
				int s = sc.nextInt();
				arr[j] = s;
				sum += s;
			}
			avg = sum/N;
			for(int a = 0; a<N; a++) {
				if(arr[a]>avg) {
					cnt++;
				}
			}
			rate = (cnt/(double)N)*100;
			System.out.printf("%.3f%%\n", rate);
		}
		sc.close();
	}
}
