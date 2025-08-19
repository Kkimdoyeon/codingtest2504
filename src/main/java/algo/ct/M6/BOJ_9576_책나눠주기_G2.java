package algo.ct.M6;

import java.io.*;
import java.util.*;

public class BOJ_9576_책나눠주기_G2 {

    static class Student implements Comparable<Student> {
        int start, end;

        public Student(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Student o) {
            return this.end - o.end; // 끝나는 책 번호 기준 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 책 개수
            int M = Integer.parseInt(st.nextToken()); // 학생 수

            Student[] students = new Student[M];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                students[i] = new Student(start, end);
            }

            Arrays.sort(students);

            boolean[] book = new boolean[N + 1]; // 책 번호 1번부터 사용
            int count = 0;

            for (Student s : students) {
                for (int i = s.start; i <= s.end; i++) {
                    if (!book[i]) {
                        book[i] = true;
                        count++;
                        break;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
