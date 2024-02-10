import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_적록색약 {
    private static char[][]map;
    private static int N;
    private static boolean[][]visit;
    private static int[]dx = {-1, 0, 1, 0};
    private static int[]dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visit = new boolean[N][N];
        for(int i = 0 ; i<N; i++){
            String temp = br.readLine();
            for(int j=0;j<N; j++){
                map[i][j] = temp.charAt(j);
            }
        }
        //로직짜야함
        //R영역, B영역, G영역을 각각 카운트 한뒤에 정답으로 출력한다.
        int rCount = 0;
        int bCount = 0;
        int gCount = 0;
        for(int i = 0 ;i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]=='R' && !visit[i][j]){ //방문한적이 없고 R 이라면 여기 영역에서 dfs 돌림
                    dfs(i, j, map[i][j]);
                    rCount++;
                }
                else if(map[i][j] == 'B' && !visit[i][j]){
                    dfs(i, j, map[i][j]);
                    bCount++;
                }
                else if(map[i][j] == 'G' && !visit[i][j]){
                    dfs(i, j, map[i][j]);
                    gCount++;
                }
            }
        }
        //아에 다시 visit을 초기화 하고 적록색약이 보는 영역을 구해야함
        int rgCount = 0;
        visit = new boolean[N][N]; //초기화
        for(int i =0; i <N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 'R' || map[i][j] == 'G'){
                    if(!visit[i][j]){
                        rgDfs(i, j);
                        rgCount++;
                    }
                }
            }
        }

        int a = rCount+bCount+gCount;
        int b = rgCount + bCount;
        System.out.println(a+" "+b);

    }
    private static void rgDfs(int y, int x){
        for(int i=0; i<4; i++){
            int ddx = x + dx[i];
            int ddy = y + dy[i];
            if(ddx >= 0 && ddx < N && ddy >= 0 && ddy < N && (map[ddy][ddx] =='R' || map[ddy][ddx] == 'G') && !visit[ddy][ddx]){
                visit[ddy][ddx] = true;
                rgDfs(ddy, ddx);
            }
        }
    }
    private static void dfs(int y, int x, char t){
        for(int i =0 ; i<4; i++){
            int ddx = x + dx[i];
            int ddy = y + dy[i];
            if(ddx >=0 && ddx < N && ddy >= 0 && ddy < N && map[ddy][ddx]==t && !visit[ddy][ddx]){
                visit[ddy][ddx] = true;
                dfs(ddy, ddx, t);

            }
        }
    }
}
