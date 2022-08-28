import java.util.Arrays;
import java.util.Scanner;
public class Solution {
	static StringBuilder sb = new StringBuilder();
	static char[][] arr = new char[8][8]; //회문이 놓일 판
	static char r[];
	static char d[];
	static int cnt; //회문의 개수 알려주는 것.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 1; tc<=10; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = sc.nextInt();
			for(int i = 0; i<8; i++) {
				String s = sc.next();
				for(int j = 0; j<8; j++) {
					arr[i][j] = s.charAt(j);
				}
			}
			cnt = 0;
			right(N);
			down(N);
			sb.append(cnt);
			if(tc!=10)
				sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
	public static void right(int N) {
		for(int i = 0; i<8; i++) { //열은 전부 확인
			for(int j = 0; j<8-N+1; j++) { //행은 첫번째부터 N+1구간까지만 확인해도됌.
				r = new char[N];
				char revr[] = new char[N];
				for(int x = 0; x<N; x++) { //N개를 넣어주기 위해 N개까지. for문 (3중for문맞나..)
					r[x]=arr[i][x+j];
					revr[x] = arr[i][N-1-x+j];
				}
				if(Arrays.equals(r, revr)) {
					cnt++;
				}else {
					continue;
				}
			}
		}
	}
	public static void down(int N) {
		for(int i = 0; i<8; i++) { //행은 전부 확인
			for(int j = 0; j<8-N+1; j++) { //행은 첫번째부터 N+1구간까지만 확인해도됌.
				d = new char[N];
				char revd[] = new char[N];
				for(int x = 0; x<N; x++) { //N개를 넣어주기 위해 N개까지. for문 (3중for문맞나..)
					r[x]=arr[x+j][i];
					revd[x] = arr[N-1-x+j][i];
				}
				if(Arrays.equals(r, revd)) {
					cnt++;
				}else {
					continue;
				}
			}
		}
	}
}