import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			arr[i] += 500000; //-500,000~500,000범위이므로 음수값제거를 위해 +500,000을 해주었다.
			if(max<arr[i])
				max = arr[i];
		}
		int arr2[] = new int[max+1]; //정렬하기 위해 카운팅 정렬을 사용하였다.
		for(int i = 0; i<arr.length; i++) {
			arr2[arr[i]]++;
		}
		for(int i = 1; i<arr2.length; i++) {
			arr2[i] = arr2[i-1] + arr2[i];
		}
		int temp[] = new int[N];
		for(int i = temp.length-1; i>=0 ; i--) {
			temp[--arr2[arr[i]]] = arr[i]-500000;
		}
		if(N==1) {
			int avg = temp[0];
			int middle = temp[0];
			int mode = temp[0];
			int range = 0;
			sb.append(avg).append("\n").append(middle).append("\n").append(mode).append("\n").append(range);
		}else if(N>1) {
			int avg = 0;
			for(int i = 0; i<N; i++) {
				avg += temp[i];
			}
			if(avg<0) {
				avg = -avg;
				avg = Math.round(avg/(float)temp.length); //평균값 구하는 부분
				if(avg==0) {
					avg = 0;
				}else {
					avg = -avg;					
				}
			}else {
				avg = Math.round(avg/(float)temp.length);
			}
			sb.append(avg).append("\n");
			int middle = temp[temp.length/2]; //중간값 구하는 부분
			sb.append(middle).append("\n");
			max = temp[temp.length-1]; //최대값.
			int min = temp[0]; //최소값.
			int mode = 0; //최빈값.
			int range = max-min;
			int value[];
			if(min>0) {
				value = new int[max+min+1]; //범위 				
			}else {
				value = new int[max-min+1]; //범위.
			}
			max = Math.abs(temp[temp.length-1]);
			min = Math.abs(min); //음수를 전부 양수로 만들기위해 사용. 나중에 값 구할때 다시 빼줌.
			for(int i = 0; i<N; i++) { //빈도수 구하는것.
				value[temp[i]+min]++;
			}
			int maxidx = 0;
			int cnt = 0;
			for(int i = 0; i<value.length; i++) {
				if(mode<value[i]) {
					mode = value[i];
					maxidx = i;
				}
			}
			for(int i = 0; i<value.length; i++) {
				if(mode == value[i]) {
					cnt++;
					if(cnt==2) {
						sb.append(i-min).append("\n");
						break;
					}
				}
			}
			if(cnt==1) {
				sb.append(maxidx-min).append("\n");
			}
			sb.append(range);
		}
		System.out.println(sb);
	}
}