import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); //스위치의 개수 입력
		int n = 0;
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i<N; i++) { 
			arr[i] = Integer.parseInt(st.nextToken()); //스위치가 꺼져있는지 켜져있는지 0 1로 작성.
		}
		int repeat = Integer.parseInt(br.readLine()); //반복횟수 작성
		int gender = 0;
		for(int i = 0; i<repeat; i++) {
			st = new StringTokenizer(br.readLine()); 
			gender = Integer.parseInt(st.nextToken()); //성별을 받아옴.
			n = Integer.parseInt(st.nextToken()); //몇번째 스위치를 받을건지 생각.
			if(gender==1) { //성별이 남자라면.
				int a = 1;
				if(n==1) {
					for(a = 0; a<N; a++) {
						if(arr[a]==0) {
							arr[a] = 1;
						}else {
							arr[a] = 0;
						}
					}
				} else {
				for(a = n-1; a<N; a = a+n) {
					if(arr[a]==0) {
						arr[a] = 1;
					}else {
						arr[a] = 0;
					}
				}
				}
			}else { //성별이 여자라면(즉 2를 눌렀을때)
				int cnt = 1;
				for(int a = n-cnt; ; ) {
					if(a-cnt < 0 || a+cnt > N-1) {
						if(arr[a]==0) {
							arr[a] = 1;
						}else {
							arr[a] = 0;
						}
						break;
					}
					if(arr[a-cnt]==arr[a+cnt]) {
						if(arr[a-cnt]==0) {
							arr[a-cnt] = 1;
							arr[a+cnt] = 1;
						}else {
							arr[a-cnt] = 0;
							arr[a+cnt] = 0;
						}
						cnt++;
					}else {
						if(arr[a]==0) {
							arr[a] = 1;
						}else {
							arr[a] = 0;
						}
						break;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<=N; i++) {
			sb.append(arr[i-1]+ " ");
			if(i%20==0) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}