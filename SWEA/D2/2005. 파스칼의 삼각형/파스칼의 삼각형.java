import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++)
		{
            sb.append("#").append(tc).append("\n");
			int N = Integer.parseInt(br.readLine());
            int arr[][] = new int[N+1][N+1];
            arr[1][1] = 1;
            for(int i = 2; i <= N; i++) {
             	for(int j = 1; j <= i; j++) {
                 	   arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
            for(int i = 1; i <= N; i++) {
            	for(int j = 1; j <= i; j++) {
                	sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
		}
        System.out.println(sb);
	}
}