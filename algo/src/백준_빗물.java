import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[]map = new int[W];

        st = new StringTokenizer(br.readLine());
        for(int i =0 ;i<W; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        //해당 인덱스를 기준으로 좌측의 최대값과 우측의 최대값을 찾아야함, 양쪽이 현재 인덱스보다 커야함. 그렇지 않으면 다음반복으로.
        int curIndex = 0;
        int sum = 0;
        while (true){
            if(curIndex ==0){ //가장 왼쪽일때는 없으니까 바로 넘김
                curIndex++;
                continue;
            }
            if(curIndex == map.length){
                break;
            }
            //현재 인덱스 기준 왼쪽/오른쪽 영역에서 curIndex 보다 큰 최대값 찾기 -- 0이거나 현재 인덱스의 밸류와 작거나 같거나 없는 경우는 continue
            int leftMax = 0;
            for(int i =0 ;i<curIndex; i++){
                leftMax = Math.max(leftMax, map[i]);
            }
            if(leftMax ==0 || leftMax <= map[curIndex] ){
                curIndex++;
                continue;
            }
            //이제 오른쪽 영역에서 최대값을 찾아야함
            int rightMax = 0;
            for(int i=curIndex; i<map.length; i++){
                rightMax = Math.max(rightMax, map[i]);
            }
            if(rightMax ==0 || rightMax <= map[curIndex]){
                curIndex++;
                continue;
            }
            //그 뒤 좌측 우측 최대값중에 작은 걸 뽑는다. 그 다음 그 값과 현재 인덱스의 값을 빼준다. 그 값을 sum  변수에 추가.

            int real = Math.min(leftMax, rightMax);
            sum += (real-map[curIndex]);
            curIndex++;

        }
        System.out.println(sum);
    }
}
