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

            if (x == N-1 && y == M-1) { //끝까지 갔을 때 최단거리를 출력한다. 그런데 여기서 벽을 뚫었을때 안뚫었을때를 비교해서 두개 중에 최소값을 출력해야 하는 것이 아닌가?
                return visit[x][y][wall]; //결국 끝까지 먼저 간게 가장 최소값이니까 부셧든 아니든 일단 여기서 리턴한 값이 가장 최단거리가 되긴함.
            }

            for (int i = 0; i < 4; i++) {//4방향 탐색
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == 0 && visit[nx][ny][wall] == 0) {//map이 0일 때는 장애물이 아님 && 그리고 방문한적이 없을때
                        visit[nx][ny][wall] = visit[x][y][wall] + 1; //이때는 이동 가능함으로 비짓 배열에서 1초를 늘림
                        queue.offer(new int[]{nx, ny, wall}); //벽을 뚫었든 안뚫었든 그냥 현 상황 그대로 가져감. 아래는 반대로 벽을 안뚷었을때만(map =1 일때) 뚫는 로직이 추가되어야함.
                        //그리고 아래 유효성 검사로 이미 뚫은 상황이면 패스해야함.
                        //그래서 조건 자체를 wall을 뽑아냈을 때 0인 상황만 조건에 넣어야한다.
                        //그리고 방문을 아직 안한곳이여야한다.
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
