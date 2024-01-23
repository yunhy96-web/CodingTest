import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int []arr = new int[N];
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
}
