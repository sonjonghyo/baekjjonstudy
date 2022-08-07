import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		double arr[] = new double[N];
		double sum = 0;
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<N; i++) {
			int score = Integer.parseInt(st.nextToken());
			arr[i] = score;
		}
		Arrays.sort(arr);
		for(int i = 0; i<N; i++) {
			arr[i] = arr[i]/arr[N-1]*100;
			sum += arr[i];
		}
		System.out.println(sum/(double)N);
		br.close();
	}
}
