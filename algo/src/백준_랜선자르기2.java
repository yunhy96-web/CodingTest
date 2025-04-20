import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_랜선자르기2 {

    private static long max = Integer.MIN_VALUE;
    private static long min = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); // 이만큼의 양이 나와야한다. 그중 가장 큰 값.
        int [] arr = new int[n];

        for(int i =0; i<n; i++){
            int target = Integer.parseInt(br.readLine());
            arr[i] = target; // 일단 값들은 다 저장해두고 가장 작은 값은 따로 뺴냄.
            //여기서 이제 자르는 로직 , 가장 작은 값부터
            if(target > max){
                max = target;
            }
        }
        //여기서 이제 이분탐색 돌려서 가장 높은 값이 나오는지 확인해야함.
        long answer = 0;
        while (min<=max){
            long mid = (max+min)/2;
            long cnt = 0;
            for(int i =0; i<n; i++){
                cnt += arr[i]/mid;
            }
            if(cnt < m){
                max = mid-1;
            }
            else {
                answer = mid;
                min = mid+1;
            }
        }
        System.out.println(answer);
    }
}


//4 11
//802
//743
//457
//539