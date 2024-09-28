import java.util.Arrays;
import java.util.Stack;

public class 프로그래머스_과제진행하기연습용 {
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
        Arrays.sort(plans, (o1, o2) -> { //시간 순서대로 정렬함.
            return o1[1].compareTo(o2[1]);
        });
        Stack<Work> stack = new Stack<>();
        int prevTime = 0;
        int answerIndex = 0;
        for(int i = 0; i< size; i++){
            String[] plan = plans[i];
            String name = plan[0];
            int startTime = stringToTime(plan[1]);
            int workingTime = stringToTime(plan[2]);
            while(!stack.empty()){
                Work prevWork = stack.pop();
                int endTime = prevTime + prevWork.workingTime;
                if(endTime <= startTime){// 밀린작업 끝나는 시간이 1시, 새로운작업시작시간이 3시
                    answer[answerIndex++] = prevWork.name;
                    prevTime += prevWork.workingTime;
                }else { //밀린작업 끝나는시간이 3시 새로운 작업시작시간이 1시
                    stack.push(new Work(prevWork.name, prevWork.workingTime - (startTime - prevTime)));
                    break;
                }
            }
            stack.push(new Work(name, workingTime));
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
