import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int cnt;
		int sum = 0;
		if(N==0) {
			cnt = 0;
		}else {
			cnt = 1;
		}
		int arr[] = new int[N];
		for(int i= 0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			sum += arr[i];
			if(sum>M) {
				cnt++;
				sum = arr[i];
			}
		}
		System.out.println(cnt);
	}
}