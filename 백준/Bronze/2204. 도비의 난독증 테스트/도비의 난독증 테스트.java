import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int N = sc.nextInt();
			if(N==0)
				break;
			String arr[] = new String[N];
			String arr2[] = new String[N];
			double sum[] = new double[N];
			double min = Double.MAX_VALUE;
			int first = 0;
			for(int i = 0; i<N; i++) {
				arr[i] = sc.next();
				for(int j = 0; j<arr[i].length(); j++) {
					arr2[i]=arr[i].toUpperCase();
					if(j==0) {
						sum[i] += arr2[i].charAt(j);
					}else {
						sum[i] += (arr2[i].charAt(j)*(j*0.01));
					}
					
				}
				if(min>sum[i]) {
					min = sum[i];
					first = i;
				}
			}
			System.out.println(arr[first]);
		}
	}
}