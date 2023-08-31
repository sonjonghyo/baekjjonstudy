import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int num[] = new int[D];
		num[0] = K;
		int minus = 1;
		int cnt = 1;
		while(true) {
			if(cnt == 1) {
				num[cnt] = num[cnt-1] - minus; 
			}else {
				num[cnt] = num[cnt-2]-num[cnt-1];
			}
			if(num[cnt] > num[cnt-1]) {
				minus++;
				cnt = 1;
			}else {
				cnt++;
				if(cnt == D)
					break;
			}
		}
		System.out.println(num[D-1]);
		System.out.println(num[D-2]);
	}
}