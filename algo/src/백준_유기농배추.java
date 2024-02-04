import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_유기농배추 {
    private static int[][]map;
    private static boolean[][]visit;
    private static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
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
                if(!visit[y][x]){
                    dfs(map, visit);
                    count++;
                }
                dfs(map, visit); //만약 이미 visit이 되어있는 상태라면 넘어가는 로직이 안에 들어있어야함
                //visit이 안되어있는 상태면 dfs를 돌리면서 count를 ++
            }
        }
    }
    private static void dfs(int[][]map, boolean[][]visit){

    }
}
