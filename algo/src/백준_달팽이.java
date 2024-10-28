import java.io.*;
import java.util.*;

public class 백준_달팽이 {
    private static int[] dx = {1, 0, -1, 0}; // 하, 우, 상, 좌
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int where = Integer.parseInt(br.readLine());
        int aim = n * n; // 시작 숫자

        int startX = 0, startY = 0;
        int direction = 0; // 초기 방향: 아래로 이동
        int targetX = 0, targetY = 0; // 목표 숫자 위치 저장용

        while (aim > 0) {
            arr[startX][startY] = aim; // 현재 위치에 숫자를 채운다.

            // 목표 숫자를 찾은 경우 위치 저장
            if (aim == where) {
                targetX = startX;
                targetY = startY;
            }

            // 다음 좌표 계산
            int nextX = startX + dx[direction];
            int nextY = startY + dy[direction];

            // 배열 범위를 벗어나거나 이미 채워진 경우 방향 전환 , 못가는 경우를 뜻함
            if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n || arr[nextX][nextY] != 0) {
                direction = (direction + 1) % 4; // 다음 방향으로 전환
                nextX = startX + dx[direction];
                nextY = startY + dy[direction];
            }

            // 다음 위치로 이동
            startX = nextX;
            startY = nextY;
            aim--; // 채워야 할 숫자를 줄인다
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append((targetX + 1) + " " + (targetY + 1)); // 목표 위치 출력 (1-indexed)
        System.out.print(sb);
    }
}
