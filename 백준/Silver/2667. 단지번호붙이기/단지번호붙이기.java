import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	static int N;
	static String map[][];
	static List<Integer> count = new ArrayList<>(); //단지를 저장해줄것임.
	static int cnt; //단지마다 스티커의 개수.
	static boolean visited[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new String[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i<N; i++) {
			String s[] = br.readLine().split("");
			for(int j = 0; j<N; j++) {
				map[i][j] = s[j];
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!map[i][j].equals("0") && !visited[i][j]) { 
					cnt = 0;
					putnum(i,j); //한번 다 끝나면
					count.add(cnt); //개수를 추가해줌.
				}
			}
		}
		sb.append(count.size()).append("\n");
		int arr[] = new int[count.size()];
		for(int i = 0; i<count.size(); i++) {
			arr[i] = count.get(i);
		}
		Arrays.sort(arr); //오름차순으로 정렬
		for(int i = 0; i<count.size(); i++) {
			sb.append(arr[i]);
			if(i!=count.size()-1)
				sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void putnum(int x, int y) {
		visited[x][y] = true; //방문했으니까 true로 만들어준다.
		cnt++; //나도 포함시켜야하므로 cnt를 1 추가시킴.
		for(int i = 0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || ny<0 || nx>=N || ny>=N) //만약 범위 밖이라면 다음수.
				continue;
			if(!visited[nx][ny]&&map[nx][ny].equals("1")) //만약 그 구간이 1이고 아직 방문을 안했다면.
				putnum(nx,ny); //그곳으로 가서 다시 4방탐색
		}
		
	}
}