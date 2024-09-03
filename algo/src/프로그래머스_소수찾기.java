import java.util.*;

public class 프로그래머스_소수찾기 {

    static ArrayList<Integer> arr = new ArrayList<>();
    static boolean[] check = new boolean[7];

    public static void main(String[] args) {
        int myans = solution("189");
        System.out.println("소수의 개수: " + myans);
    }

    public static int solution(String numbers) {
        int answer = 0;
        for(int i = 0; i < numbers.length(); i++) {
            dfs(numbers, "", i + 1); //1개 뽑을 때, 2개뽑을 때, 3개 뽑을 때
        }

        for(int i = 0; i < arr.size(); i++) {
            if(prime(arr.get(i))) {
                answer++;
            }
        }

        return answer;
    }

    //백트래킹
    static void dfs(String str, String temp, int m) {
        if(temp.length() == m) {
            int num = Integer.parseInt(temp);
            if(!arr.contains(num)) {  // 중복 체크
                arr.add(num);          // 중복되지 않은 숫자만 리스트에 추가
            }
        }

        for(int i = 0; i < str.length(); i++) {
            if(!check[i]) {
                check[i] = true;
                dfs(str, temp + str.charAt(i), m);  // 새로운 문자열을 생성하여 재귀 호출
                check[i] = false;  // 상태 복원 (check 배열만 복원)
            }
        }
    }


    //소수 판단
    static boolean prime(int n) {
        if(n < 2) return false; //0,1 은 아에 소수가 아님
        if(n == 2) return true;  // 2는 소수
        if(n % 2 == 0) return false;  // 짝수는 소수가 아님

        for(int i = 3; i * i <= n; i=i+2) {
            if(n % i == 0) return false;
        }

        return true;
    }
}
