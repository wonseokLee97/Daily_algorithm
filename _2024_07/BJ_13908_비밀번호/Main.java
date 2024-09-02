package com.ssafy._2024_07.BJ_13908_비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m, visited[], arr[], ans;
    static List<Integer> checkList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        ans = 0;
        checkList = new ArrayList<>();

        if (m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                checkList.add(Integer.parseInt(st.nextToken()));
            }
        }

        perm(0);

        System.out.println(ans);
    }

    static void perm(int cnt) {
        if (cnt == n) {
            int flag = 0;

            for (int val : checkList) {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == val) {
                        flag++;
                        break;
                    }
                }
            }

            if (flag != m) {
                return;
            }

            ans++;
            return;
        }


        for (int i = 0; i < 10; i++) {
            arr[cnt] = i;
            perm(cnt + 1);
        }
    }
}

// 순서가 있음: 순열,
// n과 m이 같으면 npm

// 07 17 27 37 47 57 67 70 71 72 37 74 75 76 78