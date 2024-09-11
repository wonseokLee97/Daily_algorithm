package com.ssafy._2022_1.day_220822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1759_암호만들기_이원석 {
    static int L, C;
    static int[] visited;
    static char[] arr, check, arr2;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        visited = new int[C];
        check = new char[L];
        Arrays.sort(arr);

        // lCc
        comb(0, 0);


    }

    public static void comb(int d, int start) {
        if (d == L) {
            int v_cnt = 0;
            int c_cnt = 0;
            for (int i = 0; i < L; i++) {
                if (check[i] == 'a' || check[i] == 'e' || check[i] == 'i' || check[i] == 'o' || check[i] == 'u') {
                    v_cnt++;
                } else {
                    c_cnt++;
                }
            }
            if (v_cnt > 0 && c_cnt > 1) {
                print(check);
            }
            return;
        }

        for (int i = start; i < C; i++) {
            visited[i] = 1;
            check[d] = arr[i];
            comb(d + 1, i + 1);
            visited[i] = 0;
        }
    }

    public static void print(char[] check) {
        sb = new StringBuilder("");
        for (char c : check) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}

//[1, 2, 3, 4, 5]
//[1, 2, 3, 4, 6]
//[1, 2, 3, 4, 7]
//[1, 2, 3, 5, 6]
//[1, 2, 3, 5, 7]
//[1, 2, 3, 6, 7]
//[1, 2, 4, 5, 6]
//[1, 2, 4, 5, 7]
//[1, 2, 4, 6, 7]
//[1, 2, 5, 6, 7]
//[1, 3, 4, 5, 6]
//[1, 3, 4, 5, 7]
//[1, 3, 4, 6, 7]
//[1, 3, 5, 6, 7]
//[1, 4, 5, 6, 7]
//[2, 3, 4, 5, 6]
//[2, 3, 4, 5, 7]
//[2, 3, 4, 6, 7]
//[2, 3, 5, 6, 7]
//[2, 4, 5, 6, 7]
//[3, 4, 5, 6, 7]