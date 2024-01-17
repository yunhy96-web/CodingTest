import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_로봇청소기 {
    //0 1 2 3 순서대로 북 동 남 서
    static int []dx = {0,1,0,-1}; //북 동 남 서
    static int []dy = {-1,0,1,0}; //북 동 남 서
    static int[][]map;
    static int count = 1;
    static int M,N = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); //y축을 담당
        M = Integer.parseInt(st.nextToken()); //x축을 담당

        st = new StringTokenizer(br.readLine()," ");
        int R = Integer.parseInt(st.nextToken()); //현재 Y좌표
        int C = Integer.parseInt(st.nextToken()); //현재 X좌표
        int D = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i <N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //이동시켜서 이동한 부분은 2로 만든다.
        move(R, C, D);
        System.out.println(count);

    }
    private static void move(int RobbotN, int RobbotM, int aim){
        //처음 들어오면 2로 만들어줌. 2 는 청소했다는 의미
        if(map[RobbotN][RobbotM]!=1){
            map[RobbotN][RobbotM] = 2;
        }
        //이동하는것 종료하는 조건: 사방이 막혀있거나 aim의 반대편이 1인경우
        for(int i=0;i<4; i++){ //반시계 방향으로 회전 후 앞이 0 일 경우 전진
            //int nextaim;
            //다음방향 선언 아래 주석처리된 4개 줄의 코드를 간결화. 방향 전환을 의미.
            aim = (aim+3)%4;
//            if(aim == 0) nextaim = 3;
//            if(aim == 1) nextaim = 0;
//            if(aim == 2) nextaim = 1;
//            if(aim == 3) nextaim = 2;
            int ddx = RobbotM + dx[aim]; //바라보고 있는 방향으로 한칸 이동
            int ddy = RobbotN + dy[aim];
            //이동 시 범위 판별 후 범위이내이거나 1 즉 벽이 아니고 2 즉 청소도 안한곳이면 해당으로 이동
            //계속해서 탐색하는 것이 아니라 일직선으로만 뻗어갓다가 돌아오니 return해줘야함
            if(ddx>=0 && ddx <M && ddy >= 0 && ddy < N){
                if(map[ddy][ddx]==0){ //청소안한곳이면이동가능
                    count++;
                    move(ddy, ddx, aim);
                    return;
                }
            }
        }
        //위에서 이동 조건에 안맞는곳. 즉 다 막혀있어서 이동이 안되는 경우는 후진해야함.
        int naim = (aim+2)%4; //반대 방향
        int nnx = RobbotM + dx[naim];
        int nny = RobbotN + dy[naim];
        if(nnx >= 0 && nnx < M && nny >=0 && nny < N) { //1로 막혀잇지는 않아야함
            if(map[nny][nnx]!=1){
                move(nny, nnx, aim); //후진만 하니까 바라보는 에임은 유지가 되어야한다.
            }
        }
    }
}
