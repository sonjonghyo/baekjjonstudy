import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int alphabet[] = new int[26]; //알파벳의 개수가 26개이므로 26칸으로 만들어준다.
		Arrays.fill(alphabet, -1);
		int cnt = 0;
		for(int i = 0; i<s.length(); i++) {
			if(alphabet[s.charAt(i)-'a'] == -1) {
				alphabet[s.charAt(i)-'a'] = cnt++;
				continue;
			}
			cnt++;
		}
		for(int i = 0;i <alphabet.length; i++) {
			System.out.print(alphabet[i]);
			if(i!=alphabet.length-1)
				System.out.print(" ");
		}		
	}
}