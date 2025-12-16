package algo.ct.M12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합_S2 {
    static int N, S, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0);
        if (S == 0) answer--;
        System.out.println(answer);
    }

    public static void dfs(int idx, int total) {
        if (idx == N) {
            if (total == S)
                answer++;
            return;
        }

        // 선택할 경우
        dfs(idx + 1, total + arr[idx]);

        // 선택하지 않을 경우
        dfs(idx + 1, total);
    }
}