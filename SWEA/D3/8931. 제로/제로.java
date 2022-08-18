import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int a = 1; a <= TC; a++) {
			Stack<Integer> s = new Stack<>();
			int sum = 0;
			int K = sc.nextInt();
			for (int i = 0; i < K; i++) {
				int num = sc.nextInt();
				if (num != 0) {
					s.push(num);
				} else {
					s.pop();
				}
			}
			for(int x = 0; x<s.size(); x++) {
				sum += s.get(x);
			}
			System.out.println("#" + a + " " + sum);
		}
	}
}