package algo.ct.M8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기_S4 {
    static int N, M;
    static int A[];
    static int checkArr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        M = Integer.parseInt(br.readLine());
        checkArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            System.out.println(findN(checkArr[i], 0, N-1));
        }

    }

    public static int findN(int n, int left, int right) {
        int mid = (left + right) / 2;

        while (left <= right) {
            if (n > A[mid])
                left = mid + 1;
            else if (n < A[mid])
                right = mid - 1;
            else if (n == A[mid])
                return 1;

            mid = (left + right) / 2;
        }
        return 0;
    }
}
