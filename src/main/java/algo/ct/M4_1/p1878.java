package main.java.algo.ct.M4_1;
//https://school.programmers.co.kr/learn/courses/18/lessons/1878

public class p1878 {
    public int[] solution(int[][] v) {
        int x = 0, y = 0;

        for (int i = 0; i < 3; i++) {
            x ^= v[i][0];
            y ^= v[i][1];
        }

        int[] result = {x,y};
        return result;
    }
}
