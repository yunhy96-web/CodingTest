import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        long N = Integer.parseInt(st.nextToken()); //N 개보다 많이 만드는 것도 N개 만드는 것에 포함된다.
        int[]arr = new int[K];
        int max = 0;
        int min = 0;
        for(int i = 0; i< K; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        while (max>min){ // max > min 즉 최대가 최소보다 클때는 항상 돌아야한다.
            int mid = (max+min)/2;
            long sum = 0;
            //자투리를 다 더했을 때
            for(int i =0; i<K; i++){
                sum += arr[i] % mid;
            }
            if(sum < N){ //목표치보다 작으면 min을 mid로
                min = mid;
            }else{ //목표치보다 크거나 같으면 max 를 mid로
                max = mid+1;
            }
        }
        System.out.println(min);

    }
}
