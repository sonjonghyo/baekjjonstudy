import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int arr[][] = new int[100][100];
		int arr2[][] = new int[4][4];
		int sum = 0;
		for(int i = 0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<4; j++) {
				arr2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i<4; i++) {
			for(int j = 0; j<1; j++) {
				for(int a = arr2[i][j]; a<arr2[i][j+2]; a++) {
					for(int b = arr2[i][j+1]; b<arr2[i][j+3]; b++) {
						arr[a][b] = 1;
					}
				}
			}
		}
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				if(arr[i][j]==1) {
					sum++;
				}
			}
		}
		System.out.println(sum);

	}
}