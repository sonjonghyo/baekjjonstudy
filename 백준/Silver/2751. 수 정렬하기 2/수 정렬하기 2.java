import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int arr[]= new int[N];
		int temp[] = new int[N];
		int max = 0;
		int min = 0;
		for(int i = 0; i<N; i++) {                        //N개의 입력을 받아옴.
			arr[i] = Integer.parseInt(br.readLine())+1000000;
			if(max < arr[i]) {   //안에서 카운팅 정렬을 위해 바로 최대값을 구해준다.
				max = arr[i];
			}
		}
			int arr2[] = new int[max+1];
			for(int i = 0; i<arr.length; i++) {
				arr2[arr[i]]++;  //arr[i]의 수를 보고 arr2[]를 ++ 즉 빈도수 체크를 해주는 부분이다.
			}
			for(int i = 1; i<arr2.length; i++) {
				arr2[i] += arr2[i-1]; 
			}
			for(int i=N-1; i>=0; i--) {
				temp[--arr2[arr[i]]] = arr[i];
			}
			StringBuilder sb = new StringBuilder();
			for(int i =0; i<N; i++) {
				sb.append((temp[i]-1000000)+"\n");
			}
			bw.write(sb.toString());
			bw.flush();
			bw.close();
	}
}