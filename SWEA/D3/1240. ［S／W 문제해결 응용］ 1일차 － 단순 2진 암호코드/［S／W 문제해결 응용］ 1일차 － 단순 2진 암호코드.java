import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			int M = sc.nextInt();
			char arr[][] = new char[N][M];
			int result[] = new int[8];
			for(int i = 0; i<N; i++) {
				String a = sc.next();
				for(int j = 0; j<M; j++) {
					arr[i][j] = a.charAt(j);
				}
			}
			int idx = 0;
			boolean flag;
			int startj = 0;
			for(int i = 0; i<N; i++) {
				if(idx==8)
					break;
				String s = "";
				flag = true;
				for(int j = 0; j<M-7; j++) {
					if(idx==8) {
						flag = true;
					}
					s = "";
					for(int k = 0; k<7; k++) {
						s += arr[i][j+k]; 
					}
					switch(s) {
					case "0001101" : 
						result[idx++] = 0;
						
						if(idx==1) 
							startj = j;
						
						j += 6;
						flag = false;
						break;
					case "0011001" :
						result[idx++] = 1;
						
						if(idx==1) 
							startj = j;
						
						j += 6;
						flag = false;
						break;
					case "0010011" :
						result[idx++] = 2;
						
						if(idx==1) 
							startj = j;
						
						j += 6;
						flag = false;
						break;
					case "0111101" :
						result[idx++] = 3;
						
						if(idx==1) 
							startj = j;
						
						j += 6;
						flag = false;
						break;
					case "0100011" :
						result[idx++] = 4;
						
						if(idx==1) 
							startj = j;
						
						j += 6;
						flag = false;
						break;
					case "0110001" :
						result[idx++] = 5;
						
						if(idx==1) 
							startj = j;
						
						j += 6;
						flag = false;
						break;
					case "0101111" :
						result[idx++] = 6;
						
						if(idx==1) 
							startj = j;
						
						j += 6;
						flag = false;
						break;
					case "0111011" :
						result[idx++] = 7;
						
						if(idx==1) 
							startj = j;
						
						j += 6;
						flag = false;
						break;
					case "0110111" :
						result[idx++] = 8;
						
						if(idx==1) 
							startj = j;
						
						j += 6;
						flag = false;
						break;
					case "0001011" :
						result[idx++] = 9;
						
						if(idx==1) 
							startj = j;
						
						j += 6;
						flag = false;
						break;
					default : //이외의 상황. 0000000
						if(!flag) {
							j = startj+1;
							idx = 0;
						}
						break;			
					}
				}
			}
			int sum = 0;
			int check = 0;
			for(int i = 0; i<8; i++) {
				sum += result[i];
				if(i%2==0) {
					check += (result[i]*3);
				}else {
					check += result[i];
				}
			}
			if(check%10==0) {
				sb.append(sum);
			}else {
				sb.append(0);
			}
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}