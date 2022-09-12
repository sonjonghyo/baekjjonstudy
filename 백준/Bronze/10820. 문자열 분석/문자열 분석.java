import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		String s = null;
		while((s = br.readLine()) != null) {
			sb = new StringBuilder();
			int up = 0;
			int down = 0;
			int space = 0;
			int num = 0;
			for(int i = 0; i<s.length(); i++) {
				if(s.charAt(i)>='a' && s.charAt(i)<='z') {
					down++;
				}else if(s.charAt(i)>='A' && s.charAt(i)<='Z') {
					up++;
				}else if(s.charAt(i)==' ') {
					space++;
				}else if(s.charAt(i)>='0' && s.charAt(i)<='9') {
					num++;
				}
			}
			sb.append(down).append(" ").append(up).append(" ").append(num).append(" ").append(space);
			System.out.println(sb);
		}
	}
}