import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String temp = br.readLine();
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < temp.length(); j++) {
                char a = temp.charAt(j);

                if (Character.isDigit(a)) {
                    sb.append(a);
                } else {
                    if (sb.length() > 0) {
                        int number = Integer.parseInt(sb.toString());
                        answer.add(number);
                        sb = new StringBuilder();
                    }
                }
            }
            // 끝에 숫자가 있을 경우 마지막 숫자 추가
            if (sb.length() > 0) {
                int number = Integer.parseInt(sb.toString());
                answer.add(number);
            }
        }

        Collections.sort(answer);

        for (int num : answer) {
            System.out.println(num);
        }
    }
}
