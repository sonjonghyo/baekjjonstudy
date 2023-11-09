import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
    	StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1 ; tc <= T; tc++) {
         	st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int h = h1 + h2;
            int m = m1 + m2;
            if(m >= 60) {
            	m -= 60;
                h++;
            }
            if(h >= 12) {
             	h -= 12;   
            }
            sb.append("#").append(tc).append(" ").append(h).append(" ").append(m);
            if(tc != T) {
             	sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}