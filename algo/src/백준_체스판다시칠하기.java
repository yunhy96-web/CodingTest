import java.io.*;
import java.util.*;

public class 백준_체스판다시칠하기 {
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char [][]map = new char[N][M];
        for(int i =0 ;i<N; i++){
            String temp = br.readLine();
            for(int j =0; j<M; j++){
                map[i][j] = temp.charAt(j);
            }
        }

        //여기서 8*8 을 점검해야함 이중포문으로
        for(int i =0; i<N-7; i++){
            for(int j =0; j<M-7;j++){
                find(i, j, map);
            }
        }
        //점검 후 가장 왼쪽 위가 w일때와 b일때 고쳐야할 갯수중 더 적을 것을 뽑는다.
        //지금까지의 최솟값과 비교 후 더 작은 값을 저장한다.
        System.out.println(min);
    }

    private static void find(int o, int p, char[][]map){
        int max_o = o+8;
        int max_p = p+8;

        //가장 처음에 있는 문자를 저장
        char temp = map[o][p];
        int count = 0;
        //포문 돌려야함 돌릴때마다 최소값 갱신

        for(int i =o; i< max_o; i++){
            for(int j =p ;j<max_p; j++){
                if((i+j) %2 == 0){
                    if(map[i][j] == 'B'){
                        count++;
                    }
                }else{
                    if(map[i][j] == 'W'){
                        count++;
                    }
                }
            }

        }
        int tempMin = Math.min(count , 64-count);
        min = Math.min(tempMin, min);
    }
}
