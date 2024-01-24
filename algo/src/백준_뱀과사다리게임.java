import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_뱀과사다리게임 {
    public static int [] map = new int[101];
    public static int [] checkmap = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //사다리의수
        int M = Integer.parseInt(st.nextToken()); //뱀의수
        //N개의 줄에는 사다리 정보 둘다 합침
        for(int i= 0; i< N+M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start] = end;
        }

        game();
        System.out.println(checkmap[100]);

    }

    public static void game(){
        Queue<Integer> q= new LinkedList<>();
        q.add(1); //첫 시작점
        checkmap[1] = 0; //??

        while (!q.isEmpty()){
            int cur = q.poll();
            if(cur == 100){
                break;
            }
            //주사위 굴리기
            for(int i = 1; i<=6; i++){
                if(cur+i > 100) continue;   // 100넘어가면 다음반복으로
                //이동할 곳이 사다리나 뱀이 없고 방문하지 않은곳
                if(checkmap[cur+i] == 0 && map[cur+i] == 0){
                    checkmap[cur+i] = checkmap[cur]+1; //몇번째로 방문하게 되었는지 checkmap에 들어가는것.
                    q.offer(cur+i);
                }
                else if(map[cur+i] != 0){ //사다리 또는 뱀이 있을 경우
                    int move = map[cur+i];
                    if(checkmap[move] == 0){
                        checkmap[move] = checkmap[cur]+1;
                        q.add(move);
                    }
                }
            }
        }

    }
}
