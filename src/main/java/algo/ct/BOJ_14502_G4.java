package main.java.algo.ct;

import java.util.*;
import java.io.*;

public class BOJ_14502_G4 {
    static int N, M;
    static int[][] arr;
    static int max = 0; // 최대 안전 영역 크기 저장용

    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        makeWall(0); // 벽 3개 세우기 시작
        System.out.println(max);

    }

    // 벽 3개 세우는 모든 경우 탐색 (백트래킹)
    static void makeWall(int count) {
        if (count == 3) { // 벽 3개 다 세워지면 바이러스 확산
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1; // 벽 세우기
                    makeWall(count + 1); // 다음 벽 세우기..
                    arr[i][j] = 0; // 되돌리기 (백트래킹)
                }
            }
        }
    }

    // 바이러스 확산 시뮬 (BFS)
    static void spreadVirus() {
        int[][] temp = new int[N][M]; // 복사용
        for (int i = 0; i < N; i++)
            temp[i] = arr[i].clone(); // 한 줄씩 복사 (깊은 복사처럼..)

        Queue<int[]> q = new LinkedList<>(); // BFS를 위한 큐
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 2) // 바이러스 가능이면..?
                    q.offer(new int[]{i, j});
            }
        }

        // 상, 하, 좌, 우 방향 벡터
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // BFS로 바이러스 퍼뜨리기
        while (!q.isEmpty()) {
            int[] cur = q.poll(); // 현재 위치
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) { // 범위 안에 들어왔다면
                    if (temp[nx][ny] == 0) {
                        temp[nx][ny] = 2; // 바이러스 확산!
                        q.offer(new int[]{nx, ny}); // 새로 퍼진 위치, 큐에 추가
                    }
                }
            }
        }

        countSafeArea(temp);
    }

    // 최대값 갱신
    static void countSafeArea(int[][] temp) {
        int safe = 0;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (temp[i][j] == 0)
                    safe++;

        max = Math.max(max, safe);
    }
}
