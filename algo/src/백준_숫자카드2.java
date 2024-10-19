import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_숫자카드2 {
    public static void main(String[] args) throws IOException { //8시30분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i =0; i<a.length; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[]b = new int[M];
        st = new StringTokenizer(br.readLine()," ");
        for(int i =0; i<b.length; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        //이분탐색 구현
        Arrays.sort(a);
        for(int i =0 ;i<b.length; i++){
            int answer =0;
            int min = 0;
            int max = a.length-1;
            while (min <= max){
                int mid = (min+max)/2;
                if(a[mid] < b[i]){ //중간 값이 찾아야 할 값보다 작다면 => min 을 올려야함
                    min = mid +1;
                }else if(a[mid] > b[i]){
                    max = mid -1;
                }else if(a[mid] == b[i]){
                    answer++;

                }
            }

            System.out.print(answer +" ");
        }
    }
}
