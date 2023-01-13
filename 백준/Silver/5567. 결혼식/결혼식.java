import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int invite[][];
	static int count;
	static Queue<Integer> marry;
	static boolean check[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine()); //상근이의 동기
		m = Integer.parseInt(br.readLine()); //리스트이 길이
		invite = new int[n+1][n+1];
		check = new boolean[n+1];
		marry = new LinkedList<>();
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			invite[a][b] = 1; //둘이 친구이므로 둘다 1로 만들어줍니다.
			invite[b][a] = 1;
		}
		check[1] = true;
		marry.add(1);
		findfriend();
		System.out.println(count);
	}
	private static void findfriend() {
		while(!marry.isEmpty()) { //큐가 비어있지않다면?
			int a = marry.poll();
			for(int i = 1; i <= n; i++) {
				if(!check[i] && invite[a][i] == 1) { //아직 방문하지 않았고 서로 친구사이라면?
					check[i] = true;
					count++;
					if(a==1) {
						marry.add(i);						
					}
				}
			}
		}
		
	}
}