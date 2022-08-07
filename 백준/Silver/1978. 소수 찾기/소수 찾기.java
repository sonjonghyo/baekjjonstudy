import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			int s = sc.nextInt();
			if(s==2)
				cnt++;
			for(int a = 2; a<s; a++) {
				if(s%a==0) {
					break;
				}
				if(s-1==a) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
