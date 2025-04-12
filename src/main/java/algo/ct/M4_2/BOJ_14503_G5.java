package main.java.algo.ct.M4_2;

import java.io.*;
import java.util.*;

public class BOJ_14503_G5 {

    static int N, M;
    static int[][] arr;
    static int r, c, d; // 좌표 & 방향
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken()); // 0: 북, 1: 동, 2: 남, 3: 서

        // 방 배열 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                arr[i][j] = (Integer.parseInt(st.nextToken()));
        }

        // 북 동 남 서
        int[] dx = {-1, 0, 1, 0};  // 행의 변화 (x: 세로 방향)
        int[] dy = {0, 1, 0, -1};  // 열의 변화 (y: 가로 방향)

        while (true) {
            // 1. 현재 칸 감소
            if (arr[r][c] == 0) {
                arr[r][c] = 2; // 청소 표시
                count++;
            }

            boolean moved = false;

            // 2. 4방향 탐색
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 왼쪽으로 회전
                int nx = r + dx[d];
                int ny = c + dy[d];

                // 청소되지 않은 곳이라면
                if (arr[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    moved = true;
                    break;
                }

            }
            // 3. 청소할 곳 없으면 후진
            if (!moved) {
                int back = (d + 2) % 4;
                int bx = r + dx[back];
                int by = c + dy[back];

                if (arr[bx][by] == 1) break; // 벽이면 종료
                r = bx;
                c = by;
            }
        }

        System.out.println(count);
    }
}
