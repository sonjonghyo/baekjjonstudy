import java.io.*;
import java.util.*;

public class Main {
	//상하좌우 돌아다니기 위해 필요한 drc 배열
	static int drc[][] = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char map[][] = new char[R][C];
		int answer = 0;
		//마을을 넣어줍니다.
		for(int i = 0; i < R; i++) {
			String S = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = S.charAt(j);
			}
		}
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				int cnt = 0;
				if(map[i][j] == '.') {
					for(int d= 0 ; d < 4; d++) {
						int nr = i + drc[d][0];
						int nc = j + drc[d][1];
						if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
							if(map[nr][nc] =='X')
								cnt++;
						}else {
							cnt++;
						}
					}
				}
				if(cnt >= 3) {
					answer = 1;
					break;
				}						
			}			
		}
		System.out.println(answer);
	}
}