package com.ssafy.toss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class po6 {
    public static void main(String[] args) {
        List<Integer> list;
        int max_val = Integer.MIN_VALUE;
        int[] prices = new int[]{10, 7, 8, 5, 6, 4, 3, 2, 3};
        int k = 3;

        for (int i = 0; i < prices.length - k; i++) {
            list = new ArrayList<>();
            int total = 0;

            // i일에 풀 매수를 했다고 치자!
            int buy = prices[i];

            for (int j = i + 1; j < prices.length; j++) {
                list.add(prices[j] - buy);
            }

            Collections.sort(list);
            for (int j = list.size()- 1; j >= list.size() - k; j--) {
                total += list.get(j);
            }

            max_val = Math.max(max_val, total);
        }

        if (max_val < 0) {
            System.out.println(-1);
        } else {
            System.out.println(max_val);
        }
    }
}
