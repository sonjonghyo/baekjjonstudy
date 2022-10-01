import java.util.Scanner;

public class Solution {
	//5가지 문자열 생성해서
	//맨첫줄~마지막줄 입력넣기.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			String s1 = "";
			String s2 = "";
			String s3 = "";
			String s4 = "";
			String s5 = "";
			String s = sc.next();
			for(int i = 0; i<s.length(); i++) {
				if(i==0) {
					s1 += "..#..";
					s2 += ".#.#.";
					s3 += "#." + s.charAt(i) + ".#";
					s4 += ".#.#.";
					s5 += "..#..";
				} else {
					s1 += ".#..";
					s2 += "#.#.";
					s3 += "." + s.charAt(i) + ".#";
					s4 += "#.#.";
					s5 += ".#..";
				}
			}
			sb.append(s1).append("\n").append(s2).append("\n").append(s3).append("\n").append(s4).append("\n").append(s5);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}