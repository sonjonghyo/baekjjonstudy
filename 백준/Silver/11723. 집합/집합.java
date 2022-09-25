import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int arr[] = new int[21];
		int M = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<M; tc++) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			switch(op) {
			case "add" :
				int numa = Integer.parseInt(st.nextToken());
				if(arr[numa]!=0) {
					continue;
				}else {
					arr[numa] = numa;
				}
				break;
			case "remove" :
				int numr = Integer.parseInt(st.nextToken());
				if(arr[numr]==0) {
					continue;
				}else {
					arr[numr] = 0;
				}
				break;
			case "toggle" :
				int numt = Integer.parseInt(st.nextToken());
				if(arr[numt]==0) {
					arr[numt] = numt;
				}else {
					arr[numt] = 0;
				}
				break;
			case "check" :
				int numc = Integer.parseInt(st.nextToken());
				if(arr[numc] != 0) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
				break;
			case "all" :
				for(int i = 1; i<21; i++) {
					arr[i] = i;
				}
				break;
			case "empty" :
				for(int i = 1; i<21; i++) {
					arr[i] = 0;
				}
				break;	
			}
		}
		System.out.println(sb);
	}
}