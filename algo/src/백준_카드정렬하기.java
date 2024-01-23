import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class 백준_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> que = new PriorityQueue<>();
        for(int i =0; i<N; i++){
            que.add(Integer.parseInt(br.readLine())); //우선순위 큐에 하나씩 넣어준다.
        }
        //우선순위대로 즉 가장 작은 숫자부터 2개 뽑아서 sum에 더하고 다시 그 sum 값을 넣어준다
        //이렇게 하면 2개뽑고 1개 넣는 과정을 반복하게 되고
        //마지막에는 2개 뽑으면 큐가 비는 상황이 만들어진다.
        int sum = 0;
        while (que.size()>1){ //이부분이 que.isEmpty가 아닌 이유에 대해 설명.
            sum += (que.poll()+ que.poll());
            que.add(sum);
        }
        System.out.println(sum);
    }
}
