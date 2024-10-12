import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_랜선자르기 { //5시 시작
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken()); //만들어야 하는 랜선의 갯수

        int[]list = new int[K];

        long max = 0;
        long min = 1;
        long answer = 0;

        for(int i = 0; i < K; i++){
            list[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, list[i]);
        }
        //자를 수 있는 길이중에 가장 큰 길이를 구해야한다. 그렇기 위해서는 이분탐색을 통해 길이를 구해야한다.
        //이분탐색 로직안에서 여러개의 리스트를 자르는 로직이들어가야함.
        while(min <= max){ //같은 값으로 하는 이유는 두개가 같아졌을때도 잘라야하기 때문이다.
            long mid = (min+max) / 2; //중간 값.
            long count = 0;
            for(int i =0 ;i<K; i++){
                count += list[i] / mid; //전체 몇개로 잘렸는지 나옴
            }
            if(count < N){ // 잘라야하는 랜선의 갯수보다 적은 갯수로 잘렸으면 너무 크게 잘랐다는 뜻임으로 max기준점을 냊춰주어야한다.
                max = mid -1;
            }else{ //잘라야 하는 랜선의 갯수보다 같거나 더 많이 자른경우는 mid를 min+1값으로 옮겨서 한번 더 테스트해본다
                answer = mid; //여기서 먼저 선언이 되어야한다.
                min = mid+1;

            }
        }
        System.out.println(answer);

    }
}
