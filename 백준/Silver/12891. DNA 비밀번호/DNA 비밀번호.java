import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String DNA = br.readLine();
		int acgt[] = new int[4]; //ACGT의 최소개수
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			acgt[i] = Integer.parseInt(st.nextToken());
		}
		int count[] = new int[4]; //부분 문자열에 담겨있는 ACGT의 개수.
		int becnt = 0;
		int afcnt = P;
		for(int i = becnt; i < afcnt; i++) {
			switch(DNA.charAt(i)) { 
			case 'A' :
				count[0]++; 
				break;
			case 'C' :
				count[1]++;
				break;
			case 'G' :
				count[2]++;
				break;
			case 'T' :
				count[3]++;
				break;
			}
		}
		int answer= 0;
		if(count[0] >= acgt[0] && count[1] >= acgt[1] && count[2] >= acgt[2] && count[3] >= acgt[3])
			answer++;
		
		for(int i = P; i < S; i++) {
			int j = i - P;
			
			switch(DNA.charAt(j)) {
			case 'A' :
				count[0]--; 
				break;
			case 'C' :
				count[1]--;
				break;
			case 'G' :
				count[2]--;
				break;
			case 'T' :
				count[3]--;
				break;
			}
			
			switch(DNA.charAt(i)) {
			case 'A' :
				count[0]++; 
				break;
			case 'C' :
				count[1]++;
				break;
			case 'G' :
				count[2]++;
				break;
			case 'T' :
				count[3]++;
				break;
			}	
			
			if(count[0] >= acgt[0] && count[1] >= acgt[1] && count[2] >= acgt[2] && count[3] >= acgt[3])
				answer++;
		
		}
		System.out.println(answer);
	}		
}