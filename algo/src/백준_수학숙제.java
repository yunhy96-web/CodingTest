import java.io.*;
import java.math.BigInteger;
import java.util.*;

/* 예시
01bond
02james007
03bond
04austinpowers000
*/
public class 백준_수학숙제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        List<BigInteger> answer = new ArrayList<BigInteger>();
        for (int i = 0; i < M; i++) {// 여기서 하나씩 뽑아서 숫자 배열에 넣어야한다.
            String temp = br.readLine();
            //Character.isDigit 이라는 함수사용 : 이게 숫자인지 아닌지 판별하는 함수임
            StringBuilder sb = new StringBuilder();

            for(int j =0; j<temp.length(); j++){
                char a = temp.charAt(j);

                if(Character.isDigit(a)){
                    sb.append(a);
                }else {
                    if(sb.length()>0){
                        answer.add(new BigInteger(sb.toString()));
                        sb = new StringBuilder();
                    }
                }
            }

            if(sb.length()>0){
                answer.add(new BigInteger(sb.toString()));
            }
        }
        Collections.sort(answer);
        for(BigInteger num : answer){
            System.out.println(num);
        }
    }
}
