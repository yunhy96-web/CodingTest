import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_로봇청소기 {
    static int []dx = {-1};
    static int []dy = {0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        int RobbotN = Integer.parseInt(st.nextToken());
        int RobbotM = Integer.parseInt(st.nextToken());
        int aim = Integer.parseInt(st.nextToken());

        int [][]map = new int[N][M];
        for(int i = 0; i <N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //이동시켜서 이동한 부분은 2로 만든다.
        move(RobbotN, RobbotM, aim);

    }
    private static void move(int RobbotN, int RobbotM, int aim){
        //이동하는것 종료하는 조건: 사방이 막혀있거나 aim의 반대편이 1인경우
        for(int i=0;i<4; i++){ //반시계 방향으로 회전 후 앞이 0 일 경우 전진
            int nextaim;
            //다음방향 선언
            if(aim == 0) nextaim = 3;
            if(aim == 1) nextaim = 0;
            if(aim == 2) nextaim = 1;
            if(aim == 3) nextaim = 2;
            int ddx = RobbotM + dx[i];
            int ddy = RobbotN + dy[i];
        }
        if(){

        }
    }
}
