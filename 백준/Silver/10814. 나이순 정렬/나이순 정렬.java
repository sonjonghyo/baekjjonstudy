import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int age[] = new int[N]; //나이를 저장할 배열.
		String name[] = new String[N]; //이름을 저장할 배열
		int arr[] = new int[N]; //나이를 저장해 오름차순으로 정렬해줄 배열.
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			age[i] = Integer.parseInt(st.nextToken());
			name[i] = st.nextToken();
			arr[i]= age[i];
		}	
		Arrays.sort(arr); //오름차순으로 정렬해준다.
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(arr[i] == age[j]) { //오름차순 나이를 비교해주어  같은 나이를 앞에서 부터 찾는다.
					sb.append(age[j]);
					sb.append(" ");
					age[j] = -1; //원래 age에 있던 나이는 다시는 안걸리게 -1로 만들어준다.
					sb.append(name[j]);
					sb.append("\n");
					name[j] = ""; //이름창도 비워주고
					break; //더이상 그 이후는 볼필요가 없으므로 break를 걸어준다.
				}
			}
		}
		System.out.print(sb);
	}
}