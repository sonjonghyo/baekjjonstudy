import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		char arr[] = new char[s.length()];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = s.charAt(i);
		}
		Arrays.sort(arr);
		for(int i = arr.length-1; i>=0 ; i--) {
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}
}
