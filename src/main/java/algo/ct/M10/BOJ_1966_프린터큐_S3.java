package algo.ct.M10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966_프린터큐_S3 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n, index;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            index = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                queue.add(new int[]{Integer.parseInt(st.nextToken()), i});

            int count = 0;
            while (!queue.isEmpty()) {
                int[] check = queue.poll();

                // 뒤에 더 중요한 문서가 있는지
                boolean hasHigher = false;
                for (int[] q : queue) {
                    if (q[0] > check[0]) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    queue.add(check);
                }
                else {
                    count++;
                    if (check[1] == index) {
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}
