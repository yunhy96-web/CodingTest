import java.util.*;
import java.io.*;

public class 백준_문자열 { //오후 8시 21분
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); //koder topcoder
        String a = st.nextToken();
        String b = st.nextToken();
        int min = Integer.MAX_VALUE;
        int t = b.length() - a.length() + 1; //서로 동일한 문자열일때도 이게 동작하나?
        for(int i =0 ;i<t; i++){
           String temp = b.substring(i, i+a.length());
           int m = compare(a, temp);
           min = Math.min(min, m);
        }
        System.out.println(min);
    }
    private static int compare(String a , String temp){
        //서로 문자가 몇개가 다른지 
        int count = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=temp.charAt(i)){
                count++;
            }
        }
        return count;
    }
}
