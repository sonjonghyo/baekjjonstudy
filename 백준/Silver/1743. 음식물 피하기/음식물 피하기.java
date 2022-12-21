import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node { //음식물 쓰레기의 위치를 저장해줄 Node.
		int r,c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int passage[][]; //통로를 2차원 배열로 설정.
	static int N, M, K; //통로의 세로길이, 가로길이, 음식물쓰레기의 개수
	static boolean visited[][]; //방문처리배열
	static Queue<Node> foodWaste; //음식물 쓰레기를 담아줄 큐.
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static int sum, maxSum; //음식물쓰레기의 크기와 가장 큰 쓰레기의 크기.
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		passage = new int[N][M]; //통로 생성
		visited = new boolean[N][M]; //방문배열 생성.
		for(int i = 0; i < K; i++) { //음식물 쓰레기 위치지정.
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1; //-1해주는 이유는 배열의 위치는 0부터 시작하므로.
			int b = Integer.parseInt(st.nextToken()) - 1;
			passage[a][b] = 1;
		}
		foodWaste = new LinkedList<>(); //큐 생성
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && passage[i][j] == 1) { //방문하지 않았고, 음식물 쓰레기가 있다면?
					sum = 1;
					checkSize(i,j); //음식물 쓰레기의 크기를 측정해주러 가기.
				}
				if(maxSum < sum) //만약 가장 큰것보다 방금구한 것이 더 크다면
					maxSum = sum; //가장 큰것을 새로운 것으로 갱신해줍니다.
			}
		}
		System.out.println(maxSum);
		
	}
	private static void checkSize(int r, int c) {
		foodWaste.add(new Node(r, c)); //큐에 담아줍니다.
		visited[r][c] = true; //큐에 담을때 방문처리 체크해주고
		while(!foodWaste.isEmpty()) { //큐가 비어있지 않을때 까지 while문 돌리기.
			Node n = foodWaste.poll();
			for(int d = 0; d < 4; d++) { //주위 사방탐색 진행
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				if(outOfRange(nr, nc)) { //범위 이내인지 체크해줍니다.
					if(!visited[nr][nc] && passage[nr][nc] == 1) { //방문하지 않았으며 음식물 쓰레기가 있는 공간이라면?
						foodWaste.add(new Node(nr,nc)); //음식물쓰레기 큐에 담아주고.
						visited[nr][nc] = true; //방문처리를 해준다음에
						sum++; //음식물 쓰레기의 크기를 증가시켜줍니다.
					}
				}
			}
		
		}
		
	}
	
	private static boolean outOfRange(int nr, int nc) { //범위 이내인지 확인해주는 함수.
		return (nr >= 0 && nr < N && nc >= 0 && nc < M);
	}
}