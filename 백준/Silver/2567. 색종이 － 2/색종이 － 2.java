import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int arr[][] = new int[102][102];
		int N = Integer.parseInt(br.readLine());
		int x,y = 0;
		int sum = 0;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			for(int j = x; j<x+10; j++) {
				for(int k = y; k<y+10; k++) {
					if(arr[j][k]==1) {
						continue;
					}
					arr[j][k] = 1;
				}
			}
		}
		
		for(int i =0; i<arr.length; i++) {
			for(int j =0; j<arr[i].length; j++) {
				if(i>0 && j>0) {
				if(arr[i][j]==1) {
					if(arr[i-1][j] == 0) //상
						sum++;
					if(arr[i+1][j] == 0) //하
						sum++;
					if(arr[i][j-1] == 0) //좌
						sum++;
					if(arr[i][j+1] == 0) //우  비교
						sum++;
					
				}
			}
			}
		}
		System.out.println(sum);
	}
}