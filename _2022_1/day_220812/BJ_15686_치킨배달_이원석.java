package com.ssafy._2022_1.day_220812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class target {
    int i;
    int j;

    public target(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class BJ_15686_치킨배달_이원석 {
    static int N, M, sum;
    static List<target> chicken = new ArrayList();
    static List<target> house = new ArrayList();
    static int min_dis;
    static int min_sum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) { // 집이면?
                    house.add(new target(i, j));
                } else if (arr[i][j] == 2) { // 치킨집이면?
                    chicken.add(new target(i, j));
                }
            }
        }

        comb(chicken.size());
        System.out.println(min_sum);
    }

    public static void comb(int N) {
        for (int i = 0; i < 1 << N; i++) { // 10000 보다 작은 2진수
            int cnt = 0;
            for (int j = 0; j < N; j++) { // 치킨집의 수 만큼 비트 validate
                if ((i & 1 << j) > 0) { // 0001, 0010, 0100, 1000
                    cnt++;
                }
            }

            if (cnt == M) { // M 개만큼 치킨집을 발견했을 때
                sum = 0;
                for (int j = 0; j < house.size(); j++) { // 집의 개수만큼 (집을 기준으로 치킨을 순회)
                    min_dis = Integer.MAX_VALUE;
                    for (int k = 0; k < chicken.size(); k++) {
                        if ((i & 1 << k) > 0) { // 선택한 치킨만 계산한다
                            int distance = Math.abs(house.get(j).i - chicken.get(k).i)
                                    + Math.abs(house.get(j).j - chicken.get(k).j);

                            min_dis = Math.min(min_dis, distance); // 가장 집에서 가까운 치킨집의 거리
                        }
                    }
                    sum += min_dis;
                }
                min_sum = Math.min(min_sum, sum);
            }
        }
    }
}
