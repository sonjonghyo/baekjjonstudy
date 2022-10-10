import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			double D = sc.nextDouble(); //용사가 입힌 데미지
			double L = sc.nextDouble(); //데미지 %로 나누는 것.
			double N = sc.nextDouble(); //때린 횟수
			double attack = 0;
			attack = D;
			int sum = 0;
			for(int i = 0; i<N; i++) {
				attack = D + ((D*i*L)/100);
				sum += attack;
			}
			sb.append(sum);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}