import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			System.out.print("#" + tc + " ");
			int arrS[] = new int[13];
			int arrD[] = new int[13];
			int arrH[] = new int[13];
			int arrC[] = new int[13];
			int scnt = 0;
			int dcnt = 0;
			int hcnt = 0;
			int ccnt = 0;
			String s = sc.next();
			int num = 0;
			char a = '0';
			boolean flag = false;
			loop:
			for(int i = 0; i < s.length(); i++) {
				if(i%3==0) {
					a = s.charAt(i);
				} else if(i%3==1) {
					num = s.charAt(i)-'0';
					num *= 10;
				} else if(i%3==2) {
					num += s.charAt(i)-'0';
					switch(a) {
					case 'S':
						if(arrS[num-1]!=0) {
							System.out.print("ERROR");
							flag = true;
							break loop;
						}else {
							arrS[num-1]++;
							scnt++;
						}
						break;
					case 'D':
						if(arrD[num-1]!=0) {
							System.out.print("ERROR");
							flag = true;
							break loop;
						}else {
							arrD[num-1]++;
							dcnt++;
						}
						break;
					case 'H':
						if(arrH[num-1]!=0) {
							System.out.print("ERROR");
							flag = true;
							break loop;
						}else {
							arrH[num-1]++;	
							hcnt++;
						}
						break;
					case 'C':
						if(arrC[num-1]!=0) {
							System.out.print("ERROR");
							flag = true;
							break loop;
						}else {
							arrC[num-1]++;
							ccnt++;
						}
						break;
					}
				}
			}
			if(!flag) {
				scnt = 13-scnt;
				dcnt = 13-dcnt;
				hcnt = 13-hcnt;
				ccnt = 13-ccnt;
				System.out.print(scnt + " " + dcnt + " " + hcnt + " " + ccnt);
			}
			if(tc!=T)
				System.out.println();
		}
		sc.close();
	}
}