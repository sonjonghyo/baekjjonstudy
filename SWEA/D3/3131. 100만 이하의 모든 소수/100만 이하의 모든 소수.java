import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		int arr[] = new int[1000001];
		Arrays.fill(arr, 1);
		for(int i = 2; i<=Math.sqrt(arr.length); i++) {
			for(int j = i+i; j<=1000000; j+=i) {
				arr[j] = 0;
			}
		}
		for(int i = 2; i<=1000000; i++) {
			if(arr[i]!=0) {
				if(i==2) {
					System.out.print(i);;
				}else {
					System.out.print(" "+ i);;
				}
			}
		}
	}
}