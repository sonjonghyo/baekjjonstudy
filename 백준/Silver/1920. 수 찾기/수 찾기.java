import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Set<Integer> memo1 = new HashSet<>();
		int su1 = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int a = 0; a < su1; a++) {
			int N = Integer.parseInt(st.nextToken());
			memo1.add(N);
		}
		int su2 = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int a = 0; a < su2; a++) {
			if (memo1.contains(Integer.parseInt(st.nextToken()))) {
				bw.write('1' + "\n");
			} else {
				bw.write('0' + "\n");
			}
		}
		bw.flush();
		br.close();
	}
}