import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		
		int xmax = 0, ymax = 0; //가로 세로의 최대 길이 저장.
		int xmaxidx = -1, ymaxidx = -1;  //가로 세로의 최대길이 인덱스 저장.
		
		int dir[] = new int[6]; //방향 순서 저장
		int dist[] = new int[6]; //각 변의 길이 저장.
		
		for(int i = 0; i<6; i++) {
			st = new StringTokenizer(br.readLine());
			dir[i] = Integer.parseInt(st.nextToken());
			dist[i] = Integer.parseInt(st.nextToken());
			if(dir[i] == 1 | dir[i] == 2) { //동서쪽 이라면 (가로방향이라면)
				if(xmax < dist[i]) { //가로변수의 최대값. 인덱스 저장.
					xmax = dist[i];
					xmaxidx = i;
				}
			}else { //남은 3,4 북쪽남쪽이라면 (세로방향이라면)
				if(ymax < dist[i]) {
					ymax = dist[i];
					ymaxidx = i;
				}
			}
		}
		int maxS = xmax * ymax; //가장 큰 사각형 구하기.
		int minS = dist[(xmaxidx +3) % 6] * dist[(ymaxidx +3) % 6]; //(xmaxidx+3)%6  (ymaxidx+3)%6 은 최대값 이후 중간값이나오는 위치이다.
		System.out.println((maxS-minS) * K);
	}
}