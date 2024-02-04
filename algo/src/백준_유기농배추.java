import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_유기농배추 {
    private static int[][]map;
    private static boolean[][]visit;
    private static int count=0;
    private static int[]dx = {-1, 0, 1, 0};
    private static int[]dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int Test =0; Test < T; Test++){ //총 2번 돌려야함
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 가로 길이
            int N = Integer.parseInt(st.nextToken()); // 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 아래 정보의 길이
            map = new int[N][M]; //map 초기화
            visit = new boolean[N][M]; //방문 여부를 알 수 있는 비짓 배열만든다
            count = 0; //count 초기화
            for(int i = 0 ; i < K ; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1; //배추의 위치
            }
            for(int i=0; i<N; i++){
                for(int j=0; j<M ; j++){
                    if(!visit[i][j] && map[i][j] == 1){
                        dfs(map, visit, i, j);
                        count++;
                    }
                }
            }
            sb.append(count+"\n");
        }
        System.out.println(sb);
    }
    private static void dfs(int[][]map, boolean[][]visit, int curN, int curM){
        visit[curN][curM] = true; //방문처리 해야함
        for(int i = 0; i<4; i++){
            int nextN = curN + dy[i];
            int nextM = curM + dx[i];
            if(nextN >=0 && nextN < map.length && nextM >=0 && nextM < map[0].length && map[nextN][nextM] ==1 && !visit[nextN][nextM]){
                dfs(map, visit, nextN, nextM);
            }
        }
    }
}
