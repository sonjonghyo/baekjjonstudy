class Solution {
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0, visited, 0);
        return answer;
    }
    
    private static void dfs(int k , int[][] dungeons, int cnt, boolean[] visited, int tmp) {
        for(int i = 0; i < dungeons.length; i++) {
            //방문하지 않았으며 현재 남은 피로도가 던전 최소 필요도 보다 많거나 같아야 한다.
            if(!visited[i] && dungeons[i][0] <= k) {
                //방문 처리를 해주고?
                visited[i] = true;
                dfs(k-dungeons[i][1], dungeons, cnt + 1, visited, tmp + 1);
                visited[i] = false;
            }
        }
        if(answer < tmp)
            answer = tmp;
    }
}