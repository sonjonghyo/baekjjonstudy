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
    static int map[][];
    static boolean visited[][];
    static int dr[] = {-1,1,0,0};
    static int dc[] = {0,0,-1,1};
    static Queue<Node> vegetable;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int answer = 0;
            vegetable = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[b][a] = 1;
            }
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {
                        visited[i][j] = true;
                        vegetable.add(new Node(i,j));
                        warm(N,M);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
    private static void warm(int N, int M) {
        while(!vegetable.isEmpty()) {
            Node n = vegetable.poll();
            for(int d = 0; d < 4; d++) {
                int nr = n.r + dr[d];
                int nc = n.c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;
                if(!visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    vegetable.add(new Node(nr,nc));
                }
            }
        }
    }
}