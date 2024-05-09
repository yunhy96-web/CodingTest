import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_벽부수고이동하기{
    private static int[][] map;
    private static int[][][] visit;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new int[N][M][2]; // 벽을 부쉈는지 안 부쉈는지에 대한 방문 확인

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0}); // x, y, 벽 부순 상태(0: 안 부숨, 1: 부숨)
        visit[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int wall = current[2];

            if (x == N-1 && y == M-1) {
                return visit[x][y][wall];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0 && visit[nx][ny][wall] == 0) {
                        visit[nx][ny][wall] = visit[x][y][wall] + 1;
                        queue.offer(new int[]{nx, ny, wall});
                    } else if (map[nx][ny] == 1 && wall == 0 && visit[nx][ny][1] == 0) {
                        visit[nx][ny][1] = visit[x][y][wall] + 1;
                        queue.offer(new int[]{nx, ny, 1});
                    }
                }
            }
        }

        return -1;
    }
}
