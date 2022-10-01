import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
   static class Tree implements Comparable<Tree>{ //심어진 나무의 위치를 저장해줄것임. 나이까지.(나무에 대한 정보.)
       int r,c,age;
       public Tree(int r, int c, int age) {
           this.r = r;
           this.c = c;
           this.age = age;
       }
	@Override
	public int compareTo(Tree o) { //큐에 들어오면 나이순으로 재배치해줌.
		return Integer.compare(this.age, o.age);
	}
   }
   
   static class Treeinfo {
	   int val; //추가될 양분.
	   int nut = 5; //초기 영양분은 5
	   public Treeinfo(int val) {
		   this.val = val;
	   }
   }
   static PriorityQueue<Tree> alltree = new PriorityQueue<>(); //모든 나무에 대한 정보 투입.
   static Queue<Tree> stree = new LinkedList<>(); //봄에 관련된 트리. (가을에 처리.)
   static Queue<Tree> dtree = new LinkedList<>(); //봄에 양분못줘서 죽음.(여름에 처리)
   static int N,M,K;
   static Treeinfo land[][];
   static int dr[] = {-1,1,0,0,-1,-1,1,1}; //8방탐색을 위해 만듬.
   static int dc[] = {0,0,-1,1,-1,1,-1,1};
   public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;
       st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       K = Integer.parseInt(st.nextToken());
       
       land = new Treeinfo[N+1][N+1];
       for(int i = 0; i<N; i++) {
           st = new StringTokenizer(br.readLine());
           for(int j = 0; j<N; j++) {
               land[i][j] = new Treeinfo(Integer.parseInt(st.nextToken())); //겨울에 각 칸에 추가될 양분.
           }
       }
       
       for(int i = 0; i<M; i++) { //처음에 있는 나무의 개수.
    	   st = new StringTokenizer(br.readLine());
    	   int r = Integer.parseInt(st.nextToken())-1;
    	   int c = Integer.parseInt(st.nextToken())-1;
    	   int age = Integer.parseInt(st.nextToken());
    	   alltree.add(new Tree(r,c,age)); //모든 트리에 대한 정보 입력.
       }      
       for(int i = 0; i<K; i++) { //K번 반복.
    	   spring();
    	   summer();
    	   fall();
    	   winter();  	   
       }
       System.out.println(alltree.size());
   }
   private static void spring() {
       while(!alltree.isEmpty()) {
    	   Tree t = alltree.poll(); //트리에 대한 정보 빼내기.
    	   if(t.age <= land[t.r][t.c].nut) {
    		   land[t.r][t.c].nut -= t.age; //나이만큼 영양분 빼주기.
    		   t.age++; //봄이 되었으니 나이추가.
    		   stree.add(t); //나이보다 양분이 같거나 많으니 아직 살았음.
    	   }else {
    		   dtree.add(t); //영양분이 나이보다 적어 죽어버림.
    	   }
       }
   }
   private static void summer() { //죽은 애를 기준으로 해당위치에 양분에 죽은 나무 나이/2를 영양분 투입.
       while(!dtree.isEmpty()) {
    	   Tree t = dtree.poll();
    	   land[t.r][t.c].nut += t.age/2;
       }
   }
   private static void fall() {
       while(!stree.isEmpty()) { //봄에 살았으면 주위 8방에 새로운 나무 심음.
    	   Tree t = stree.poll();
    	   if(t.age%5 == 0) { //나무의 나이가 5의 배수일때만 심어줌.
    		   for(int d = 0; d<8; d++) {
    			   int nr = t.r + dr[d];
    			   int nc = t.c + dc[d];
    			   if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
    				   alltree.add(new Tree(nr,nc,1)); //새로 나는거니 나이는 1		       				   
    			   }
    		   }
    	   }
    	   alltree.add(t); //봄에 살아있는것에 넣은것도 죽은것이 아니니 모든 트리에 넣어줌.
       }   
   }
   private static void winter() {
	   for(int i = 0; i<N; i++) {
		   for(int j = 0; j<N; j++) {
			   land[i][j].nut += land[i][j].val; //겨울엔 각 땅에 미리 저장해둔 영양분이 추가됌.
		   }
	   }    
   }
}