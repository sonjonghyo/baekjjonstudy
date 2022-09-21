import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int paper[][];
	static int white;
	static int blue;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divide(0,0,N); //분할정복 시작
		System.out.println(white);
		System.out.println(blue);
	}
	static void divide(int x, int y, int n) { //왼쪽, 오른쪽, 색종이의 크기 받아오기
		if(n==1) { //만약 색종이의 크기가 1이라면 그안의 색에따라 결정.
			if(paper[x][y]==1) blue++;
			else if(paper[x][y]==0) white++;
			return;
		}
		int sum = 0;
		for(int i=x;i<x+n;i++) { //x부터 x+색종이의크기n개까지 오른쪽으로 감.
			for(int j=y;j<y+n;j++) { //y부터 y+색종이의 크기n개까지 내려감
				sum+=paper[i][j]; //색종이에 색칠되어있는것의 합을 구함.
			}
		}
		if(sum==n*n) //만약 색칠되어있는것이 색종이 크기의 제곱과 같다면. 즉 전부 칠해져있었다면
			blue++; //파란색을 하나 추가시켜주고
		else if(sum==0)  //하나도 안 칠해져있었다면
			white++; //흰색을 하나 추가시켜준다.
		else { //그 외는 아직 분할할 것이 남은것이므로 다시 +모양으로 잘라주고 색종이의 크기는 /2, 시작위치는 4번바뀐다.
			divide(x, y, n/2); //+ 로 보면 2사분면
			divide(x+n/2, y, n/2); //+로 보면 1사분면
			divide(x, y+n/2, n/2); //+로 보면 3사분면
			divide(x+n/2, y+n/2, n/2); //+로 보면 4사분면
		}
	}
}