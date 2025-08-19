package algo.ct.M4_4;

import java.io.*;

public class BOJ_1913_달팽이_S3 {
    static int[][] arr;
    static int N, num;
    static int x, y;

    // 방향: 상, 우, 하, 좌 (반시계 방향)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1]; // 1-based index

        int curX = (N / 2) + 1;
        int curY = (N / 2) + 1;

        int dir = 0; // 방향 인덱스
        int steps = 1; // 몇 칸 이동할지
        int val = 1; // 현재 숫자

        arr[curX][curY] = val;
        if (val == num) {
            x = curX;
            y = curY;
        }

        while (val < N * N) {
            for (int repeat = 0; repeat < 2; repeat++) {
                for (int i = 0; i < steps; i++) {
                    if (val >= N * N) break; // 최대 숫자면 탈출

                    curX += dx[dir];
                    curY += dy[dir];

                    val++;
                    arr[curX][curY] = val;

                    if (val == num) {
                        x = curX;
                        y = curY;
                    }
                }
                dir = (dir + 1) % 4; // 방향 회전
            }
            steps++; // step 수 증가
        }

        // 출력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(x + " " + y);
    }
}
