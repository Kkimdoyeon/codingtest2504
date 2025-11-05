package algo.ct.M10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_8979_올림픽_S5 {

    static class Country implements Comparable<Country> {
        int id;     // 국가 번호
        int gold;   // 금메달
        int silver; // 은메달
        int bronze; // 동메달

        public Country(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        // 정렬 기준: 금 → 은 → 동 내림차순
        @Override
        public int compareTo(Country o) {
            if (this.gold != o.gold) return o.gold - this.gold;
            if (this.silver != o.silver) return o.silver - this.silver;
            return o.bronze - this.bronze;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 국가 수
        int target = Integer.parseInt(st.nextToken()); // 알고 싶은 국가 번호

        List<Country> countries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            countries.add(new Country(id, gold, silver, bronze));
        }

        // 금→은→동 내림차순 정렬
        Collections.sort(countries);

        // 등수 계산
        int rank = 1;
        for (int i = 0; i < countries.size(); i++) {
            Country cur = countries.get(i);
            if (cur.id == target) {
                System.out.println(rank);
                return;
            }

            // 다음 국가와 비교해 다르면 다음 등수 갱신
            if (i < countries.size() - 1) {
                Country next = countries.get(i + 1);
                if (cur.gold != next.gold || cur.silver != next.silver || cur.bronze != next.bronze) {
                    rank = i + 2;
                }
            }
        }
    }
}
