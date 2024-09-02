package com.ssafy._2024_07.BJ_15787_기차가어둠을헤치고은하수를;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] train = new int[N + 1][21];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 1:
                    int m1 = Integer.parseInt(st.nextToken());
                    if (train[n][m1] == 0) {
                        train[n][m1] = 1; // 승차
                    }
                    break;

                case 2:
                    int m2 = Integer.parseInt(st.nextToken());
                    train[n][m2] = 0; // 하차
                    break;

                case 3:
                    List<Integer> rightList = new ArrayList<>();

                    for (int j = 1; j < 21; j++) {
                        if (train[n][j] == 1) {
                            if (j == 20) {
                                train[n][j] = 0; // 하차
                                continue;
                            }

                            train[n][j] = 0; // 우무빙
                            rightList.add(j + 1);
                        }
                    }

                    for (int idx : rightList) {
                        train[n][idx] = 1;
                    }

                    break;

                case 4:
                    List<Integer> leftList = new ArrayList<>();

                    for (int j = 1; j < 21; j++) {
                        if (train[n][j] == 1) {
                            if (j == 1) {
                                train[n][j] = 0; // 하차
                                continue;
                            }

                            train[n][j] = 0; // 좌무빙
                            leftList.add(j - 1);
                        }
                    }

                    for (int idx : leftList) {
                        train[n][idx] = 1;
                    }

                    break;
            }
        }

        HashSet<Integer> set = new HashSet<>();

        // record
        for (int i = 1; i <= N; i++) {
            int record = 0;
            for (int j = 1; j < 21; j++) {
                if (train[i][j] == 1) {
                    record += Math.pow(2, j);
                }
            }

            set.add(record);
        }

        System.out.println(set.size());
    }
}
