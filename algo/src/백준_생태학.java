import java.util.*;
import java.io.*;

public class 백준_생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int count = 0;
        String s;

        // 입력 받기
        while ((s = br.readLine()) != null) {
            count++;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // map 정렬 (키를 리스트에 추가)
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getKey());
        }

        // 출력 테스트 (정렬된 리스트 출력)
        Collections.sort(list); // 사전 순으로 정렬
        for (String key : list) {
            double percentage = (map.get(key) * 100.0) / count;
            System.out.printf("%s %.4f\n", key, percentage);
        }
    }
}
