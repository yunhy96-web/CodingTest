import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_거북이 {
    // 상, 우, 하, 좌 (상부터 시계 방향으로)
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[][]map = new int[500][500];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i =0; i<t; i++){
            String command = br.readLine();
            //여기에 이제 로직 설계
            int answer = 0;
            answer = caculate(command);
            //정답출력
            System.out.println(answer);
        }
    }

    private static int caculate(String command) {
        int x=0, y = 0; //초기 좌표
        int direction = 0; //초기 바라보는 상태 : 상
        int maxX =0, minX=0, maxY =0, minY =0;
        for(int i =0 ;i<command.length(); i++){
            char tempC = command.charAt(i);
            if(tempC == 'F'){ //바라보고 있는 방향으로 한칸전진
                x += dx[direction];
                y += dy[direction];
            }else if(tempC == 'B'){
                x -= dx[direction];
                y -= dy[direction];
            }else if(tempC == 'L'){ //방향만 바꿈
                direction = (direction+3) %4;
            }else if(tempC == 'R'){
                direction = (direction+1) %4;
            }
            maxX = Math.max(x, maxX);
            minX = Math.min(x, minX);
            maxY = Math.max(y, maxY);
            minY = Math.min(y, minY);
        }

        int weight = maxX- minX;
        int height = maxY- minY;
        return weight * height;
    }
}
