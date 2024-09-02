package com.ssafy._2023._2023_03.day_03_03;


import java.util.Scanner;

// 문자열 그 자체로 회문 - 0
// 유사회문 - 1
// 그 이외 - 2
public class BJ_17609_회문 {
    static char chars[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            chars = sc.next().toCharArray();
//            System.out.println("====" + i + "====");
            System.out.println(two_pointer(0, chars.length - 1, 0));
        }
    }

    public static int two_pointer(int s, int e, int res) {
//        System.out.println(s + ", " + e + ", " + res);
        // res 가 2 이상일 경우에는.. 이미 한번 소거의 기회를 져버린것
        if (res == 2) {
            return 2;
        }

        while (s < e) {
            // 문자가 일치하는 경우 좁혀가자!
            if (chars[s] == chars[e]) {
                s++;
                e--;
            } else {
                // 재귀를 활용하여
                res = Math.min(two_pointer(s + 1, e, res + 1), two_pointer(s, e - 1, res + 1));
                return res;
            }
        }

        return res;
    }
}

// a b c d d a d c a
// a/ c/ d/ d a d/ c/ a/

// aabbb