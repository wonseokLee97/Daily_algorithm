//package com.ssafy._2022_09.day_220914;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class PG_기둥과보설치_이원석 {
//    static int cols[][], rows[][];
//
//    public static void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int[][] build_frame =
//                {{1, 0, 0, 1},
//                {1, 1, 1, 1},
//                {2, 1, 0, 1},
//                {2, 2, 1, 1},
//                {5, 0, 0, 1},
//                {5, 1, 0, 1},
//                {4, 2, 1, 1},
//                {3, 2, 1, 1}
//                };
//
//        solution(5, build_frame);
//    }
//
//
//    public static int[][] solution(int n, int[][] build_frame) {
//        cols = new int[n+2][n+2];
//        rows = new int[n+2][n+2];
//
//        for (int[] bf : build_frame) {
//            int x = bf[0], y = bf[1], d = bf[2], m = bf[3];
//
//            // 기둥
//            if (d == 0) {
//                // 설치
//                if (m == 1 && validate_c(x, y)) {
//
//                } else if (m == 0 && validate_d(x, y)) { // 삭제
//
//                }
//
//            } else { // 보
//                // 설치
//                if (m == 1 && validate_r(x, y)) {
//
//                } else if (m == 0 && validate_d(x, y)) {
//
//                }
//            }
//        }
//    }
//
//    public static boolean validate_c(int x, int y) {
//
//    }
//
//    public static boolean validate_r(int x, int y) {
//
//    }
//
//    public static boolean validate_d(int x, int y) {
//
//    }
//}
