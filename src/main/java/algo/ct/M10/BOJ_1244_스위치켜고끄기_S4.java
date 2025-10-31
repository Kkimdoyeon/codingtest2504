package algo.ct.M10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244_스위치켜고끄기_S4 {
    static int switchN, studentN;
    static int[] swArr;
    static int[][] stArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switchN = Integer.parseInt(br.readLine());

        swArr = new int[switchN+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= switchN; i++) {
            swArr[i] = Integer.parseInt(st.nextToken());
        }

        studentN = Integer.parseInt(br.readLine());
        stArr = new int[studentN][2];
        for (int i = 0; i < studentN; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                stArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int fixStudentN = studentN-1;
        while (studentN --> 0) {
            if (stArr[fixStudentN-studentN][0] == 1) { // 남학생이라면
                goToBoy(stArr[fixStudentN-studentN][1]);
            } else if (stArr[fixStudentN-studentN][0] == 2) { // 여학생이라면
                goToGirl(stArr[fixStudentN-studentN][1]);
            }
        }

        for (int i = 1; i <= switchN; i++) {
            System.out.print(swArr[i] + " ");
            if (i % 20 == 0)
                System.out.println();
        }
    }

    public static void goToBoy(int index) {
        // 자기가 받은 수의 배수이면, 그 스위치 상태를 바꾼다.
        // 0이면 1로, 1이면 0으로
        for (int i = 1; i <= switchN; i++) {
            if (i % index == 0) {
                if (swArr[i] == 1)
                    swArr[i] = 0;
                else
                    swArr[i] = 1;
            }
        }
    }

    public static void goToGirl(int index) {
        // 자기가 받은 수와 같은 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서
        // 가장 많은 스위치를 포함하는 구간을 찾아서, 그 구간에 속한 스위치의 상태를 모두 바꾼다.
        // 이때 구간에 속한 스위치 개수는 항상 홀수가 된다. >> 원래 그래야되는 거 아님?
        if (swArr[index] == 1)
            swArr[index] = 0;
        else
            swArr[index] = 1;

        // 현재 검사하는 인덱스가 index+1
        int left = index-1;
        int right = index+1;
        while (left > 0 && right <= switchN) {
            if (swArr[left] == swArr[right]) {
                if (swArr[left] == 1) {
                    swArr[left] = 0;
                    swArr[right] = 0;
                }
                else {
                    swArr[left] = 1;
                    swArr[right] = 1;
                }
                left--;
                right++;
            }
            else return;
        }
    }

}
