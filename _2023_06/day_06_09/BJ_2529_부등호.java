package com.ssafy._2023_06.day_06_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 시작시간 21시 13분
// 종료시간 22시 21분
// 소요시간 1시간 8분
public class BJ_2529_부등호 {

    static int visited[], k;
    static long min_val, max_val;
    static String sign[], min_val_string, max_val_string;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        k = Integer.parseInt(br.readLine());
        visited = new int[10];

        sign = br.readLine().split(" ");
        list = new ArrayList<>();

        min_val = Long.MAX_VALUE;
        max_val = Long.MIN_VALUE;
        min_val_string = "";
        max_val_string = "";

        perm(0);

        System.out.println(max_val_string);
        System.out.println(min_val_string);
    }

    public static void perm(int cnt) {
        if (cnt == k + 1) {
            String val = "";

            for (int i = 0; i < list.size(); i++) {
                val += list.get(i);
            }

            if (max_val < Long.parseLong(val)) {
                max_val_string = val;
                max_val = Long.parseLong(val);
            }

            if (min_val > Long.parseLong(val)) {
                min_val_string = val;
                min_val = Long.parseLong(val);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i] != 0) {
                continue;
            }

            visited[i] = cnt + 1;
            list.add(i);


            if (cnt + 1 >= 2) {
                if (!validation()) {
                    visited[i] = 0;
                    list.remove(cnt);
                    continue;
                }
            }
            perm(cnt + 1);
            visited[i] = 0;
            list.remove(cnt);
        }
    }

    //

    public static boolean validation() {
        for (int i = 0; i < list.size() - 1; i++) {
            // i < i + 1
            if (sign[i].equals("<")) {
                if (list.get(i) < list.get(i + 1)) {
                    continue;
                } else {
                    return false;
                }
            } else if (sign[i].equals(">")) {
                if (list.get(i) > list.get(i + 1)) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}

// i번째 숫자인 경우, i+1 번째 부등호, i+2 번째 숫자와 비교한다.
// 부등호 사이의 숫자 정수 K의 범위는 2 부터 9
// 10개 중에 (k+1)개의 숫자를 골라야함. (0~9)
// 순서가 다르면 결과도 달라지기 때문에 순열이다. + 가지치기 하면됨