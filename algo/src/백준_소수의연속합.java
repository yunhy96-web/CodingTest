import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 백준_소수의연속합 {
    private static ArrayList<Integer>arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int aimNumber = Integer.parseInt(br.readLine());
        boolean[] num = new boolean[aimNumber + 1];
        //소수가 아닌것들은 true 로 바꾸는 로직을 짜야함.
        //반복의 가운데는 제곱근을 기준으로 한다.
        //일단 소수가 아닌것들은 true 표시, 소수인것들은 false로 남아있음
        num[0] = true;
        num[1] = true;
        for (int i = 2; i * i <= aimNumber; i++) {
            for (int j = i * i; j <= aimNumber; j = j + i) {
                num[j] = true;
            }
        }
        //arr list에 소수들 다 넣음
        for(int i = 0; i<num.length; i++){
            if(!num[i]) arr.add(i);
        }
        //아래 로직은 가짓수를 체크하는 로직
        int start = 0;
        int end = 0;
        int sum =0;
        int count =0;
        while (true){
            if(sum<aimNumber && end < arr.size()){ //부족할 경우
                sum+=arr.get(end);
                end++;
            }else if(start == arr.size()){
                break;
            }else { // 합친게 같거나 목표치를 넘긴경우
                if(start == end){ //위치가 일치하면 그만둬야함. 스타트를 올리는 순간 위치가 반대로 되어버림
                    break;
                }
                sum -= arr.get(start);
                start++;
            }
            if(sum == aimNumber){
                count++;
            }

        }
        System.out.println(count);

    }
}
