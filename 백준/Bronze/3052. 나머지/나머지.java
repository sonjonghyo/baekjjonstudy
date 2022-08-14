import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[10];
		int count = 1;
		for(int i = 0; i<10; i++) { 
			int N = Integer.parseInt(br.readLine());
			arr[i] = N%42;
		}
		for(int i = 0; i<10; i++) {
			for(int j = i+1; j<10; j++) {
				if(arr[i] == arr[j]) {
					break;
				}
				if(j==9) {
				count++;
				break;
				}
			}
		}

		System.out.println(count);
	}
}