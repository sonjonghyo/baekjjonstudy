import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> bracket = new Stack<>();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i<T; i++) {
			bracket.clear();
			String s = br.readLine();
			for(int j = 0; j<s.length(); j++) {
				if(s.charAt(j)=='(') {
					bracket.push(s.charAt(j));									
				}else {
					if(bracket.size()==0) {
						System.out.println("NO");
						break;
					}
					bracket.pop();
				}
				if(j==s.length()-1 && bracket.size() == 0) {
					System.out.println("YES");
				}
				if(j==s.length()-1 && bracket.size() != 0) {
					System.out.println("NO");
				}
			}
		}
	}
}