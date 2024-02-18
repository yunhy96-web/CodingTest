import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class 백준_패션왕신예빈 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0 ;i<t; i++){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for(int j =0; j<n; j++){
                String cloth = br.readLine();
                //여기에 로직
                StringTokenizer st = new StringTokenizer(cloth, " "); //띄어쓰기로 나누었음
                st.nextToken(); //같은 이름을 가진 의상은 존재하지 않는다.
                String clothType = st.nextToken();
                map.put(clothType, map.getOrDefault(clothType, 0)+1);
                int result = 1;
                for(int count : map.values()){
                    result *= (count+1);
                }
                System.out.println(result-1);

            }
        }
    }
}
