package main.java.algo.ct.M4_1;
//https://school.programmers.co.kr/learn/courses/18/lessons/1876

public class p1876 {
    public int solution(int n) {
        int answer = 0;

        while (n >= 1) {
            answer += (n % 10);
            n /= 10;
        }

        return answer;
    }
}
