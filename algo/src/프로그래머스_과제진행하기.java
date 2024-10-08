import java.util.*;
public class 프로그래머스_과제진행하기 { //1회차 시작
    public static void main(String[] args) {
        String[] answer = solution(new String[][]{
                {"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}
        });
        System.out.println(Arrays.toString(answer));  // 배열 내용을 출력

    }
    public static class Work{

        String name;
        int workingTime;

        public Work(String name, int workingTime){
            this.name = name;
            this.workingTime = workingTime;
        }
    }
    public static String[] solution(String[][] plans) {
        int size = plans.length;
        String[] answer = new String[size];
        Arrays.sort(plans,(o1,o2)->{ //시작 시간으로 오름차순 정렬.
            return o1[1].compareTo(o2[1]);
        });
        Stack<Work> stack = new Stack<>(); //작업중인거 넣을 스택
        int prevTime = 0; // 현재 바라보는 시간
        int answerIndex = 0;
        for(int i = 0 ; i < size ; i++){
            String[] plan = plans[i];
            // System.out.println(Arrays.deepToString(plan));
            String name = plan[0];
            int startTime = stringToTime(plan[1]); //시간형식을 인트형식으로 변환
            int workingTime = stringToTime(plan[2]); //나중에 비교를 위함
            while(!stack.empty()){//스택이 비어있지 않을때 = 작업중인게 있을때.
                Work prevWork = stack.pop(); //그 전에 작업하던 내역
                int endTime = prevTime + prevWork.workingTime;
                if(endTime <= startTime){ //시간이 안 겹칠때 - 스택에 대기중인 작업과 새로운 작업이 안겹칠때
                    answer[answerIndex++] = prevWork.name;
                    prevTime += prevWork.workingTime;// 브레이크를 안거는 이유는 다음 작업이랑 또 비교해야함
                }else{ // 시간이 겹칠때 - 스택에 대기중인 작업과 새로운 작업이 겹칠때
                    stack.push(new Work(prevWork.name, prevWork.workingTime - (startTime - prevTime)));
                    break; //지금 작업 중단 후 스택으로 쌓음
                }
            }
            stack.push(new Work(name,workingTime));//스택에 아무것도 없을때. = 작업중인게 없을 때.
            prevTime = startTime;
        }
        while(!stack.empty()){
            answer[answerIndex++] = stack.pop().name;
        }
        return answer;
    }
    private static int stringToTime(String str){
        String[] temp = str.split(":");
        int result = 0;
        if(temp.length == 2){
            result = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
        }else{
            result = Integer.parseInt(str);
        }
        return result;
    }
}
