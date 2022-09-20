import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int mini[];
	static int temp[];
	static int sum;
	static int result[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		mini = new int[9]; //아홉명 주어주므로 9로 만들고
		temp = new int[7]; //임시적으로 저장될 7명에 대한 배열.
		result = new int[7]; //결과를 저장해줄 7명에 대한 배열
		for(int i = 0; i<9; i++) {
			mini[i] = Integer.parseInt(br.readLine());
		}
		comb(0,0);
		Arrays.sort(result);
		for(int i = 0; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}
	public static void comb(int idx, int sidx) {
		if(sidx==temp.length) {
			sum = 0;
			for(int i = 0; i<sidx; i++) {
				sum += temp[i];
			}
			if(sum==100) {
				result=temp.clone();
			}	
		}else if(idx >= mini.length) {
			return;			
		}else {
			temp[sidx] = mini[idx];
			comb(idx+1, sidx+1);
			comb(idx+1, sidx);
		}
	}
}