import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		int map[][] = new int[6][2];
		int cnt[] = new int[5];
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			map[i][0] = dir;
			map[i][1] = value;
			cnt[dir]++;
		}
		int maxtri = 1;
		for(int i = 0; i < 6; i++) {
			if(cnt[map[i][0]] == 1) {
				maxtri *= map[i][1];
			}
		}
		
		int mintri = 1;
		for(int i = 0; i < 6; i++) {
			if(map[i][0] == map[(i+2)%6][0]) { 
				mintri *= map[(i+1)%6][1];
			}
		}
		
		System.out.println((maxtri - mintri) * K);		
	}
}