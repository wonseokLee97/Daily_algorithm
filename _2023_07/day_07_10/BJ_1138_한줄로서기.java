package com.ssafy._2023_07.day_07_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BJ_1138_한줄로서기 {
    static int N, arr[], visited[], nums[], answer[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new int[N];
        nums = new int[N];
        answer = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);

        for (int i = 0; i < N; i++) {
            sb.append(answer[i] + " ");
        }

        System.out.println(sb);
    }


    public static void perm(int cnt) {
        if (cnt == N) {
            validate(nums);
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 1) {
                continue;
            }

            nums[cnt] = i + 1;
            visited[i] = 1;
            perm(cnt + 1);
            visited[i] = 0;
        }
    }

    public static void validate(int[] nums) {
        int[] ans = new int[N];
        // arr 의 i+1 라는 수 앞에 i+1 보다 큰 숫자가 arr[i] 개 만큼 있는가?
        for (int i = 0; i < N; i++) {
            int cnt = 0;

            for (int j = 0; j < N; j++) {
                if (i + 1 == nums[j]) {
                    break;
                }

                if (i + 1 < nums[j]) {
                    cnt++;
                }
            }

            ans[i] = cnt;
        }

        int flag = 0;

        for (int i = 0; i < N; i++) {
            if (ans[i] != arr[i]) {
                flag = 1;
            }
        }

        if (flag == 0) {
            answer = nums.clone();
        }
    }
}