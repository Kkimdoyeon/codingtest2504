package algo.ct.M10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2852_NBA농구_S3 {
    static int N;
    static int[][] score = new int[3][2]; // [팀번호][0:점수, 1:리드시간]
    static int victory = 0; // 현재 리드 중인 팀 (0 = 없음, 1 = 팀1, 2 = 팀2)
    static int prevTime = 0; // 직전 시간 (초 단위)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            int team;
            StringTokenizer st = new StringTokenizer(br.readLine());
            team = Integer.parseInt(st.nextToken());
            String line = st.nextToken();
            int M = Integer.parseInt(line.split(":")[0]);
            int S = Integer.parseInt(line.split(":")[1]);
            int currentTime = M * 60 + S;

            // 직전 리드 팀이 있었다면, 그 팀에 리드 시간 추가
            if (victory != 0) {
                score[victory][1] += currentTime - prevTime;
            }

            // 점수 업데이트
            score[team][0]++;

            // 현재 리드 팀 재계산
            if (score[1][0] > score[2][0]) victory = 1;
            else if (score[2][0] > score[1][0]) victory = 2;
            else victory = 0; // 동점이면 리드 팀 없음

            // 이전 시간 갱신
            prevTime = currentTime;
        }

        // 경기 종료 시점 계산 (48분 = 2880초)
        if (victory != 0) {
            score[victory][1] += (48 * 60 - prevTime);
        }

        for (int i = 1; i < 3; i++) {
            int resultM, resultS;
            resultM = score[i][1] / 60;
            resultS = score[i][1] % 60;
            System.out.println(String.format("%02d:%02d", resultM, resultS));
        }
    }
}
