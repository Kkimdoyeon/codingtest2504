package main.java.algo.ct.M5_1;

import java.io.*;
import java.util.*;

public class BOJ_15686_치킨배달_G5 {
    static int N, M;
    static int[][] arr;
    static List<int[]> homes = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 치킨 집 수
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1)
                    homes.add(new int[]{i, j});
                if (arr[i][j] == 2)
                    chickens.add(new int[]{i, j});
            }
        }

        combi(new ArrayList<>(), 0, 0);
        System.out.println(min);
    }

    static void combi(List<int[]> selected, int start, int depth) {
        if (depth == M) {
            min = Math.min(min, getCityChickenDistance(selected));
            return;
        }

        for (int i = start; i< chickens.size(); i++) {
            selected.add(chickens.get(i));
            combi(selected, i+1, depth+1);
            selected.remove(selected.size()-1);
        }
    }

    static int getCityChickenDistance(List<int[]> selected) {
        int sum = 0;
        for (int[] home : homes) {
            int minDist = Integer.MAX_VALUE;
            for (int[] chicken : selected) {
                int dist = Math.abs(home[0]- chicken[0]) + Math.abs(home[1] - chicken[1]);
                minDist = Math.min(minDist, dist);
            }
            sum += minDist;
        }
        return sum;
    }
}
