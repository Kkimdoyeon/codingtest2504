package algo.ct.M10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17952_과제는끝나지않아_S3 {
    static int N;
    static int score = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Stack<int[]> stack = new Stack<>();

        while (N --> 0) {
            String line = br.readLine();

            // 1일 때만 queue에 넣기
            if (Integer.parseInt(line.split(" ")[0]) == 1) {
                int A = Integer.parseInt(line.split(" ")[1]);
                int T = Integer.parseInt(line.split(" ")[2]);
                stack.push(new int[]{A, T});
            }

            // 0이면 그 전꺼 T-- 하기
            // 만약 0이면 score+ 하기
            if (!stack.isEmpty()) {
                stack.peek()[1]--;
                if (stack.peek()[1] == 0)
                    score += stack.pop()[0];
            }
        }

        System.out.println(score);
    }
}
