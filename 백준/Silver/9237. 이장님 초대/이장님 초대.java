import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Integer invite[] = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			invite[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(invite, Collections.reverseOrder()); //역순정렬
		int max = 0; //최대값
		for(int i = 0; i < N; i++) { 
			invite[i] = invite[i] + i + 1;
            //최대값부터 현재 지난시간 + 1해서 최대값을 찾아주기.
			if(invite[i] > max) {
				max = invite[i];
			}
		}
		System.out.println(max+1);
	}
}