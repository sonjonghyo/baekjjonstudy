import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int height[] = new int[9];
		int sum = 0;
		int a = 0;
		int b = 0;
		for (int i = 0; i < 9; i++) {
			height[i] = Integer.parseInt(br.readLine());
			sum += height[i];
		}
		Arrays.sort(height);
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - height[i] - height[j] == 100) {
					a = i;
					b = j;
					break;
				}
			}
		}
		for (int k = 0; k < 9; k++) {
			if(k == a || k == b)
				continue;
			System.out.println(height[k]);
		}
		br.close();
	}
}