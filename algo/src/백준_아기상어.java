import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_아기상어 {
    static int N;
    static int[][]map;
    static int sharkSize = 2;
    static int[]dx = {-1, 0, 1, 0};
    static int[]dy = {0, -1, 0, 1};
    static int minX =0;
    static int minY =0;
    static int minDist =0;
    static int eatCount =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        int sharkX=0;
        int sharkY=0;
        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    sharkX = j;
                    sharkY = i;
                    map[i][j] = 0;
                }
            }
        }
        int sum =0;

        while (true){
            minDist = Integer.MAX_VALUE;
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            bfs(sharkX, sharkY);
            //minDist minX minY 3개를 알 수 있음
            //상어 사이즈 업그레이드

            if(minDist == Integer.MAX_VALUE){ //먹는거에 실패
                break;
            }else { //먹는거 성공
                //상어사이즈 업그레이드
                eatCount++;
                if(eatCount == sharkSize){
                    sharkSize++;
                    eatCount = 0;
                }
                map[minY][minX] = 0;
                sharkX = minX;
                sharkY = minY;
                sum += minDist-1; //거리합산
            }
        }
        System.out.println(sum);

    }
    private static void bfs(int sharkX, int sharkY){
        Queue<int[]>que = new LinkedList<>();
        que.add(new int[]{sharkX, sharkY});
        int [][]dist = new int[N][N];
        dist[sharkY][sharkX] = 1;

        while (!que.isEmpty()){
            int []temp = que.poll();
            sharkX = temp[0];
            sharkY = temp[1];
            for(int i =0; i<4; i++){
                int nx = sharkX + dx[i];
                int ny = sharkY + dy[i];
                //nx ny 조건 들어가야함.
                if(nx >=0 && ny >=0 && nx <N && ny <N){
                    if(map[ny][nx]<=sharkSize && dist[ny][nx] == 0){
                        dist[ny][nx] = dist[sharkY][sharkX] + 1;
                        //minX, minY, minDist 를 알아야함.
                        if (map[ny][nx] < sharkSize && map[ny][nx] != 0) { // 먹을 수 있는 물고기 발견
                            if (minDist > dist[ny][nx] ||
                                    (minDist == dist[ny][nx] && (minY > ny || (minY == ny && minX > nx)))) {
                                minDist = dist[ny][nx];
                                minX = nx;
                                minY = ny;
                            }
                        }

                        que.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

}