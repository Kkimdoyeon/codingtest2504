package main.java.algo.ct.M5_1;

import java.io.*;
import java.util.*;

public class BOJ_18111_마인크래프트_S2 {
    static int N, M, B;
    static int[][] arr;
    static int max = 0;
    static int min = 256;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j]= Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }

        int answerTime = Integer.MAX_VALUE;
        int answerHeight = -1;

        for (int h = min; h <= max; h++) {
            int remove = 0;
            int add = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = arr[i][j] - h;
                    if (diff > 0) remove += diff;
                    else add -= diff;
                }
            }

            if (remove + B >= add) {
                int time = remove*2 + add;
                if (time <= answerTime) {
                    answerTime = time;
                    answerHeight = h;
                }
            }
        }

        System.out.println(answerTime + " " + answerHeight);
    }
}
