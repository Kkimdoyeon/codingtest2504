package algo.ct.M4_4;

import java.io.*;
import java.util.*;

public class BOJ_2263_트리의순회_G1 {
    static int[] inorder;
    static int[] postorder;
    static int[] indexMap;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        inorder = new int[n];
        postorder = new int[n];
        indexMap = new int[100_001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            indexMap[inorder[i]] = i;
        }

        buildPreorder(0, n - 1, 0, n - 1);

        bw.flush();
        bw.close();
    }

    // inorder의 s~e, postorder의 s~e 범위를 기준으로 재귀
    static void buildPreorder(int inStart, int inEnd, int postStart, int postEnd) throws IOException {
        if (inStart > inEnd || postStart > postEnd) return;

        // 후위 순회의 마지막 값이 루트
        int root = postorder[postEnd];
        bw.write(root + " ");

        // 루트 기준으로 왼쪽/오른쪽 자식 나누기
        int rootIndex = indexMap[root];
        int leftSize = rootIndex - inStart;

        // 왼쪽 서브트리
        buildPreorder(inStart, rootIndex - 1, postStart, postStart + leftSize - 1);

        // 오른쪽 서브트리
        buildPreorder(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
    }
}
