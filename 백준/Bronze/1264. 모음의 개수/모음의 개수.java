import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String text = "";
		while(true) {
			int count = 0;
			text = br.readLine();
			if(text.equals("#"))
				break;
			text.trim();
			for(int i = 0; i < text.length(); i++) {
				if(text.charAt(i) == 'a' || text.charAt(i) == 'e' || text.charAt(i) == 'i' || text.charAt(i) == 'o' || text.charAt(i) == 'u') {
					count++;
				}else if(text.charAt(i) == 'A' || text.charAt(i) == 'E' || text.charAt(i) == 'I' || text.charAt(i) == 'E' || text.charAt(i) == 'O' || text.charAt(i) == 'U') {
					count++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}