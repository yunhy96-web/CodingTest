import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_안정적인문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 0;
        int count = 0;
        while (true){
            index++;
            String s = br.readLine();
            if(s.contains("-")){
                break;
            }
            //stack을 생성한다.
            Stack<Character>stack = new Stack<>();
            stack.push(s.charAt(0));
            for(int i =1; i<s.length(); i++){
                if(!stack.isEmpty()){
                    char t = stack.peek();
                    if(t=='{'){ // }{ -> }} -> {{ 결국 스택에 쌓일때 {{ 모양으로 싹다만들어줘야한다.
                        // 스택이 비어있을 경우 { 가 들어오면 } 로 스택에 넣어준다.
                        if(s.charAt(i) == '{'){
                            stack.push(s.charAt(i));
                        }else if(s.charAt(i) == '}'){
                            stack.pop();
                        }
                    }else if(t=='}'){ //이미 {} 한쌍으로 묶이면 스택이 빌수밖에 없음. peek을해서 } 가 남앗다는 뜻은 맞는쌍이없다는뜻임
                        stack.push(s.charAt(i));//}}}} -> } 이 들어왔을 경우는 {로 스택에 넣어야한다.
                    }
                }
            }
            System.out.println(index+". "+stack.size());
        }
    }
}
