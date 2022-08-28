import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int S1 = Integer.parseInt(st.nextToken());
		int S2 = Integer.parseInt(st.nextToken());
		int S3 = Integer.parseInt(st.nextToken());
		int arr[] = new int[101]; //최대합이 100이므로 0~100까지 있는 배열을 만들어준다.
		for(int x = 1; x<=S1; x++) {
			for(int y = 1; y<=S2; y++) {
				for(int z = 1; z<=S3; z++) {
					int sum = x+y+z;
					arr[sum]++;
				}
			}
		}
		int max = 0;
		int maxidx = 0;
		for(int i = 0; i<arr.length; i++) {
			if(max<arr[i]) {
				max = arr[i];
				maxidx = i;
			}
		}
		System.out.println(maxidx);
	}
}