package com.ssafy._2023_07.day_07_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_14650_걷다보니신천역삼 {
    static int N, nums[],  cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        cnt = 0;

        perm(0);

        System.out.println(cnt);
    }

    public static void perm(int cnt) {
        if (cnt == N) {
//            System.out.println(Arrays.toString(nums));
            validate(nums);
            return;
        }

        for (int i = 0; i < 3; i++) {
//            if (visited[i] == 1) {
//                continue;
//            }

            nums[cnt] = i;
            perm(cnt + 1);
        }
    }

    public static void validate(int[] nums) {
        if (nums[0] == 0) {
            return;
        }

        int total = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            total += Math.pow(10, i) * nums[nums.length - i - 1];
        }

        if (total % 3 == 0) {
//            System.out.println(total);
            cnt++;
        }
    }
}

// N자리 3의 배수

// 3자리 3의 배수
// 2 1 1

// 12asdf
// 21