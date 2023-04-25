import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String word[] = new String[N];
		for(int i = 0; i < N; i++) {
			word[i] = br.readLine();
		}
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				if(word[i].length() != word[j].length())
					continue;
				int alpha[] = new int[27];
				int alpha2[] = new int[27];
				for(int k = 0; k < word[j].length(); k++) {
					int a1 = word[i].charAt(k)-96;
					int a2 = word[j].charAt(k)-96;
					if(alpha[a1] == 0 && alpha2[a2] == 0) { //0이면 저장
						alpha[a1] = a2;
						alpha2[a2] = a1;
					}else if(alpha[a1] != a2) {
						break;
					}
					if(k == word[j].length()-1) { //끝까지 왔으면?
						cnt++; //하나 추가.
					}
				}
			}
		}
		System.out.println(cnt);
	}
}