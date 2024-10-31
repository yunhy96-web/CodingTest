import java.io.*;
import java.util.*;

public class 백준_그룹단어체커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            Map<Character, Integer> map = new HashMap<>();
            boolean isGroupWord = true;

            // 첫 문자는 무조건 그룹 단어의 일부로 간주하여 맵에 넣습니다.
            map.put(temp.charAt(0), 1);

            for (int j = 1; j < temp.length(); j++) {
                if (temp.charAt(j - 1) != temp.charAt(j)) {
                    // 이전 문자와 다를 때만 체크
                    if (map.getOrDefault(temp.charAt(j), 0) == 1) {
                        // 이미 등장한 문자라면 그룹 단어가 아님
                        isGroupWord = false;
                        break;
                    }
                    // 등장하지 않은 문자면 추가
                    map.put(temp.charAt(j), 1);
                }
            }
            if (isGroupWord) {
                count++;
            }
        }
        System.out.println(count);
    }
}
