package main.java.algo.ct.M4_1;

import java.util.*;
import java.io.*;

public class b1051 {
    static int N,M;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int len = Math.min(N, M);
        // 정사각형의 최대 길이는 N과 M 중 더 작은 것

        while(len > 1) {
            for(int i=0; i<= N-len; i++) {
                for(int j=0; j<=M-len; j++) {
                    int num = map[i][j];
                    // 꼭짓점 3군데 비교
                    if(num==map[i][j+len-1] && num == map[i+len-1][j] && num == map[i+len-1][j+len-1]) {
                        System.out.println(len*len);
                        return;
                    }
                }
            }
            len--;
        }

        System.out.println(len*len);

    }

}