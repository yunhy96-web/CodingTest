import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_아기상어 {
    static int size = 2; //물고기의 현재 크기
    static int second = 0; //정답 즉 얼마나 초가 지났는지.
    static int[]dx = {0, -1, 1, 0}; //상 좌 우 하
    static int[]dy = {-1, 0, 0, 1};
    static int N;
    static int[][]map;
    static int minX = Integer.MAX_VALUE;
    static int minY = Integer.MAX_VALUE;
    static int minDist = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        int x=0;
        int y=0;
        for(int i =0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){ //아기상어의 좌표
                    x=j;
                    y=i;
                    map[i][j] = 0; //9이면 나중에 옮겨다닐때 못지나가니까 0으로 초기화해줌.
                }
            }
        }
        int eat = 0;
        bfs(x,y,size, eat, second);

    }
    private static void bfs(int x, int y, int size,int eat, int second){
        Queue<int[]>que = new LinkedList<>();
        que.add(new int[]{x,y});
        int [][]secondMap = new int[N][N]; //몇초가 지났는지.
        secondMap[y][x] = 1;  // 첫시작점 방문표시
        while (!que.isEmpty()){
            int []temp = que.poll();
            for(int i = 0; i<4; i++){
                int ddx = temp[0]+dx[i];
                int ddy = temp[1]+dy[i];
                if(ddx>0 && ddy >0 && ddx <N && ddy<N){
                    if(map[ddy][ddx]<= size && secondMap[ddy][ddx]==0){ //같은 크기 더작을 경우 이동가능 + 방문한적이 없음
                        //여기서 가장 가까운 다음 먹이가 있는 곳으로 이동하는 로직. 싹다 bfs 로 맵을 전부다 그린후
                        secondMap[ddy][ddx]=secondMap[y][x]+1; //방문 표시는 시간이 지날수록 초가 늘어남. 마지막 출력값에서 -1 해줘야 정답이 나온다.

                        if(map[ddy][ddx]!= 0 && map[ddy][ddx] < size){//먹을 수 있음.
                            if(minDist>secondMap[ddy][ddx]){
                                minDist = secondMap[ddy][ddx]; // 최소거리
                                minX = ddx;
                                minY = ddy;
                            }else if(minDist == secondMap[ddy][ddx]){ //거리가 같을 시

                            }
                        }
                        que.add(new int[]{ddx, ddy});

                        //가장가까운 원소가 있는 곳의 초를 추출.
                        //그 뒤 초를 샌 배열을 0으로 싹다 초기화. 그러면 이동할때 초가 0인부분만 검사를 해야하는 부분 추가해야함.
                    }
                }
            }

        }
        //여기서 다시 bfs 를 재귀호출하여 그 점에서부터 다시 bfs 를 돌린다. size 랑 eat 이랑 같으면 size++, eat=0 으로 초기화
    }
}
