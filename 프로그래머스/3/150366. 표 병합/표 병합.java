import java.util.*;

class Solution {
    static String graph[] = new String[2501];
	//부모를 넣어줄 배열 num 입니다.
	static int num[] = new int[2501];
	static List<String> answer = new ArrayList<>();
    public List solution(String[] commands) {
        //먼저 num과 graph를 초기화 시켜주기.
        for(int i = 0; i <= 2500; i++) {
			num[i] = i;
			graph[i] = "";
		}
        //for문을 돌며 command를 입력해주자.
        for(int i = 0; i < commands.length; i++) {
			enter(commands, i);			
		}
        return answer;
    }
    private static void enter(String[] commands, int i) {
		String[] split = commands[i].split(" ");
		switch(split[0]) {
		//업데이트 하기
		case "UPDATE" :
			//업데이트는 위치 업데이트와 이름 바꾸기가 있다.
			//만약 길이가 3보다 크다면 r,c 가 들어간 것이니 해당 위치에 이름 넣어주기.
			if(split.length > 3) {
				int r = Integer.parseInt(split[1]);
				int c = Integer.parseInt(split[2]);
				graph[find(changenum(r,c))] = split[3];
			//길이가 3인 것은 이름 바꾸기. 전체 돌면서 이름 같은거 있으면 바꿔주자.
			}else {
				for(int a= 1; a <= 50; a++) {
					for(int b = 1 ; b <= 50; b++) {
						//이름 같다면 바꿔주기.
						if(graph[changenum(a,b)].equals(split[1])) {
							graph[changenum(a,b)] = split[2];
						}
					}
				}
			}
			break;
		//표 병합시키기
		case "MERGE" :
			int a = Integer.parseInt(split[1]);
			int b = Integer.parseInt(split[2]);
			int num1 = changenum(a,b);
			int c = Integer.parseInt(split[3]);
			int d = Integer.parseInt(split[4]);
			int num2 = changenum(c,d);
			int root1 = find(num1);
			int root2 = find(num2);
			//두개가 같으면 이미 합쳐져있는거므로 다음.
			if(root1 == root2)
				return;
			//다르므로 합쳐주어야 한다.(값을 가진쪽으로 병합하기.)
			//root1의 위치가 아무것도없다면 root2를 기준으로 합치고 아니면 root1을 기준으로.
			String rootString = graph[root1].isEmpty() ? graph[root2] : graph[root1] ;
			//서로 합치기.
			union(root1, root2);
			//root2에 뭐가 있었을수도 있으니 초기화.
			graph[root2] = "";
			//앞의 위치에 rootString을 넣어줍니다.
			graph[root1] = rootString;
			break;
		//표 나누기
		case "UNMERGE" :
			int x = Integer.parseInt(split[1]);
			int y = Integer.parseInt(split[2]);
			int rootnum = changenum(x,y);
			//가장 위에있는 수 즉 어떤 문자인지 찾기 위해 사용.
			int root = find(rootnum);
			String rootString2 = graph[root];
			//넣어주기.
			graph[root] = "";
			graph[rootnum] = rootString2;
			List<Integer> update = new ArrayList<>();
			for(int e = 0; e <= 2500; e++) {
				if(find(e) == root) {
					update.add(e);
				}
			}
			for(Integer I : update) {
				num[I] = I;
			}
			break;
		//출력하기
		case "PRINT" :
			int r1 = Integer.parseInt(split[1]);
			int c1 = Integer.parseInt(split[2]);
			//혹시라도 내가 아직 합병중이라면 나와 관련된 수를 찾아야하니 찾자.(나 자신만있다면 그대로 나옴)
			int rootnum1 = find(changenum(r1,c1));
			if(graph[rootnum1].isEmpty()) {
				answer.add("EMPTY");
			}else {
				answer.add(graph[rootnum1]);
			}
			break;
		}
		
	}
	private static int changenum(int r, int c) {
		//r에 1을 빼주는 이유는 1,1부터 시작하기 때문에.
		return ((r-1) * 50) + c;
	}
	
	private static int find(int a) {
		if(num[a] == a) {
			return a;			
		}else {
			return num[a] = find(num[a]);
		}
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) 
			num[b] = a;
	}
}