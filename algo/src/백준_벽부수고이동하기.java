import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_벽부수고이동하기 {
    private static int[][]map;
    private static boolean[][][]visit;
    private static int[]dx = {-1, 0, 1, 0};
    private static int[]dy = {0, 1, 0, -1};
    private static int N;
    private static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[2][N][M]; // 벽을 뚫었는지 여부.
        for(int i =0 ;i<N; i++){
            String temp = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = temp.charAt(j)-'0';
            }
        }
        bfs(0,0);
    }
    private static void bfs(int startY, int startX){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, startY, startX}); //처음은 벽을 뚫지 않은 상태니까 0 을 넣는다.
        while (!que.isEmpty()){
            int[]temp = que.poll();
            int blake = temp[0];
            int cury = temp[1];
            int curx = temp[2];
            for(int i =0 ;i<4; i++){
                int ny = cury+dy[i];
                int nx = curx+dx[i];
            }
        }
    }
}
