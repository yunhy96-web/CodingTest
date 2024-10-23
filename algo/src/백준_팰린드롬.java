import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        //System.out.println(temp.substring(0,4));//abab 기준 bab
        int index = 0;
        int answer = 0;
        while (index <= temp.length()){
            String s = temp.substring(index, temp.length());
            if(palin(s)){ //중간으로 잘랐을 시 앞뒤가 같으면 현재 자른 index만큼 length 에 index를 더해준다 그 뒤 바로 break
                answer= index+temp.length();
                break;
            }
            index++;
        }
        System.out.println(answer);
    }
    private static boolean palin(String s){
        //앞뒤 잘랏을때 하나라도 다르면 false 리턴 후에 함수 종료
        int start = 0;
        int end = s.length()-1;
        while (start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;

    }
}
