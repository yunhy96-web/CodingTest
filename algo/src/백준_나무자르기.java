import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_나무자르기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer stt = new StringTokenizer(br.readLine()," ");
        int[]arr =new int[N];
        int max = Integer.MIN_VALUE;
        int min = 0;
        for(int i = 0; i< N; i++){
            arr[i] = Integer.parseInt(stt.nextToken());
            if(max<arr[i]){
                max = arr[i];
            }//if(min>arr[i]){
//                min = arr[i];
//            }
        }
        while (min<max){
            int mid =(max + min)/2;
            long sum = 0;

            for (int j = 0; j < N; j++){
                if(arr[j] - mid > 0){
                    sum += arr[j] - mid;
                }
            }
            if(sum < M){ // 자른나무의 합이 M 보다 작다는 뜻 -> 자르는 나무의 높이를 내려야한다는 뜻 -> 그러면 max 에 mid 를 넣어야한다
                max = mid;
            }else{ //자른 나무의 합이 M보다 크다는 뜻 -> 높이를 높여야 한다 -> 추가로 같을 경우에는 최대한 작게 자르기 위해  높이를 높여야한다.
                min = mid +1;
            }

        }
        System.out.println(min -1);
    }
}