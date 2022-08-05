import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<T; i++) {
			int N = sc.nextInt();
			min = (N < min ? N : min);
			max = (N > max ? N : max);
		}
		System.out.println(min*max);
		sc.close();
	}
}
