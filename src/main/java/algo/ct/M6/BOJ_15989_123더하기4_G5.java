package algo.ct.M6;

import java.io.*;

public class BOJ_15989_123더하기4_G5 {
    static int T;
    static int[] n;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        n = new int[T];
        int max = 0;

        for (int i = 0; i < T; i++) {
            n[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, n[i]);
        }

        dp = new int[max+1][4];
        dp[0][1] = dp[0][2] = dp[0][3] = 1; // 0을 만드는 경우의 수는 1

        for (int i = 1; i <= max; i++) {
            if (i - 1 >= 0)
                dp[i][1] = dp[i-1][1];

            if (i - 2 >= 0)
                dp[i][2] = dp[i-2][2] + dp[i][1];
            else
                dp[i][2] = dp[i][1];

            if (i - 3 >= 0)
                dp[i][3] = dp[i-3][3] + dp[i][2];
            else
                dp[i][3] = dp[i][2];
        }

        for (int i = 0; i < T; i++)
            System.out.println(dp[n[i]][3]);
    }

}
