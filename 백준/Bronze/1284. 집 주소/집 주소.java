import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 0;
		int sum = 0;
		int idx = 0;
		String arr[] = new String[100];
		do {
		N = sc.nextInt();
		int n = N;
		int count = 1;
		sum = 0;
		while (n != 0) {
			int qoc = 0;
			qoc = n % 10;
			n /= 10;
			switch (qoc) {
			case 1:
				count++;
				sum += 2;
				break;
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				count++;
				sum += 3;
				break;
			case 0:
				count++;
				sum += 4;
				break;
			default:
			}
		}
		if(N!=0) {
		sum += count;
		String strsum1 = String.valueOf(sum);
		arr[idx] = strsum1;
		idx++;
		}
		}while(N!=0);
		for(int i = 0; i<idx; i++) {
			System.out.println(arr[i]);			
		}
	}
}