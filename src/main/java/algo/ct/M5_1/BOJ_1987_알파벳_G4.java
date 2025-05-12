package main.java.algo.ct.M5_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1987_알파벳_G4 {
    static int R, C, max = 0;
    static char[][] board;
    static boolean[] visited = new boolean[26]; // 알파벳 A~Z

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        R = Integer.parseInt(rc[0]);
        C = Integer.parseInt(rc[1]);

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        visited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(max);
    }

    static void dfs(int x, int y, int depth) {
        max = Math.max(max, depth);

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                char nextChar = board[nx][ny];
                if (!visited[nextChar - 'A']) {
                    visited[nextChar - 'A'] = true;
                    dfs(nx, ny, depth + 1);
                    visited[nextChar - 'A'] = false;
                }
            }
        }
    }
}
