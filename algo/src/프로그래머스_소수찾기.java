import java.util.*;

public class 프로그래머스_소수찾기 { //2회차
    static boolean chk[];
    static ArrayList<Integer>arr = new ArrayList<>();

    public static void main(String[] args) {
        int finalAnswer=0;
        finalAnswer = solution("189");
        System.out.println("나올 수 있는 소수의 갯수"+ finalAnswer);
    }

    public static int solution(String numbers){
        int answer = 0;
        chk = new boolean[numbers.length()];
        for(int i =0; i<numbers.length(); i++){
            dfs(numbers, "", i+1);
        }
        for(int i =0; i<arr.size(); i++){
            if(prime(arr.get(i))){
                answer++;
            }
        }

        return answer;
    }

    static void dfs(String str , String temp, int m){
        if(temp.length() == m){
            int p = Integer.parseInt(temp);
            if(!arr.contains(p)){
                arr.add(p);
            }
            return;
        }

        for(int i =0 ;i< str.length(); i++){
            if(!chk[i]){
                chk[i] = true;
                dfs(str, temp+str.charAt(i), m);
                chk[i] = false;
            }
        }

    }

    static boolean prime(int n){
        if(n<2) return false;
        if(n==2) return true;
        if(n%2 ==0) return false;
        for(int i = 3; i*i <= n; i= i+2){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

}
