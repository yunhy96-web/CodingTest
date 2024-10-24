import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_이진수 { //오후 8시45분
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<TestCase; i++){ // 13 이면 0 2 3 1101 인가 1 + 4 + 8 이니까
            int target = Integer.parseInt(br.readLine());
            int index = 0;
            String n = make2(target, index, new StringBuilder());
            sb.append(n);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static String make2(int target,int index, StringBuilder sb){
        if(target == 0){
            return sb.toString();
        }

        if(target%2 ==1){
            sb.append(index+" ");
        }

        return make2(target/2, index+1, sb);

    }
}

//13
// 2 6 1
// 2 3 0
// 2 1 1
// 2 0 1
//리스트에 위에서부터 차례대로 넣는다 몫이 0이 될때까지 반복한다