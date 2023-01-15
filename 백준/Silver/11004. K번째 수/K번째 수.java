import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int num[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		quickSort(num, 0, num.length - 1);
		System.out.println(num[K-1]);
 	}
    private static void quickSort(int[] arr, int L, int R){
        //파티션 나누고 오른쪽 값 첫번째 값을 받아옴
        int part = partition(arr, L, R);
 
        //왼쪽 파티션의 요소가 하나 이상
        if (L < part - 1)
            quickSort(arr, L, part - 1);
        //오른쪽 파티션의 요소가 하나 이상
        if (part < R)
            quickSort(arr, part, R);
    }
 
    private static int partition(int[] arr, int L, int R){
        int pivot = arr[(L + R)/2];
        while (L <= R) {
            while (arr[L] < pivot) L ++;
            while (arr[R] > pivot) R--;
            if (L <= R) {
                swap (arr, L, R);
                L++;
                R--;
            }
        }
        return L;
    }
 
    private static void swap(int[] arr, int L, int R){
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }
}