import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_A부터B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int count = 1; // B에서 시작해서 A로 가는 연산 횟수 (B를 이미 포함하고 있으므로 1부터 시작)
        while (B > A) {
            if (B % 2 == 0) {
                B /= 2;
            } else if (B % 10 == 1) {
                B /= 10;
            } else {
                break; // 위의 두 조건에 해당하지 않으면 A로 변환할 수 없음
            }
            count++;
        }

        if (B == A) {
            System.out.println(count);
        } else {
            System.out.println(-1); // A로 변환할 수 없는 경우
        }
    }
}
