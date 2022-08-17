import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int xdir = 0;
		int ydir = 0;
		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int mw = Integer.parseInt(st.nextToken());
		int mh = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		xdir = mw + t;
		ydir = mh + t;
		if((xdir/w)%2==0) {
			xdir = xdir%w; 
		}else {
			xdir = w-(xdir%w);
		}
		if((ydir/h)%2 ==0) {
			ydir = ydir%h;
		}else {
			ydir = h-(ydir%h);
		}
		System.out.println(xdir + " " + ydir);
	}
}