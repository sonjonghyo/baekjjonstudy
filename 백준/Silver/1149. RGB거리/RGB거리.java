import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int rgb[][] = new int[N][3];
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            if(i==0) {
                rgb[i][0] = Integer.parseInt(st.nextToken());
                rgb[i][1] = Integer.parseInt(st.nextToken());
                rgb[i][2] = Integer.parseInt(st.nextToken());
            }else {
                rgb[i][0] = Math.min(rgb[i-1][1], rgb[i-1][2]) + Integer.parseInt(st.nextToken());
                rgb[i][1] = Math.min(rgb[i-1][0], rgb[i-1][2]) + Integer.parseInt(st.nextToken());
                rgb[i][2] = Math.min(rgb[i-1][0], rgb[i-1][1]) + Integer.parseInt(st.nextToken());
            }
        }
        int result = Math.min(Math.min(rgb[N-1][0], rgb[N-1][1]), rgb[N-1][2]);
        System.out.println(result);
    
    }
}