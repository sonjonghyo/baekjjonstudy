import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,r,c;
	static int map[][]; //지도.
	static int dice[] = {0,0,0,0,0,0}; //주사위 표현. 0~5까지(윗면,왼쪽면, 오른쪽면, 앞면, 뒷면, 밑면).
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //세로의 크기
		M = Integer.parseInt(st.nextToken()); //가로의 크기
		r = Integer.parseInt(st.nextToken()); //주사위를 놓은 곳의 x좌표
		c = Integer.parseInt(st.nextToken()); //주사위를 놓은 곳의 y좌표
		int K = Integer.parseInt(st.nextToken()); //명령의 개수
		map = new int[N][M]; //지도의 크기는 NxM
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); //맵에 쓰여져 있는 숫자들 쓰기.
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<K; i++) { //명령횟수 만큼 반복.
			int command = Integer.parseInt(st.nextToken());
			switch(command) {
			case 1:
				rotate1(); //동쪽으로 갈때
				break;
			case 2:
				rotate2(); //서쪽으로 갈때
				break;
			case 3:
				rotate3(); //북쪽으로 갈때
				break;
			case 4:
				rotate4(); //남쪽으로 갈때
				break;
			default:
				break;
			}	
		}
		System.out.println(sb);
	}
	private static void rotate1() { //동쪽으로 굴렸을때
		c += 1; //동쪽이니 오른쪽으로 한칸.
		if(in(r,c)) { //맵 내부라면?
			//오른쪽 왼쪽으로 굴리니 앞뒤면은 그대로임.
			int up = dice[1]; //윗면에는 전의 왼쪽면이
			int left = dice[5]; //왼쪽면에는 전의 밑면이
			int right = dice[0]; //오른쪽면에는 전의 윗면이.
			int down = dice[2]; //밑면에는 전의 오른쪽면이
			
			dice[0] = up;
			dice[1] = left;
			dice[2] = right;
			dice[5] = down;
			
			if(map[r][c]==0) { //이동한 부분의 지도에 쓰여 있는수가 0이라면
				map[r][c] = dice[5]; //주사위 밑면에 쓰여있는것이 맵에 복사가됌.
				
			}else { //이동한 부분의 지도에 쓰여있는수가 0이 아니라면?
				dice[5] = map[r][c]; //칸에 쓰여있는수가 주사위에 복사가됌.
				map[r][c] = 0; //그러고 지도에 쓰여있는 수는 0으로 바뀜.
			}
			sb.append(dice[0]); //윗면에 있는 수 저장.
			sb.append("\n"); //개행문자 추가.
		}else { //맵 밖으로 갔다면
			c -= 1; //원래대로 돌려놓기.
			return;
		}
	}
	private static void rotate2() { //서쪽으로 굴렸을때
		c -= 1; //서쪽이니 왼쪽으로 한칸.
		if(in(r,c)) { //맵 내부라면?
			//오른쪽 왼쪽으로 굴리니 앞뒤면은 그대로임.
			int up = dice[2]; //윗면에는 전의 오른쪽면이
			int left = dice[0]; //왼쪽면에는 전의 윗면이
			int right = dice[5]; //오른쪽면에는 전의 밑면이.
			int down = dice[1]; //밑면에는 전의 왼쪽쪽면이
			
			dice[0] = up;
			dice[1] = left;
			dice[2] = right;
			dice[5] = down;
			
			if(map[r][c]==0) { //이동한 부분의 지도에 쓰여 있는수가 0이라면
				map[r][c] = dice[5]; //주사위 밑면에 쓰여있는것이 맵에 복사가됌.
				
			}else { //이동한 부분의 지도에 쓰여있는수가 0이 아니라면?
				dice[5] = map[r][c]; //칸에 쓰여있는수가 주사위에 복사가됌.
				map[r][c] = 0; //그러고 지도에 쓰여있는 수는 0으로 바뀜.
			}
			sb.append(dice[0]); //윗면에 있는 수 저장.
			sb.append("\n"); //개행문자 추가.
		}else { //맵 밖으로 갔다면
			c += 1; //원래대로 돌려놓기.
			return;
		}
		
	}
	private static void rotate3() { //북쪽으로 굴렸을때
		r -= 1; //북쪽이니 위로 한칸.
		if(in(r,c)) { //맵 내부에서 동작하는지 확인.
			int up = dice[3]; //윗면에는 전에 앞면이.
			int front = dice[5]; //앞면에는 전의 밑면이
			int back = dice[0]; //뒷면에는 전의 윗면이
			int down = dice[4]; //밑면에는 전의 뒷면이
			
			dice[0] = up;
			dice[3] = front;
			dice[4] = back;
			dice[5] = down;
			if(map[r][c]==0) { //이동한 부분의 지도에 쓰여 있는수가 0이라면
				map[r][c] = dice[5]; //주사위 밑면에 쓰여있는것이 맵에 복사가됌.
				
			}else { //이동한 부분의 지도에 쓰여있는수가 0이 아니라면?
				dice[5] = map[r][c]; //칸에 쓰여있는수가 주사위에 복사가됌.
				map[r][c] = 0; //그러고 지도에 쓰여있는 수는 0으로 바뀜.
			}
			sb.append(dice[0]); //윗면에 있는 수 저장.
			sb.append("\n"); //개행문자 추가.
		}else { //동작 안한다면?
			r += 1; //원래대로 복구후
			return; //함수 끝내줌.
		}
		
	}
	private static void rotate4() { //남쪽으로 굴렸을때.
		r += 1; //남쪽이니 밑으로 한칸.
		if(in(r,c)) { //맵 내부에서 동작한다면?
			//일단 주사위 전부 옮겨야함.
			//남쪽으로 가니 위,아래,앞,뒤만 옮기면 됌.
			int up = dice[4]; //윗면에는 전에 뒷면이.
			int front = dice[0]; //앞면에는 전의 윗면이
			int back = dice[5]; //뒷면에는 전의 밑면이
			int down = dice[3]; //밑면에는 전의 앞면이
			
			dice[0] = up;
			dice[3] = front;
			dice[4] = back;
			dice[5] = down;
			if(map[r][c]==0) { //이동한 부분의 지도에 쓰여 있는수가 0이라면
				map[r][c] = dice[5]; //주사위 밑면에 쓰여있는것이 맵에 복사가됌.
				
			}else { //이동한 부분의 지도에 쓰여있는수가 0이 아니라면?
				dice[5] = map[r][c]; //칸에 쓰여있는수가 주사위에 복사가됌.
				map[r][c] = 0; //그러고 지도에 쓰여있는 수는 0으로 바뀜.
			}
			sb.append(dice[0]); //윗면에 있는 수 저장.
			sb.append("\n"); //개행문자 추가.
		}else { //범위 밖이라면 이동하면 안되므로 원래대로 돌려놓고
			r-=1; 
			return; //남쪽으로 굴리는 함수를 끝내준다.
		}
			
	}
	
	private static boolean in(int r, int c) {
		return (r >= 0 && r < N && c >= 0 && c < M);
	}
}