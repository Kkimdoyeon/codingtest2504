package main.java.algo.ct;

import java.util.*;

public class BOJ_16236_G3 {

    // 공간 크기, 시간, 상어 크기, 먹은 물고기 수
    static int N, time = 0, size = 2, eat = 0;
    static int[][] map; // 공간 정보
    static boolean[][] visited; // 방문 여부 체크

    // 방향 배열 (상, 좌, 우, 하) — 우선순위와 연관 있음
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    static Shark shark; // 아기 상어 객체

    // 상어 클래스 (현재 위치 저장)
    static class Shark {
        int x, y;
        Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 물고기 클래스 (비교를 위해 Comparable 구현)
    static class Fish implements Comparable<Fish> {
        int x, y, dist;
        Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        // 우선순위 정렬 기준: 거리 → 위쪽 → 왼쪽
        @Override
        public int compareTo(Fish f) {
            if (this.dist == f.dist) {
                if (this.x == f.x) return this.y - f.y;
                return this.x - f.x;
            }
            return this.dist - f.dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 공간 크기 입력
        map = new int[N][N];

        // 공간 정보 입력 및 아기 상어 위치 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    shark = new Shark(i, j); // 상어 위치 저장
                    map[i][j] = 0; // 상어 위치를 빈칸으로 처리
                }
            }
        }

        // 더 이상 먹을 수 있는 물고기가 없을 때까지 반복
        while (true) {
            Fish fish = bfs(); // 가장 가까운 먹을 수 있는 물고기 탐색
            if (fish == null) break; // 없으면 종료

            time += fish.dist; // 이동 거리만큼 시간 추가
            shark.x = fish.x;  // 상어 위치 갱신
            shark.y = fish.y;
            map[fish.x][fish.y] = 0; // 먹은 자리는 빈칸 처리
            eat++; // 먹은 물고기 수 증가

            // 크기만큼 먹었으면 크기 증가
            if (eat == size) {
                size++;
                eat = 0;
            }
        }

        // 결과 출력: 총 이동 시간
        System.out.println(time);
    }

    // BFS로 먹을 수 있는 가장 가까운 물고기 찾기
    static Fish bfs() {
        visited = new boolean[N][N]; // 방문 초기화
        Queue<int[]> queue = new LinkedList<>(); // BFS용 큐
        PriorityQueue<Fish> fishes = new PriorityQueue<>(); // 먹을 수 있는 물고기 후보들

        // 상어 현재 위치에서 시작
        queue.offer(new int[]{shark.x, shark.y, 0});
        visited[shark.x][shark.y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 범위 밖 or 방문했거나 상어보다 큰 물고기면 못 감
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny] || map[nx][ny] > size) continue;

                visited[nx][ny] = true; // 방문 처리

                // 먹을 수 있는 물고기면 후보 큐에 추가
                if (map[nx][ny] != 0 && map[nx][ny] < size) {
                    fishes.offer(new Fish(nx, ny, dist + 1));
                }

                // 이동 가능한 위치이므로 큐에 추가
                queue.offer(new int[]{nx, ny, dist + 1});
            }
        }

        // 먹을 수 있는 물고기 중 가장 우선순위 높은 것 반환
        return fishes.isEmpty() ? null : fishes.poll();
    }
}
