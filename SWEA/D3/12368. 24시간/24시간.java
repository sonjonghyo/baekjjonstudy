
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) { //testcase의 반복횟수
			int sum = 0;  //시간의 합을 계산.
			sb.append("#").append(tc).append(" "); //시간을 조금이라도 줄여주기위해 StringBuilder를 사용했으며 처음에 #1 을 저장해줌.
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); //각각의 시간을 저장.
			int B = Integer.parseInt(st.nextToken());
			sum = A+B;
			if(sum>=24) { //만약 sum이 24보다 크다면
				sb.append(sum-24); //24시부터는 다시 0시이므로 24를 빼준다.
			}else { //그 외의 조건은 24시 이내이므로 
				sb.append(sum); //그대로 추가해준다.
			}
			if(tc!=T)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}