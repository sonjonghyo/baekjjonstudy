import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int F = sc.nextInt();
		int qoc = 1;
		int cnt = 0;
		N = N/100; //N에 100을 나누어 주어 맨끝 두자리를 00으로 만들기 위함.
		N = N*100;
		while(true) {
			qoc = N%F;
			if(qoc==0)
				break;
			N++;
			cnt++;
		}
		if(cnt<10)
			System.out.println("0"+cnt);
		else
			System.out.println(cnt);
		sc.close();
	}
}
