import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int max[][] = new int[N][3];
        int min[][] = new int[N][3];
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            if(i==0) {
            	int a0 = Integer.parseInt(st.nextToken());
            	int b0 = Integer.parseInt(st.nextToken());
            	int c0 = Integer.parseInt(st.nextToken());
                min[i][0] = a0;
                min[i][1] = b0;
                min[i][2] = c0;
                max[i][0] = a0;
                max[i][1] = b0;
                max[i][2] = c0;
            }else {
            	int a = Integer.parseInt(st.nextToken());
            	int b = Integer.parseInt(st.nextToken());
            	int c = Integer.parseInt(st.nextToken());
                min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + a;
                min[i][1] = Math.min(Math.min(min[i-1][0], min[i-1][1]),min[i-1][2]) + b;
                min[i][2] = Math.min(min[i-1][1], min[i-1][2]) + c;
                max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + a;
                max[i][1] = Math.max(Math.max(max[i-1][0], max[i-1][1]),max[i-1][2]) + b;
                max[i][2] = Math.max(max[i-1][1], max[i-1][2]) + c;
            }
        }
        int rmin = Math.min(Math.min(min[N-1][0], min[N-1][1]), min[N-1][2]);
        int rmax = Math.max(Math.max(max[N-1][0], max[N-1][1]), max[N-1][2]);
        System.out.println(rmax + " " + rmin);
    
    }
}