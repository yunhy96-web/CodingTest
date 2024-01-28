import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_차이를최대로 {
    static int N=0;
    static int max=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[]arr = new int[N];
        for(int i = 0; i<N; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        //순열로 모든 경우의 수 구하고 배열 다 더하기.
        boolean[]visited = new boolean[N];
        int[]brr =new int[N];
        permu(arr, 0, brr, visited);
        System.out.println(max);
    }

    private static void permu(int[]arr, int depth, int[]brr, boolean[]visited) {
        if(depth == N){
            int tempsum = sum(brr);
            if(max<tempsum){
                max = tempsum;
            }
            return;
        }
        for(int i = 0; i<N; i++){
            if(!visited[i]){
                brr[depth] = arr[i];
                visited[i] = true;
                permu(arr, depth+1, brr, visited);
                visited[i] = false;
            }
        }
    }

    //배열더하는 함수
    public static int sum(int []arr){
        int sum =0;
        for(int i =0 ;i<N-1;i++){
            sum += Math.abs(arr[i] - arr[i+1]);
        }
        return sum;
    }
}
