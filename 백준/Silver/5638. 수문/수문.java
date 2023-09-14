import java.util.*;
import java.io.*;

public class Main {
	static int minprice;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); //수문의 개수
		int waterdoor[][] = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			waterdoor[i][0] = Integer.parseInt(st.nextToken()); //유량
			waterdoor[i][1] = Integer.parseInt(st.nextToken()); //피해 비용
		}
		Arrays.sort(waterdoor, new Comparator<int[]>() { //피해비용이 적은순으로 정렬
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		int M = Integer.parseInt(br.readLine()); //테스트 케이스의 수
		int test[][] = new int[M][2];
		for(int i =0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			test[i][0] = Integer.parseInt(st.nextToken()); //비워야 하는 물
			test[i][1] = Integer.parseInt(st.nextToken()); //비워내야 하는 시간
		}
		for(int t = 0; t < M; t++) {
			int dp[][] = new int[N][2];
			minprice = Integer.MAX_VALUE; //최소비용
			for(int i = 0; i < N; i++) {
				dp[i][0] = waterdoor[i][0] * test[t][1];
				dp[i][1] = waterdoor[i][1];
			}
			search(dp, test[t][0], 0,0, N, 0); //dp배열, 비워야할 물, 현재 물 ,시작위치, 총 개수, 최소 비용
			if(minprice == Integer.MAX_VALUE) {
				sb.append("Case ").append(t + 1).append(": IMPOSSIBLE");
			}else {
				sb.append("Case ").append(t + 1).append(": ").append(minprice);
			}
			if(t != M-1)
				sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void search(int[][] dp, int max, int water ,int i, int N, int price) {
		if(water >= max) {
			if(minprice > price) {
				minprice = price;
			}
			return;
		}
		for(int s = i; s < N; s++) {
			search(dp, max, water + dp[s][0], s+1, N, price + dp[s][1]);				
		}
		
	}
}