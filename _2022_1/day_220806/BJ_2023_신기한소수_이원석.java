package com.ssafy._2022_1.day_220806;

import java.util.*;

/**
 * 소수는 1과 자기 자신 외의 약수를 가지지 않는 1보다 큰 자연수
 */

public class BJ_2023_신기한소수_이원석 {

    static int[] decimal = {1, 2, 3, 5, 7, 9};
    static int N;
    static int cnt;
    static List<Integer> decimals;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cnt = 0;
        // 1 ~ 99999999
        // 1, 2, 3, 5, 7, 9, 11
        decimals = new ArrayList<>();

        validate(0);

        Collections.sort(decimals);

        for (int i = 0; i < decimals.size(); i++) {
            System.out.println(decimals.get(i));
        }
    }

    public static void validate(int sum) {
        if (cnt == N) {
            if (check(sum)) {
                decimals.add(sum);
            }
            return;
        }

        for (int dec : decimal) {
            sum += dec * (int) Math.pow(10, cnt);
            cnt++;
            validate(sum);
            cnt--;
            sum -= dec * (int) Math.pow(10, cnt);
        }
    }

    public static boolean check(int D) {
        int tmp = cnt;
        int get = 0;
        for (int i = tmp - 1; i >= 0; i--) {
            get = D / (int) Math.pow(10, i);
            if (get < 2) { // 소수가 아니다
                return false;
            }

            if (get == 2) {
                continue;
            }

            for (int j = 3; j < get; j++) {
                if (get % j == 0) { // 소수가 아닌경우
                    return false;
                }
            }
        }
        return true;
    }
}

// 1, 2, 3, 5, 7, 9 - 한 자릿수 소수 4개를 선별
// 2 1 1 1
// 2 1 1