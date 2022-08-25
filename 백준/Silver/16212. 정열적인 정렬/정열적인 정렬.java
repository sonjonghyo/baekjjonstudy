import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringBuilder sb = new StringBuilder();
			StringTokenizer st;
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			st = new StringTokenizer(br.readLine());	
			for(int i = 0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr); //내장함수를 사용해 오름차순으로 정렬해준다.
			
			for(int i = 0; i<N; i++) {
				if(i!=N-1) {
					sb.append(arr[i]).append(" ");				
				}else {
					sb.append(arr[i]);
				}
			}
			System.out.println(sb);
		}
	}