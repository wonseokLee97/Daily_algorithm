package com.ssafy._2024_08.BJ_20115_에너지드링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        List<Double> list = new ArrayList<>();
        for (double d : arr) {
            list.add(d);
        }
        Collections.sort(list);

        double maxVal = list.get(list.size() - 1);
        double total = 0;

        for (int i = 0; i < N - 1; i++) {
            double minVal = list.get(i);
            maxVal += (minVal / 2);
        }

        System.out.println(maxVal);
    }
}

// 2 3 6 9 10


// 페인이 에너지 드링크들을 합치는 과정은 다음과 같다.
//
// 1. 임의의 서로 다른 두 에너지 드링크를 고른다.
// 2. 한쪽 에너지 드링크를 다른 쪽 에너지 드링크에 모두 붓는다.
//    단, 페인은 야근 후유증으로 인해 손이 떨려, 붓는 과정에서 원래 양의 절반을 바닥에 흘리게 된다.
// 3. 다 붓고 남은 빈 에너지 드링크는 버린다.
// 4. 1~3 과정을 에너지 드링크가 하나만 남을 때까지 반복한다.

// 예를 들어, 두 에너지 드링크 a, b가 있고, 양이 각각 xa, xb라 할 때,
// 다음 둘 중 하나의 선택을 할 수 있다.
//
// a의 양을 xa + (xb / 2)로 만들고, b를 버리기
// b의 양을 xb + (xa / 2)로 만들고, a를 버리기

// 3 2 10 9 6


// 2 3 6 9 10
// 10 + 2/2 = 11

// 3 6 9 11
// 11 + 3/2 = 12

// 6 9 12
// 12 + 6/2 = 15

// 9 15
// 15 + 9/2 = 19

// 19