import java.util.*;
import java.io.*;
public class 백준_카드2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer>que = new LinkedList<>();
        for(int i = 1; i<= N; i++){
            que.add(i);
        }
        while (true){
            if(que.size() == 1){
                break;
            }
            que.poll();
            if(que.size() == 1){ //2일 경우 떄문에 한번더 검증
                break;
            }
            int temp = que.poll();
            que.add(temp);
        }
        System.out.println(que.peek());
    }
}
