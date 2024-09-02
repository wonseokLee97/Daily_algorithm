package com.ssafy._2023._2023_08.day_08_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ_1744_수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int get = Integer.parseInt(br.readLine());

            if (get <= 0) {
                negative.add(get);
            } else {
                positive.add(get);
            }
        }

        Collections.sort(positive);
        Collections.sort(negative);

        int total = 0;
        
        for (int i = positive.size() - 1; i >= 0; i -= 2) {
            if (i == 0) {
                total += positive.get(i);
            } else {
                int tieMul = positive.get(i) * positive.get(i - 1);
                int tieAdd = positive.get(i) + positive.get(i - 1);
                total += Math.max(tieMul, tieAdd);
            }
        }

        for (int i = 0; i < negative.size(); i += 2) {
            if (i == negative.size() - 1) {
                total += negative.get(i);
            } else {
                int tieMul = negative.get(i) * negative.get(i + 1);
                int tieAdd = negative.get(i) + negative.get(i + 1);
                total += Math.max(tieMul, tieAdd);
            }
        }

        System.out.println(total);
    }
}


// 0, 1, 2, 3, 4, 5

// -1, -2, -3
// 1, 2, 3

// -1
// 1, 2, 3

// 음수는 무조건 음수랑 곱해야함.

// -3, -2, -1, 0
// 1