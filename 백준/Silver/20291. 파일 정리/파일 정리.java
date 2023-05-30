import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> exe = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			String splitS[] = s.split("\\.");
			exe.put(splitS[1], exe.getOrDefault(splitS[1], 0) + 1);
		}
		String result[][] = new String[exe.size()][2];
		int cnt = 0;
		for (HashMap.Entry<String, Integer> map : exe.entrySet()) {
			result[cnt][0] = map.getKey();
			result[cnt][1] = String.valueOf(map.getValue());
			cnt++;
		}
		Arrays.sort(result, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				 if(o1[0].toString().contentEquals(o2[0].toString()))
	                    return o1[1].toString().compareTo(o2[1].toString());
	                else
	                    return o1[0].toString().compareTo(o2[0].toString());
			}
		});
		for(int i = 0; i < result.length; i++) {
			sb.append(result[i][0]).append(" ").append(result[i][1]);
			if(i != result.length-1)
				sb.append("\n");
		}
		System.out.println(sb);
	}
}