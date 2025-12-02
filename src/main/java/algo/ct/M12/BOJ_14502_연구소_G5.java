package algo.ct.M12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소_G5 {
    static int N, M;
    static int[][] arr;
    static int[][] tmpArr;
    static int maxSafe = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 0은 빈 칸, 1은 벽, 2는 바이러스
    public static void main(String[] args) throws IOException {
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

        // 벽은 3개까지
        // 3개의 벽을 만들 수 있는 조합? 만들기
        setWall(0);
        // 그 벽의 조합일 때 바이러스 뿌리기
        // 안전 영역 Math.max해서 최댓값 찾기
        System.out.println(maxSafe);
    }

    static void setWall(int count) {
        if (count == 3) {
            getVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    setWall(count + 1);
                    arr[i][j] = 0; // 백트래킹
                }
            }
        }
    }

    static void getVirus() {
        tmpArr = new int[N][M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                tmpArr[i][j] = arr[i][j];

        Queue<int[]> q = new LinkedList<>();

        // 바이러스 시작점들 큐에 넣기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmpArr[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (tmpArr[nx][ny] != 0)
                    continue;

                tmpArr[nx][ny] = 2;
                q.add(new int[]{nx, ny});
            }
        }

        // 안전 영역 계산
        int safe = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (tmpArr[i][j] == 0) safe++;

        maxSafe = Math.max(maxSafe, safe);
    }

}
