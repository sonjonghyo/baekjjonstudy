import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		double m = 0;

		
		for(int i = M; i<=N; i++) {
			if(i>3) {
				m = Math.sqrt(i);
			} else if(i==2) {
				bw.write('2' + "\n");
				continue;
			} else if(i==3) {
				bw.write('3' + "\n");
				continue;
			}
			for(int a = 2;a<=m; a++) {
				  if(i%a==0) {
					break;
				} else if(a==(int)m) {
					bw.write(i + "\n");
				}
			}
			}
		bw.flush();
		bw.close();
	}
}