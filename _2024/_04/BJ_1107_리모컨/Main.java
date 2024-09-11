package com.ssafy._2024._04.BJ_1107_리모컨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int visited[], button[], L, N, min_val;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String n_s = br.readLine();
        char[] c = n_s.toCharArray();
        L = c.length;

        N = Integer.parseInt(n_s);
        int M = Integer.parseInt(br.readLine());
        min_val = Integer.MAX_VALUE;

        visited = new int[10];
        button = new int[10];

        if (M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                button[Integer.parseInt(st.nextToken())] = 1;
            }
        }



//        int p;
//
//        if (N <= Math.pow(10, L) / 2) {
//            p = 0;
//        } else {
//            p = 1;
//        }

        for (int i = 1; i <= L + 1; i++) {
            perm(0, i, "");
        }


        // 모든 버튼이 고장난 경우
        if (min_val == Integer.MAX_VALUE) {
            System.out.println(Math.abs(N - 100));
        } else {
            System.out.println(Math.min(Math.abs(N - 100), min_val));
        }
    }

    static void perm(int cnt, int l, String chan) {
//        System.out.println(cnt + ", " + l + ", " + chan);
        if (cnt == l) {
            int channel = Integer.parseInt(chan);
//            System.out.println(channel);

            if (Math.abs(channel - N) + chan.length() < min_val) {
                min_val = Math.abs(channel - N) + chan.length();
//                System.out.println(chan + ", " + chan.length());
//                System.out.println(channel + "?" + min_val);
//                System.out.println(Math.abs(channel - N) + ", " + min_val);
//                System.out.println();
            }

//            min_val = Math.min(min_val, Math.abs(channel - N));
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (button[i] == 1) {
                continue;
            }

//            if (cnt > 0 && i == 0) {
//                continue;
//            }

            visited[i]++;
            perm(cnt + 1, l, chan + i);
            visited[i]--;
        }
    }
}

// 2 2 2 2 + 667번 = 671

//99933
//2
//3 9

// 2 2 2 2

// 5 4 5 5 + +
// 5 4 5 9 - -
// 1 0 0 0 0 0 -> 6
// 67 + 6


// 10가지의 버튼 중, 고장난 버튼을 제외하고 최대 6개를 선택한다. 중복해서 선택가능, 순서에 영향이 있다 -> 중복순열


//1555
//3
//0 1 9
//
//670
//99933
//2
//3 9


// 2 2 2 2

//944
//7
//2 3 4 5 6 7 9

// 888
// 1000 56

//6
//9
//0 2 3 4 5 6 7 8 9

//500000
//10
//0 1 2 3 4 5 6 7 8 9

//101
//10
//0 1 2 3 4 5 6 7 8 9