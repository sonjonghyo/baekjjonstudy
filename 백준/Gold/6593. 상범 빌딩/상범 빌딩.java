import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int l, r, c;
    static char[][][] building;
    //동서남북상하
    //동서남북은 층 안바뀌고, 상하만 층이 바뀜.
    static int moveX[] = {0,0,0,0,1,-1};
    static int moveR[] = {0,0,1,-1,0,0};
    static int moveC[] = {1,-1,0,0,0,0};
    static boolean visited[][][];
    static class Node{
        int x;
        int y;
        int z;
        int canEscape;
        Node(int x, int y, int z, int canEscape){
        	//이 부분 반대로 쓰셨고 z y z로 되어있네요~
//            z = this.x;
//            y = this.y;
//            z = this.z;
//        	canEscape = this.canEscape;
        	this.x = x;
        	this.y = y;
        	this.z = z;
        	this.canEscape = canEscape;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            Queue<Node> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(l==0&&r==0&&c==0) {
                break;
            }

            building = new char[l][r][c];
            visited = new boolean[l][r][c];
            for(int i=0;i<l;i++) {
                for(int j=0;j<r+1;j++) {
                    String s = br.readLine();
                    if(s.equals("")) {
                        continue;
                    }
                    building[i][j]=s.toCharArray();
                }
            }


            for(int i=0;i<l;i++) {
                for(int j=0;j<r;j++) {
                    for(int k=0;k<c;k++) {
                        if(building[i][j][k]=='S') {
                        visited[i][j][k] = true; //넣을때 true로 바꾸어주자.
                            queue.add(new Node(i,j,k,0));
                            
                        }
                    }
                }
            }
            
            boolean check = false;
            while(!queue.isEmpty()) {
                Node n = queue.poll();
            //    visited[n.x][n.y][n.z] = true; //이미 넣으면서 true로 바꾸어 주는데 또 true로 해줄필요는 없다.

                if(building[n.x][n.y][n.z]=='E') { //이 부분에서 E로 못가는 경우를 생각해주어야합니다.
                    if(n.canEscape>0) {
                    	check = true;
                        System.out.println("Escaped in "+n.canEscape+" minute(s).");
                        break;
                    }
                }

                for(int i=0;i<6;i++) {
                    int newL = n.x + moveX[i];
                    int newR = n.y + moveR[i];
                    int newC = n.z + moveC[i];

                    if(newL<0 || newL>=l || newR<0 || newR>=r || newC<0 || newC>=c) {
                        continue;
                    }

                    if(building[newL][newR][newC]=='#') {
                        continue;
                    }

                    if(visited[newL][newR][newC]) {
                        continue;
                    }

                    if(building[newL][newR][newC]=='.'||building[newL][newR][newC]=='E') {
                        visited[newL][newR][newC] = true;
                        queue.add(new Node(newL, newR, newC, n.canEscape+1));
                    }
                }
            }
            if(!check) { //만약 도착지에 도달하지 못했다면? 이 추가가 되어야해
            	System.out.println("Trapped!");
            }
        }
    }
}