package main.java.algo.ct.M5_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1987_알파벳_G4 {
    static int R, C, max = 0;
    static boolean check[] = new boolean[26];
    static char arr[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        R = Integer.parseInt(rc[0]);
        C = Integer.parseInt(rc[1]);

        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++)
                arr[i][j] = line.charAt(j); // j번째 문자열 꺼내기
        }

        check[arr[0][0] - 'A'] = true;

        dfs(0, 0, 1);

        System.out.println(max);
    }

    static void dfs(int x, int y, int depth) {
        max = Math.max(max, depth);

        for (int i = 0; i < 4; i++) {
            int currentX = x + dx[i];
            int currentY = y + dy[i];

            if (currentX >= 0 && currentX < R && currentY >= 0 && currentY < C && !check[arr[currentX][currentY] - 'A']) {
                check[arr[currentX][currentY] - 'A'] = true;
                dfs(currentX, currentY, depth + 1);
                check[arr[currentX][currentY] - 'A'] = false;
            }
        }
    }
}
