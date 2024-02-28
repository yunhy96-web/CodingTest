import java.io.*;
import java.util.*;

public class 백준_암호만들기 {
    private static char[] key;
    private static boolean[] visit;
    private static int L = 0;
    private static int C = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken()); //만들어야 할 암호 자리수
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        key = new char[C];
        visit = new boolean[C];
        for (int i = 0; i < C; i++) {
            key[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(key);
        char[] secret = new char[L];
        combi(0, secret, 0);
    }

    private static void combi(int depth, char[] secret, int next) {
        if (depth == L) {
            //암호키가 생김
            if (isValid(secret)) {
                for (int i = 0; i < L; i++) {
                    System.out.print(secret[i]);
                }
                System.out.println();
            }
            return;

        }
        for (int i = next; i < C; i++) {
            if (!visit[i]) {
                secret[depth] = key[i];
                visit[i] = true;
                combi(depth + 1, secret, i + 1);
                visit[i] = false;
            }
        }
    }

    private static boolean isValid(char[] secret) {
        int moCount = 0;
        int jaCount = 0;
        for (int i = 0; i < secret.length; i++) {
            if (secret[i] == 'a' || secret[i] == 'e' || secret[i] == 'i' || secret[i] == 'o' || secret[i] == 'u') {
                moCount++;
            } else {
                jaCount++;
            }
        }
        if (moCount >= 1 && jaCount >= 2) {
            return true;
        }
        return false;
    }
}
