package main.java.algo.ct.M4_1;
import java.io.*;
import java.util.*;

public class BOJ_11505 {
    static int N, M, K;
    static long[] arr, tree;
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 세그먼트 트리 크기 계산 및 초기화
        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = 1 << (h + 1);
        tree = new long[treeSize];

        init(1, 0, N - 1); // 세그먼트 트리 초기화

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                // a가 1이면 b번째 수를 c로 변경
                update(1, 0, N - 1, b - 1, c);
            } else {
                // a가 2이면 b부터 c까지의 곱을 출력
                sb.append(query(1, 0, N - 1, b - 1, c - 1)).append("\n");
            }
        }

        System.out.print(sb);
    }

    // 세그먼트 트리 초기화 함수
    static long init(int node, int start, int end) {
        if (start == end) return tree[node] = arr[start] % MOD;
        int mid = (start + end) / 2;
        // 왼쪽 자식 * 오른쪽 자식의 곱으로 부모 노드 값 설정
        return tree[node] = (init(node * 2, start, mid) * init(node * 2 + 1, mid + 1, end)) % MOD;
    }

    // 값 변경 함수 (b번째 값을 c로 바꿈)
    static long update(int node, int start, int end, int index, long val) {
        if (index < start || index > end) return tree[node];
        if (start == end) return tree[node] = val % MOD;
        int mid = (start + end) / 2;
        // 해당 인덱스를 포함하는 노드만 재계산
        return tree[node] = (update(node * 2, start, mid, index, val) *
                update(node * 2 + 1, mid + 1, end, index, val)) % MOD;
    }

    // 구간 곱 쿼리 함수
    static long query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return 1;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return (query(node * 2, start, mid, left, right) *
                query(node * 2 + 1, mid + 1, end, left, right)) % MOD;
    }
}