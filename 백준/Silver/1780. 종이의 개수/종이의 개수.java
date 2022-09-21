import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int paper[][];
	static int mone;
	static int zero;
	static int one;
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
		System.out.println(mone);
		System.out.println(zero);
		System.out.println(one);
		
	}
	static void divide(int x, int y, int n) { //왼쪽, 오른쪽, 색종이의 크기 받아오기
		if(n==1) { //만약 색종이가 0,1,-1에 따라 달라짐.
			if(paper[x][y]==1) one++;
			else if(paper[x][y]==0) zero++;
			else if(paper[x][y]==-1) mone++;
			return;
		}
		int zc = 0;
		int mc = 0;
		int oc = 0;
		for(int i=x;i<x+n;i++) { //x부터 x+색종이의크기n개까지 오른쪽으로 감.
			for(int j=y;j<y+n;j++) { //y부터 y+색종이의 크기n개까지 내려감
				if(paper[i][j]==0) //각 개수를 계산함.
					zc++;
				else if(paper[i][j]==1)
					oc++;
				else if(paper[i][j]==-1)
					mc++;
			}
		}
		if(zc==n*n) //zc(0), mc(-1), oc(1)이 n*n의 개수라면 해당하는 수에 ++를 해준다.
			zero++; 
		else if(mc==n*n) 
			mone++; 
		else if(oc==n*n)
			one++;
		else { //그 외는 아직 분할할 것이 남은것이므로 다시 잘라줌.
			
			divide(x, y, n/3); 
			divide(x+n/3, y, n/3); 
			divide(x+(2*n/3), y, n/3); 
			
			divide(x, y+n/3, n/3); 
			divide(x+n/3, y+n/3, n/3); 
			divide(x+(2*n/3), y+n/3, n/3); 
			
			divide(x, y+(2*n/3), n/3); 
			divide(x+n/3, y+(2*n/3), n/3); 
			divide(x+(2*n/3), y+(2*n/3), n/3); 
			
		}
	}
}