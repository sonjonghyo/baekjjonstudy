import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		int answer = Integer.MIN_VALUE; //광장의 아름다움이 0보다 작을 수 있으니 처음 초기값을 가장 작은값으로.
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int row[] = new int[N];
		int col[] = new int[M];

		for(int i = 0; i < N; i++) { //가로에 대한 누적합
			for(int j = 0; j < M; j++) {
				row[i] +=  map[i][j];
			}
		}
		for(int i = 0; i < M; i++) { //세로에 대한 누적합
			for(int j = 0; j < N; j++) {
				col[i] += map[j][i];
			}
		}
		for(int i = 0; i < N; i++) { //가로
			for(int j = 0; j < M; j++) { //세로
				for(int k = i + 1; k < N; k++) { //가로
					for(int l = j + 1; l < M; l++) { //세로
						//가로세로줄 누적합 되어있는거 우선 전부 더해주고?
						//겹치는거 빼주자.
						//마지막으로 길 4개에 둘러싸인 녹지의 개수를 더해주어야함.
						int tmp = row[i] + col[j] + row[k] + col[l] - map[i][j] - map[i][l] - map[k][j] - map[k][l] + (k-i-1) * (l-j-1);
						answer = Math.max(answer, tmp);
					}
				}
			}
		}
		System.out.println(answer);
	}
}