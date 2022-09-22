import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ppaper[] = {0,5,5,5,5,5}; //붙일수있는 색종이.
    static int result = Integer.MAX_VALUE;
    static int paper[][] = new int[10][10]; //색종이
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0; i<10; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        putpaper(0,0,0); //종이 놓기 시작.
    
        if(result==Integer.MAX_VALUE) { //만약 result의 값이 변화가 없었다면. 즉 하나도 못붙였다면
            result = -1;     //result를 -1로 바꿔주고 출력.
        }
        System.out.println(result);
    }  
    
    public static void putpaper(int x, int y, int cnt) { //x,y에 놓을수있는지 확인. 사용한 색종이의 개수도 같이 넘겨준다.
        if(x>=9 && y>9) { 
            result = Math.min(result, cnt);
            return;
        }
        if(result <= cnt) return; //만약 내가 붙인게 결과값보다 작을시에는 끝내줌.
        //이전의 값보다 작아야 최소의 개수이므로 크거나 같은건 의미가 없음.
        
        if(y > 9) { //10이면 그 행을 전부 다 본것.
            putpaper(x+1, 0, cnt); //다음 행으로 이동.
            return;
        }
        
        if(paper[x][y]==1) {
            for(int i = 5; i>=1; i--) {
                if(ppaper[i] > 0 && check(x,y,i)) { //붙일수있는지 ppaper로 남은개수 확인해주고 check하러감.
                    pape(x,y,i,0); //먼저 pape함수를 이용해 붙여준다.
                    ppaper[i]--; //붙였으니 그 사이즈에 해당하는 종이 하나 감소.
                    putpaper(x,y+1,cnt+1); //붙이기 시작했을때부터 완전탐색 시작.
                    pape(x,y,i,1); //다시 원래의 paper를 원상복귀 시켜준다.
                    ppaper[i]++; //원상복귀 시켰으니 ppaper에서 i에 해당하는부분 다시 사이즈 증가.
                }
            }
        }else putpaper(x,y+1,cnt); //1이 아닐경우에만 다음으로 확인.
                            
        //만약 for문이 다 끝나면 이전에 실행되던것이 실행.
        //예제 입력 5같은 경우에 (6,2)에서 끝나고 (6,1)로 가긴하지만 else문에 있어 어짜피 볼필요가없으므로 y>9가있는 38번줄로 이동
        //그러고 이전에 종이를 붙이고 나서 탐색하던 46번줄이 끝나므로 47번줄이 시행된다(다시 종이붙이기).
        //그러고 다시 종이 놓기.
            
    }
    
    public static void pape(int x, int y, int size, int state) { //사이즈만큼 붙였다 떼었다 하는 함수.
        for(int i = x; i<x+size; i++) {
            for(int j = y; j<y+size; j++) {
                paper[i][j] = state;
            }
        }       
    }
    public static boolean check(int x, int y, int size) { //현재위치와 붙일사이즈를 받아옴.
        for(int i = x; i<x+size; i++) {
            for(int j = y; j<y+size; j++) {
                if(!(i>=0 && i<10 && j>=0 && j<10) || paper[i][j]!=1)  //만약 1이아니거나 범위밖이면 바로 return false로 check가 동작못하게함.
                    return false;
            }
        }
        return true; //전부 통과했으면 그 사이즈는 붙일수있는 색종이다.   
    }
}