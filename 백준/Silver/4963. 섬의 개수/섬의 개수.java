import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int W;
	static int H;
	static int sum[][];
	static int[] dx = {0, 0, 1, -1, -1, 1, -1, 1};
	static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1}; //아래, 위, 오른쪽, 왼쪽, 왼쪽위, 오른쪽아래, 왼쪽아래, 오른쪽위 순서.
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			result = 0; //섬의 개수 초기화.
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(W == 0 && H == 0)
				break;
			
			sum = new int[H][W];
			for(int i = 0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<W; j++) {
					sum[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i<H; i++) {
				for(int j = 0; j<W; j++) {
					if(sum[i][j]==1) { 
						howsum(i,j); //섬이 어떻게있는지 확인해주러감.
						result++; //섬의 개수증가(어떻게가든 1개만 증가시키므로)
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
	public static void howsum(int i, int j) { //8방탐색함.
		sum[i][j] = 0; //이 구간은 섬을 봤으니 0으로 바꾸어준다.
		
		for(int s = 0; s<8; s++) {
			int nx = i + dx[s];
			int ny = j + dy[s];
			
			if(nx<0 || ny<0 || nx >=H || ny>=W) { //만약 위의 값이 범위안이라면?
				continue;
			}
			if(sum[nx][ny] == 1) //주변에 아직 확인안한섬이있다면?
				howsum(nx,ny); //그쪽 섬으로 진출해서 다시 탐색.
				
		}
	}	
}