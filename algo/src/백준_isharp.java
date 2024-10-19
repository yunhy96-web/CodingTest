import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 백준_isharp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String target = br.readLine();
        String newTarget = target.replace(target.charAt(target.length()-1), ',');
        String[]slice = newTarget.split(" ");

        List<String>list = new ArrayList<>();
        for(int i =1; i< slice.length; i++){ //1부터 시작하는 이유는 기준이 되는 가장 앞은 빼두기 위해
            //뒤에있는 ',' 삭제 하기 위해 가장위에서 ';' 를 ','로 치환시키는 작업해야함 가장 처음 입력받았을때
            //slice[i];
            String first = slice[0]; //이 배열안에서 초기화
            String newSlice = slice[i].substring(0, slice[i].length()-1);
            //여기서부터 거꾸로 first에 붙인다.
            for(int j = newSlice.length()-1; j>= 0; j--){
                if(((int)newSlice.charAt(j)>=97 && (int)newSlice.charAt(j) <= 122) || ((int)newSlice.charAt(j)>=65 && (int)newSlice.charAt(j) <= 90)){
                    //알파벳이라면 공백하나 넣음 이때 그 전값이 알파벳이면 띄어쓰기안하고 넣는다.
                    if (!Character.isLetter(first.charAt(first.length() - 1))) {
                        first = first + " " + newSlice.charAt(j);
                    }else {
                        first = first + "" + newSlice.charAt(j);

                    }
                }//91 = [ 93 = ]
                else if((int)newSlice.charAt(j) == 91){ //[ 일 경우
                    first = first + (char)93;
                }
                else if((int)newSlice.charAt(j) == 93){ //]
                    first = first + (char)91;
                }
                //그 외의 경우는 그냥 붙임
                else{
                    first = first + newSlice.charAt(j);
                }
            }

            //만들어낸 답을 리스트에 넣는다.
            list.add(first);
        }

        for(String a:list){
            System.out.println(a+';');
        }

    }
}
//int& a*[]&, abvb, ccc*;
//int&&[]* a;
//int& b;
//int&* c;
//
//