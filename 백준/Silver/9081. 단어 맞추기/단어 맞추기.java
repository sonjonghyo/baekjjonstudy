import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < T; tc++) {
			String word = br.readLine();
			char tmp = ' ';
			char splitword[] = word.toCharArray();
			loop : for(int i = splitword.length-1; i > 0; i--) { //앞에 작은게 있을때 시작.(맨앞까진 볼필요없다.)
				if(splitword[i] > splitword[i-1]) {
					for(int j = splitword.length-1; j > 0; j--) {
						if(splitword[j] > splitword[i-1]) { //앞의 문자가 더 크다면?
							tmp = splitword[i-1];
							splitword[i-1] = splitword[j];
							splitword[j] = tmp;
							int endIdx = splitword.length-1;
							for(int k = i; k <= (i+splitword.length-1)/2; k++) { //끝에서 부터 바꿔주어야함.
								char temp = splitword[k];
								splitword[k] = splitword[endIdx];
								splitword[endIdx--] = temp;
							}
							break loop; //바꿔주기.
						}
					}
					
				}
			}
			for(int i = 0; i < splitword.length; i++) {
				sb.append(splitword[i]);
			}
			if(tc != T-1) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
