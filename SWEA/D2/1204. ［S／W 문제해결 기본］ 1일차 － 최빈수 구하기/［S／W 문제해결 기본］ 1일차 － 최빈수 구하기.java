import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
		for(int i = 1; i<=T; i++) {
			int t = sc.nextInt();
			int max = 0;
			int bin = 0;
			int arr[] = new int[101];
			for(int x = 0; x<1000; x++) {
				int score = sc.nextInt();
				arr[score]++;
			}
			for(int x = 0; x<=100; x++) {
				if(arr[x]>=max) {
					max = arr[x];
					bin = x;
				}
			}
			System.out.println("#"+t+" "+bin);
		}
	}
}