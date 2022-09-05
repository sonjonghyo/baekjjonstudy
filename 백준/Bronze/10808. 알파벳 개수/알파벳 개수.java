import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int alphabet[] = new int[26]; //알파벳의 개수가 26개이므로 26칸으로 만들어준다.
		for(int i = 0; i<s.length(); i++) {
			alphabet[s.charAt(i)-'a']++;
		}
		for(int i = 0;i <alphabet.length; i++) {
			System.out.print(alphabet[i]);
			if(i!=alphabet.length-1)
				System.out.print(" ");
		}
	}
}