import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 백준_크면서작은수 { //오후 7시19분
    private static String target;
    private static String target2;
    private static int len = 0;
    private static boolean[]visit;
    private static ArrayList<String>list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine();
        len = target.length(); // 숫자 156을 입력받으면 만들수 있는 수들중에 그 다음 큰수를 출력해야함. 만약에 없으면 0을 출력
        visit = new boolean[len];
        //인트 배열을 만들어서 거기에 하나씩 넣어준다.
        int []arr = new int[len];
        for(int i =0; i< len; i++){
            arr[i] = target.charAt(i) - '0';
        }
        Arrays.sort(arr); //오름차순으로 정렬을 먼저해주고
        StringBuilder sb= new StringBuilder();
        for(int i = 0;i<len; i++){
            sb.append(arr[i]);
        }
        target2 = sb.toString();

        //퍼뮤테이션 즉 순열을 해준다. 뽑는 숫자는 len 만큼 뽑는다. visit배열 필요.
        permu(0, len,new StringBuilder());
        //그리고 나온 순열들을 어레이 리스트를 생성해서 싹다넣음.
        //어레이리스트에서 하나씩 뺴와서 비교하면서 기준값 target보다 더 큰수가 나오면 그걸 답으로 출력함. ///안나오면 0을 리턴한다.
        if(list.size() > 0){
            System.out.println(list.get(0));
        }else {
            System.out.println(0);
        }

    }
    private static void permu(int nowIndex, int depth, StringBuilder temp){
        if(nowIndex == depth){
            if(Integer.parseInt(temp.toString()) > Integer.parseInt(target)) { // 현재값보다 더 크면
                list.add(temp.toString());
            }
            return;
        }else{
            for(int i = 0; i < len; i++){
                if(!visit[i]){
                    visit[i] = true;
                    temp.append(target2.charAt(i)); // 문자 추가
                    permu(nowIndex + 1, depth, temp); // 재귀 호출
                    temp.deleteCharAt(temp.length() - 1); // 마지막 문자 제거
                    visit[i] = false; // visit 복구
                }
            }
        }
    }

}
