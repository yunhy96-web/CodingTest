import java.io.*;
import java.util.*;

public class 백준_약수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if(N == 1 && K == 1){
            System.out.println(1);
            return;
        }
        //N의 약수를 구해서 싹다 list에 넣어버린다.
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(N); i++){
            if(N % i == 0) { // 나누어 떨어지면 i는 약수라는 뜻, 짝이되는 얘도 추가함
                list.add(i);
                if(i != N / i) { // i와 N / i가 다르면 짝이 되는 약수도 추가
                    list.add(N / i);
                }
            }
        }
        // Collections.sort 를 사용
        Collections.sort(list);
        // list.get(K-1)한다.
        if(K > list.size()) { // K 값이 리스트 크기보다 더 크면 0
            System.out.println(0);
        } else {
            System.out.println(list.get(K - 1));
        }
    }
}
