import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int r,c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int map[][]; //편의점 좌표를 저장해줌.
	static int n;
	static Node festival; //축제 도착지점을 저장 해줄 배열.
	static boolean visited[];
	static Queue<Node> location;
	public static void main(String[] args) throws Exception {
		//값에 32768을 더해주는 이유는 음수를 없애기 위해서.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); //테스트 케이스의 개수
		for(int tc = 1; tc <= T; tc++) { //테스트 케이스 만큼 반복합니다.
			n = Integer.parseInt(br.readLine()); //맥주를 파는 편의점의 개수
			visited = new boolean[n+2];
			location = new LinkedList<>();
			map = new int[n+2][2]; //편의점 위치를 저장해줄 배열을 생성해줍니다.
			st = new StringTokenizer(br.readLine());
			map[0][0] = Integer.parseInt(st.nextToken()) + 32768; //집의 x좌표
			map[0][1] = Integer.parseInt(st.nextToken()) + 32768; //집의 y좌표
			for(int i = 1 ; i < n+1 ; i++) {
				st = new StringTokenizer(br.readLine());
				map[i][0] = Integer.parseInt(st.nextToken()) + 32768; //편의점의 x좌표
				map[i][1] = Integer.parseInt(st.nextToken()) + 32768; //편의점의 y좌표
			}
			st = new StringTokenizer(br.readLine());
			map[n+1][0] = Integer.parseInt(st.nextToken()) + 32768; //마지막 페스티벌 장소
			map[n+1][1] = Integer.parseInt(st.nextToken()) + 32768; //마지막 페스티벌 장소
			
			boolean flag = go(map[0][0],map[0][1]); //이제 맥주를 들고 걸어가기.
			if(flag) {
				sb.append("happy");
			}else {
				sb.append("sad");
			}
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
	}
	private static boolean go(int x, int y) {
		location.add(new Node(x ,y));
		visited[0] = true;
		while(!location.isEmpty()) {
			Node no = location.poll();
			if(Math.abs(no.r - map[n+1][0]) + Math.abs(no.c - map[n+1][1]) <= 1000) {
				if(Math.abs(no.r - map[n+1][0]) <= 1000 && Math.abs(no.c - map[n+1][1]) <= 1000) //마지막 도착지에 갈수있는 상황이라면?
					return true; //함수를 true로 끝내줍니다.				
			}
			for(int i = 1; i < n+1 ; i++) {
				//두개의 합이 현재 sum의 1000 이내에 있다면 담아주고 방문처리.
				if(!visited[i]) {
					if(Math.abs(no.r - map[i][0]) + Math.abs(no.c - map[i][1]) <= 1000) { //거리 1000 이내라면?
						//이전것과 거리가 1000 이내인지도 확인.
						if(Math.abs(no.r - map[i][0]) <= 1000 && Math.abs(no.c - map[i][1]) <= 1000) {
							location.add(new Node(map[i][0],map[i][1]));
							visited[i] = true;	
						}
					}
				}
			}
		}
		return false;
	}
}