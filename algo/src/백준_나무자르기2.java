import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_나무자르기2 {
    private static long min = 1;
    private static long max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); //m 만큼을 가지고 나가야한다. 그중에서 자를수 있는 최대 높이를 구해야함.
        int []arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max){
                max = arr[i];
            }
        }
        long answer = 0;
        while (min <= max){
            long cnt = 0;

            long mid = (min + max)/2;
            for(int j = 0; j < n; j++){
                if (arr[j] > mid) {
                    cnt += arr[j] - mid;
                }
            }
            if(cnt < m){ // 이 뜻은 너무 높게 자름. 낮게 설정 가능
                max = mid-1;
            }else { // cnt >= m 충분히 자른 상태. -> 절단기를 더 높게 설정가능
                answer = mid;
                min = mid+1;
            }
        }
        System.out.println(answer);

    }
}

//4 7
//20 15 10 17
