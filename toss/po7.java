package com.ssafy.toss;

import java.util.*;

public class po7 {

    public static void main(String[] args) {
        int[] schedules = {30, 30, 60, 90, 60, 15, 15, 60};
        List<Integer> lis = findLIS(schedules);
        System.out.println("LIS: " + lis);
    }

    public static List<Integer> findLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] prevIndex = new int[n]; // 이전 인덱스를 저장하기 위한 배열
        Arrays.fill(dp, 1);
        Arrays.fill(prevIndex, -1); // 초기값으로 -1을 설정

        int maxLen = 1;
        int endIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j] && dp[i] < dp[j] + 1) {
                    if (prevIndex[i] == j + 1) {
                        continue;
                    }
                    dp[i] = dp[j] + 1;
                    prevIndex[i] = j; // 이전 인덱스 갱신
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                endIndex = i; // 마지막 인덱스 갱신
            }

            System.out.println(Arrays.toString(prevIndex));
        }

        List<Integer> lis = new ArrayList<>();
        while (endIndex != -1) { // 역추적을 통해 LIS 구성
            System.out.println(endIndex);
            lis.add(nums[endIndex]);
            endIndex = prevIndex[endIndex];
        }
        // 역순으로 저장되었으므로 뒤집어서 반환
        Collections.reverse(lis);

        return lis;
    }
}
