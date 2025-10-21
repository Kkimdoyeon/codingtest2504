package algo.ct.M10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기_S3 {
    static int M, N;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new char[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= M-8; i++) {
            for (int j = 0; j <= N-8; j++) {
                min = Math.min(min, recolor(i, j));
            }
        }

        System.out.println(min);
    }

    private static int recolor(int x, int y) {
        int indexW = 0;
        int indexB = 0;

        for (int i = x; i < x+8; i++) {
            for (int j = y; j < y+8; j++) {
                char current = arr[i][j];

                // i+j가 짝수면 시작 색과 같아야 함
                if ((i+j) % 2 == 0) {
                    if (current != 'W') indexW++;
                    if (current != 'B') indexB++;
                } else {
                    if (current != 'W') indexB++;
                    if (current != 'B') indexW++;
                }
            }
        }

        return Math.min(indexB, indexW);
    }
}
