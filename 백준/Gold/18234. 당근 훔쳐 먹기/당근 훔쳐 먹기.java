import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int carrot[][] = new int[N][2];
		for(int i = 0; i<N; i++) { //1번부터 N번까지 넣어주기위해 배열을 N+1로 생성.
			st = new StringTokenizer(br.readLine());
			carrot[i][0] = Integer.parseInt(st.nextToken()); //처음 심을때 가지고있는 영양소
			carrot[i][1] = Integer.parseInt(st.nextToken()); //추가로 줄때 되는 영양소.
		}
		Arrays.sort(carrot, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				 if(o1[1] == o2[1]) {
                	 return o1[0] - o2[0];
	    	 }else {
	    		 return o1[1] - o2[1]; 
	    	 }
			}
		
		});
		long sum = 0;
		int cnt = 0;
		for(int i = T-N; i < T; i++) {
			long s = (long)carrot[cnt][0];
			long e = (long)carrot[cnt][1]*i;
			sum += s + e;
			cnt++;
		}
		System.out.println(sum);
		
	}
}