import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소프티_x위치찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< TC; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String a = st.nextToken();
            String b = st.nextToken();
            //x의 위치를 찾는 로직
            int temp = 0;
            for(int j =0; j<a.length(); j++){
                if(a.charAt(j)=='x' || a.charAt(j)== 'X'){
                    temp = j;
                    break;
                }
            }
            //x의 위치를 찾았으면 해당 temp 로 b에서 찾기
            char ans = b.charAt(temp);
            //문자열 합치기 소문자이면 대문자로 변환해서

            sb.append(ans);
        }
        String result = sb.toString().toUpperCase();
        System.out.println(result);
    }
}
