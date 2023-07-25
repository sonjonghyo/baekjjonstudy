import java.io.*;
import java.util.*;

public class Main {
	static int answer[];
	static int ans = 0;
	static int tmp[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		answer = new int[10];
		tmp = new int[10];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 10; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
		}
		check(0);
		System.out.println(ans);
		
	}
	static void check(int depth) {
		if(depth == 10) {
			int cnt = 0;
			for(int i = 0; i<10; i++) {
				if(answer[i] == tmp[i]) {
					cnt++;
				}
			}
			if(cnt >= 5) {
				ans++;				
			}
			return;
		}
		for(int i = 1; i <=5; i++) {
			if(depth >= 2) {
				if(tmp[depth - 1] == i && tmp[depth-2] == i)
					continue;
			}
			tmp[depth] = i;
			check(depth+1);
		}
	}
}
