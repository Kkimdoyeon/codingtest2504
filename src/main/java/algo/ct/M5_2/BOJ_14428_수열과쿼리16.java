package algo.ct.M5_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_14428_수열과쿼리16 {
    static int N, M;
    static int[] arr;
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        tree = new int[4 * N][2];
        build(1, 1, N);

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                update(1, 1, N, x, y);
            } else {
                int[] res = query(1, 1, N, x, y);
                sb.append(res[1]).append("\n");
            }
        }

        System.out.print(sb);
    }


    static int[] build(int node, int start, int end) {
        if (start == end) {
            tree[node][0] = arr[start];
            tree[node][1] = start;
            return tree[node];
        }

        int mid = (start + end) / 2;
        int[] left = build(node * 2, start, mid);
        int[] right = build(node * 2 + 1, mid + 1, end);

        if (left[0] < right[0]) {
            tree[node][0] = left[0];
            tree[node][1] = left[1];
        } else if (left[0] > right[0]) {
            tree[node][0] = right[0];
            tree[node][1] = right[1];
        } else {
            tree[node][0] = left[0];
            tree[node][1] = Math.min(left[1], right[1]);
        }

        return tree[node];
    }

    static int[] query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        }
        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        int[] leftRes = query(node * 2, start, mid, left, right);
        int[] rightRes = query(node * 2 + 1, mid + 1, end, left, right);

        if (leftRes[0] < rightRes[0]) {
            return leftRes;
        } else if (leftRes[0] > rightRes[0]) {
            return rightRes;
        } else {
            return leftRes[1] < rightRes[1] ? leftRes : rightRes;
        }
    }

    static int[] update(int node, int start, int end, int idx, int val) {
        if (idx < start || idx > end) {
            return tree[node];
        }
        if (start == end) {
            tree[node][0] = val;
            arr[idx] = val;
            return tree[node];
        }

        int mid = (start + end) / 2;
        int[] left = update(node * 2, start, mid, idx, val);
        int[] right = update(node * 2 + 1, mid + 1, end, idx, val);

        if (left[0] < right[0]) {
            tree[node][0] = left[0];
            tree[node][1] = left[1];
        } else if (left[0] > right[0]) {
            tree[node][0] = right[0];
            tree[node][1] = right[1];
        } else {
            tree[node][0] = left[0];
            tree[node][1] = Math.min(left[1], right[1]);
        }

        return tree[node];
    }
}