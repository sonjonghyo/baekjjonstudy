import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int arr[];
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			int upmax = 0; //올라갈때 높이가 가장 심할때의 변수 
			int downmax = 0; //내려갈때 높이가 가장 심할때의 변수.
			for(int i = 0; i<N; i++) { //먼저 블록의 개수를 각 배열에 담아준다.
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i<N-1; i++) { //2개씩 비교하며 이동해야하므로 범위를 N-1까지로만 해주어 배열의 초과를 막아준다.
				if(arr[i] < arr[i+1]) {
					if(upmax <arr[i+1]-arr[i])
						upmax = arr[i+1]-arr[i];
				}else if(arr[i] > arr[i+1]) {
					if(downmax < arr[i]-arr[i+1])
						downmax = arr[i]-arr[i+1];
				}
			}
			sb.append(upmax).append(" ").append(downmax);
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}