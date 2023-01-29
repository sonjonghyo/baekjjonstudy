import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		String input = br.readLine();
		String result[] = input.split(" ");
		String What = "What";
		String is = "is";
		boolean check = false;
		int cnt = 0;
		for(int i = 0; i < result.length; i++) {
			if(!check && result[i].equals(What)) { //같다면?
				if(result[i+1].contains(is)) {
					temp.append("Forty-two ");
					check = true;
					continue;					
				}
			}
			if(check) { 
				if(result[i].charAt(result[i].length()-1)=='.') {
					temp.delete(0, temp.length());
					check = false;
				}else if(result[i].charAt(result[i].length()-1)=='?') {
					temp.append(result[i]);
					temp.deleteCharAt(temp.length()-1);
					temp.append('.');
					sb.append(temp);
					temp.delete(0, temp.length());
					sb.append("\n");
					check = false;
				}else {
					temp.append(result[i] + " ");
			}
		}
	}
	System.out.println(sb);
	}
}