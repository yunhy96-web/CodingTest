import java.io.*;
import java.util.*;

public class 백준_수찾기 { //6시 17분
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int []a = new int[N];
        for(int i =0;i<N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        int []b = new int[M];
        for(int i = 0;i<M; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        //이분탐색 로직
        Arrays.sort(a);

        //하나씩 뽑아서 이분탐색 돌림
        for(int i =0 ;i<M; i++){
            int min = 0;
            int max = a.length-1;
            int answer = 0;
            while (min <= max){
                int mid = (min + max) /2;
                if(a[mid] < b[i]){ //mid 가 b 보다 작다 => 오른쪽으로 옮겨서 찾아야함 => min 에 mid 값을 넣어야한다.
                    min = mid+1;
                }else if(a[mid] > b[i]){
                    max = mid-1;
                }else if(a[mid]==b[i]){
                    answer = 1;
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
