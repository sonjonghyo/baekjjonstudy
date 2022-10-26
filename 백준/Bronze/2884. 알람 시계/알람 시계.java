import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int h = sc.nextInt();
		int m = sc.nextInt();
		m = m-45;
		if(m<0) {
			m += 60;
			if(h>0) {
				h -= 1;
			}else {
				h = 23;
			}
		}
		sb.append(h).append(" ").append(m);
		System.out.println(sb);
		sc.close();
	}
}