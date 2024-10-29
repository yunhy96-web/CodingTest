import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 백준_달팽이2 { //오후 7시 35분
    private static int[]dx = {0, 1, 0, -1}; //하 우 상 좌
    private static int[]dy = {1, 0, -1, 0}; //하 우 상 좌
    private static int[][]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int start = n*n;
        int index = Integer.parseInt(br.readLine());
        //로직
        int nowX = 0;
        int nowY = 0;
        int d = 0; //방향을 나타냄
        int answerX = 0;
        int answerY = 0;
        while(start>0){
            arr[nowY][nowX] = start;
            if(start == index){
                answerX = nowX+1;
                answerY = nowY+1;
            }
            int nextY = nowY + dy[d];
            int nextX = nowX + dx[d];
            //못가는경우= 범위 벗어난 경우랑 이미 값이 들어있는 경우
            if(nextY<0 || nextX < 0 || nextY >= n || nextX >= n || arr[nextY][nextX]!=0){
                d = (d+1)%4;
                nextY = nowY + dy[d];
                nextX = nowX + dx[d];;
            }
            nowY = nextY;
            nowX = nextX;
            start--;
        }
        for(int i = 0; i<n; i++){
            for(int j =0 ; j<n; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(answerY+" "+answerX);
    }
}
