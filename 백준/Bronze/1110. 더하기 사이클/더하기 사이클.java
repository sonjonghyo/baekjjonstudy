import java.util.Scanner;
public class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int nb = N;
		int count = 0;
		do {
			int qoc = 0;
			int res = 0;
			int sum = 0;
			if(nb>=10) {
				qoc = nb/10;
				res = nb%10;
				sum = qoc+res;
				if(sum>=10)
					sum -= 10;
				nb = (res*10)+sum;
				count++;
			} else {
				sum = nb;
				nb = sum*10+sum;
				count++;
			}
		}while(nb!=N);
		System.out.println(count);
}
}