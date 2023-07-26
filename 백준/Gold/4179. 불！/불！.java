import java.util.*;
import java.io.*;
public class Main {
	static class Node {
		int r;
		int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};
	static Queue<Node> fire;
	static Queue<Node> jihoon;
	static char miro[][];
	static int r,c;
	static int answer = 0;
	static boolean flag;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		miro = new char[r][c];
		fire = new LinkedList<>();
		jihoon = new LinkedList<>();
		for(int i = 0; i < r; i++) {
			String s = br.readLine();
			for(int j = 0; j < c; j++) {
				miro[i][j] = s.charAt(j);
				if(s.charAt(j)== 'J') {
					jihoon.add(new Node(i,j));
				}else if(s.charAt(j) == 'F') {
					fire.add(new Node(i,j));
				}
			}
		}
		escape();
		if(flag) {
			System.out.println(answer);
		}else {
			System.out.println("IMPOSSIBLE");
		}
	}
	static void escape() {
		while(!jihoon.isEmpty()) {
			answer++;
			int fs = fire.size();
			while(fs > 0) {
				fs--;
				Node f = fire.poll();
				for(int d = 0; d < 4; d++) {
					int nr = f.r + dr[d];
					int nc = f.c + dc[d];
					if(boundary(nr, nc)) {
						if(miro[nr][nc] =='.' || miro[nr][nc] == 'J') {
							fire.add(new Node(nr,nc));
							miro[nr][nc] = 'F';
						}
					}
				}
			}
			int js = jihoon.size();
			while(js > 0) {
				js--;
				Node j = jihoon.poll();
				for(int d = 0; d < 4; d++) {
					int nr = j.r + dr[d];
					int nc = j.c + dc[d];
					if(boundary(nr, nc)) {
						if(miro[nr][nc] == '.') {
							jihoon.add(new Node(nr,nc));
							miro[nr][nc] = 'J';
						}
					}else {
						flag = true;
						return;
					}
				}	
			}
		}
	}
	static boolean boundary(int nr, int   nc) {
		if(nr >= 0 && nr < r && nc >= 0 && nc < c) {
			return true;
		}else {
			return false;
		}
	}
}
