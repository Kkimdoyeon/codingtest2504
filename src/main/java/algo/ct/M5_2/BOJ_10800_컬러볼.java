package algo.ct.M5_2;

import java.io.*;
import java.util.*;

public class BOJ_10800_컬러볼 {

    static class Ball implements Comparable<Ball> {
        int index;
        int color;
        int size;

        Ball(int index, int color, int size) {
            this.index = index;
            this.color = color;
            this.size = size;
        }

        public int compareTo(Ball other) {
            return Integer.compare(this.size, other.size);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Ball[] balls = new Ball[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            balls[i] = new Ball(i, color, size);
        }

        Arrays.sort(balls);

        int[] result = new int[n];
        int[] colorSum = new int[200001];
        int totalSum = 0;

        int j = 0;
        for (int i = 0; i < n; i++) {
            // 현재 공보다 작은 공들만 누적
            while (balls[j].size < balls[i].size) {
                totalSum += balls[j].size;
                colorSum[balls[j].color] += balls[j].size;
                j++;
            }

            result[balls[i].index] = totalSum - colorSum[balls[i].color];
        }

        StringBuilder sb = new StringBuilder();
        for (int score : result) {
            sb.append(score).append("\n");
        }
        System.out.print(sb);
    }
}
