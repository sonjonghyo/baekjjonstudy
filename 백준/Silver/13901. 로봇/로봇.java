import java.util.*;
import java.io.*;

public class Main {
	static int R,C, K;
	static int map[][];
	static int robotx, roboty;
	static int sequence[] = new int[4]; //방향을 나타내줌. (상 = 1, 하 = 2, 좌 = 3, 우 = 4)
	static int dir = 0; //현재의 방향.(배열의 번호를 나타낸다.)
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); //방의 크기
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		map = new int[R][C];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1; //장애물인 구간은 1로 만들어서 못가게 만들어주자.
		}
		st = new StringTokenizer(br.readLine()); //현재 로봇의 위치
		robotx = Integer.parseInt(st.nextToken());
		roboty = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i ++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}
		go();
		System.out.println(robotx + " " + roboty);
	}
	private static void go() {
		int count = 0; //몇번 돌았는지 세줌.
		boolean flag = true;
		while(flag && count != 4) {
			switch(sequence[dir%4]) { //현재의 방향이 어디인지 파악
			case 1 : //상
				if(robotx - 1 >= 0 && map[robotx-1][roboty] == 0) { //위로 갈수 있는 경우엔? 
					map[robotx][roboty] = 1; //지나쳐 온 곳이므로 1로 바꿔준다.
					robotx--; //위칸으로 이동.
					flag = false;
				}else {
					count++;
					dir++;
				}
				break;
			case 2 : //하
				if(robotx + 1 < R && map[robotx+1][roboty] == 0) { //아래로 갈수 있는 경우엔? 
					map[robotx][roboty] = 1; //지나쳐 온 곳이므로 1로 바꿔준다.
					robotx++; //아래칸으로 이동.
					flag = false;
				}else {
					count++;
					dir++;
				}
				break;
			case 3 : //좌
				if(roboty - 1 >= 0 && map[robotx][roboty-1] == 0) { //좌로 갈수 있는 경우엔? 
					map[robotx][roboty] = 1; //지나쳐 온 곳이므로 1로 바꿔준다.
					roboty--; //왼쪽칸으로 이동.
					flag = false;
				}else {
					count++;
					dir++;
				}	
				break;
			case 4 : //우
				if(roboty + 1 < C && map[robotx][roboty+1] == 0) { //위로 갈수 있는 경우엔? 
					map[robotx][roboty] = 1; //지나쳐 온 곳이므로 1로 바꿔준다.
					roboty++; //오른쪽칸으로 이동.
					flag = false;
				}else {
					count++;
					dir++;
				}	
				break;
			}			
		}
		if(count == 4) {
			return;
		}else {
			go();
		}
	}
}