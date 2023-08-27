import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++)
		{
			List<Integer> num = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            float answer = 0;
            for(int i = 0; i < 10; i++) {
				num.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(num);
            for(int i = 1; i < 9; i++) {
             	answer += num.get(i);   
            }
			int tmpans = Math.round(answer/8);
            sb.append("#").append(tc).append(" ").append(tmpans);
            if(tc != T)
                sb.append("\n");
		}
        System.out.println(sb);
	}
}