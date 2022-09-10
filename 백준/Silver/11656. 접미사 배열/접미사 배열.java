import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String jb[] = new String[s.length()]; //접미사들을 넣어줄 배열.
		for(int i = 0; i<s.length(); i++) {
			String misa = "";
			for(int j=i; j<s.length(); j++) {
				misa += s.charAt(j);
			}
			jb[i] = misa;
		}
		Arrays.sort(jb);
		for(int i = 0; i<jb.length; i++) {
			System.out.println(jb[i]);				
		}
	}
}