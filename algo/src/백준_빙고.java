import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_빙고 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [][]map = new int[5][5];
        for(int i =0; i< 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int [][]call = new int[5][5];
        int count = 0;
        for(int i =0; i< 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5;j++){
                call[i][j] = Integer.parseInt(st.nextToken());
                //여기 로직
                for(int k =0; k<5; k++){
                    for(int o =0; o<5; o++){
                        if(call[i][j] == map[k][o]){
                            call[i][j]++;
                        }
                    }
                }
                count++;
                if(rowCheck(call)|| colCheck(call) || num1Check(call) || num2Check(call)){//조건만족시 가로체크 세로체크 대각 1 2 체크 하나라도 트루
                    break;
                }
            }
        }
        System.out.println(count);
    }
    private static boolean rowCheck(int[][]call){
        for(int i =0; i<5; i++){
            boolean temp = true;
            for(int j =0; j<5; j++){
                if(call[i][j]!=1){
                    temp = false;
                    break;
                }
            }
            if(temp){
                return true;
            }
        }
        return false;
    }

    private static boolean colCheck(int[][]call){
        for(int i =0; i<5; i++){
            boolean temp = true;
            for(int j =0; j<5; j++){
                if(call[j][i]!=1){
                    temp = false;
                    break;
                }
            }
            if(temp){
                return true;
            }
        }
        return false;
    }
    private static boolean num1Check(int[][]call){
        for(int i =0; i<5; i++){
            //call[0][4] call[1][3] call[2][2] ...
            boolean temp = true;
            if(call[i][4-i]!=1){
                temp = false;
            }
            if(temp){
                return true;
            }
        }
        return false;
    }
    private static boolean num2Check(int[][]call){
        for(int i =0; i<5; i++){
            //call[0][4] call[1][3] call[2][2] ...
            boolean temp = true;
            if(call[4-i][i]!=1){
                temp = false;
            }
            if(temp){
                return true;
            }
        }
        return false;
    }
}
