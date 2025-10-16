package algo.ct.M10;
//https://www.acmicpc.net/problem/2461
//5:40~

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2461_대표선수_G2 {
    static int n, m;
    static int[][] arr;

    static class Node {
        int score; //점수
        int classNum; // 반 번호
        int idx; // 그 반에서 몇 번째 학생인지

        Node (int score, int classNum, int idx) {
            this.score = score;
            this.classNum = classNum;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++)
            Arrays.sort(arr[i]);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.score - b.score);
        int max = Integer.MIN_VALUE;

        // 각 반의 첫 번째 학생 삽입
        for (int i = 0; i < n; i++) {
            pq.add(new Node(arr[i][0], i, 0));
            max = Math.max(max, arr[i][0]);
        }

        int minDiff = Integer.MAX_VALUE;

        // 최소값을 꺼내며 구간 갱신
        while (true) {
            Node cur = pq.poll(); // 현재 최소값
            int diff = max - cur.score;
            minDiff = Math.min(minDiff, diff);

            // 다음 학생이 없으면 종료
            if (cur.idx + 1 == m)
                break;

            // 다음 학생 삽입
            int next = arr[cur.classNum][cur.idx + 1];
            pq.add(new Node(next, cur.classNum, cur.idx + 1));
            max = Math.max(max, next);
        }

        System.out.println(minDiff);
    }
}
