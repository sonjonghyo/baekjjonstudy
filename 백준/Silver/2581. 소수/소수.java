import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int sum = 0;
		int min = M; // 최소값 설정을 위해 M이 처음에 최소값이라 가정.
		double m = 0;
		for (int i = M; i <= N; i++) {
			if(i>3) {
				m = Math.sqrt(i);
			}else if(i==1){
				m = 1;
			}else {
				m = i;
			}
			for (int a = 2; a <= m; a++) {
				if(i==2) {
					if (sum == 0) {
						min = i;
					}
					sum +=2;
					break;
				} else if(i==3) {
					if (sum == 0) {
						min = i;
					}
					sum +=3;
					break;
				}
				if (i % a == 0) {
					break;
				} else if (a == (int) m) {
					if (sum == 0) {
						min = i;
					}
					sum += i;
				}
			}
		}
		if(sum == 0) {
			System.out.println(-1);
		}else {
		System.out.println(sum);
		System.out.println(min);
		}
	}
}
