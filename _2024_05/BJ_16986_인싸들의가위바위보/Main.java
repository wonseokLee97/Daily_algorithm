package com.ssafy._2024_05.BJ_16986_인싸들의가위바위보;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node {
    String name;
    int id;
    int idx;
    int point;
    int[] strategy;

    public Node(String name, int id, int idx, int point, int[] strategy) {
        this.name = name;
        this.id = id;
        this.idx = idx;
        this.point = point;
        this.strategy = strategy;
    }
}

public class Main {
    static int N, K, arr[][], val[], visited[], a_arr[], b_arr[], flag;
    static Node ziu, A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        flag = 0;

        if (N < K) {
            System.out.println(0);
            return;
        }

        arr = new int[N + 1][N + 1];
        visited = new int[N];
        val = new int[N];

        // 가위바위보 상성
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        a_arr = new int[20];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 20; i++) {
            a_arr[i] = Integer.parseInt(st.nextToken());
        }

        b_arr = new int[20];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 20; i++) {
            b_arr[i] = Integer.parseInt(st.nextToken());
        }


        perm(0);

        System.out.println(flag);
    }

    static void perm(int cnt) {
        if (cnt == N) {
            // 지우, A, B가 게임을 한다.
            ziu = new Node("지우", 0, 0, 0, val);
            A = new Node("경희", 1, 0, 0, a_arr);
            B = new Node("민호", 2, 0, 0, b_arr);

            System.out.println(Arrays.toString(val));
            rsp(1, ziu, A);
            System.out.println("==== 경기종료! ====");
            System.out.println();

            if (flag == 1) {
                return;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] != 0) {
                continue;
            }

            visited[i]++;
            val[cnt] = i + 1;
            perm(cnt + 1);
            visited[i]--;
            val[cnt] = 0;
        }
    }

    static void rsp(int cnt, Node first, Node second) {

//        System.out.println(cnt + " 번째 경기입니다!");
        if (first.point == K) {
            System.out.println("승자는 " + first.name + " 입니다!");
            // 지우가 우승한 경우
            if (first.id == 0) {
                flag = 1;
            }
            return;
        }

        if (second.point == K) {
            System.out.println("승자는 " + second.name + " 입니다!");
            // 지우가 우승한 경우
            if (second.id == 0) {
                flag = 1;
            }
            return;
        }

        if (ziu.idx == N) {
//            System.out.println("지우는 우승할 수 없어..");
            return;
        }

//        if (ziu.idx == K) {
//            System.out.println("지우가 승리할 수 없으므로 경기를 종료합니다!");
//            return;
//        }
// 처음 경기에서 무조건 경희가 이기면 안됨

        System.out.println(first.name + ", " + second.name + " 의 경기를 진행합니다!");
        System.out.println(ziu.point + ", "+ A.point + ", " + B.point + " 점수!");

        int f = first.strategy[first.idx++];
        int s = second.strategy[second.idx++];

        System.out.println(first.name + "가 낸 숫자: " + f);
        System.out.println(second.name + "가 낸 숫자: " + s);
        System.out.println(arr[f][s]);

        Node winner = null;

        switch (arr[f][s]) {
            // f가 졌을 때
            case 0:
                second.point++;
                winner = second;
                break;
            // f가 비겼을 때
            case 1:
                if (first.id < second.id) {
                    second.point++;
                    winner = second;
                } else {
                    first.point++;
                    winner = first;
                }
                break;
                // f가 이겼을 때
            case 2:
                first.point++;
                winner = first;
                break;
        }

        Node next_challenger = null;
        for (int i = 0; i < 3; i++) {
            if (first.id != i && second.id != i) {
                switch (i) {
                    case 0: // 지우
                        next_challenger = ziu;
                        break;
                    case 1: // A
                        next_challenger = A;
                        break;
                    case 2: // B
                        next_challenger = B;
                        break;
                }
                break;
            }
        }

        System.out.println(winner.name + " 가(이) 승리했습니다! 다음 도전자는 " + next_challenger.name + " 입니다!");
        System.out.println();
        rsp(cnt + 1, winner, next_challenger);
    }
}

// 4,1,2,3
// 4,1,3,2
// 4,2,1,3
// 4,2,3,1
// 4,3,1,2
// 4,3,2,1

// [2

// N: 3 K: 2
// 0: 패배, 1: 비김, 2: 우승
//    1 2 3
// 1: 1 0 2
// 2: 2 1 0
// 3: 0 2 1

// 순열, K번만 이기면 우승.

// 1 2 3
// 1 2
// 1 3
// 2 1
// 2 3
// 3 1
// 3 2

// 0- 지우: [1] 2
// 1- 경희: 2 [2] 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
// 2- 민호: [3] 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3

// 지우:0 / 경희:1 / 민호:0
// 지우 vs 경희 : 1-2 경희 승
// 경희 vs 민호 : 2-3 민호 승
// 민호 vs 지우 : 3-2 민호 승 끝


//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//class Node {
//    String name;
//    int id;
//    int idx;
//    int point;
//    int[] strategy;
//
//    public Node(String name, int id, int idx, int point, int[] strategy) {
//        this.name = name;
//        this.id = id;
//        this.idx = idx;
//        this.point = point;
//        this.strategy = strategy;
//    }
//}
//
//public class Main {
//    static int N, K, arr[][], val[], visited[], a_arr[], b_arr[], flag;
//    static Node ziu, A, B;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        K = Integer.parseInt(st.nextToken());
//        flag = 0;
//
//        if (N < K) {
//            System.out.println(0);
//            return;
//        }
//
//        arr = new int[N + 1][N + 1];
//        visited = new int[N];
//        val = new int[N];
//
//        // 가위바위보 상성
//        for (int i = 1; i <= N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 1; j <= N; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        a_arr = new int[20];
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < 20; i++) {
//            a_arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        b_arr = new int[20];
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < 20; i++) {
//            b_arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//
//        perm(0);
//        System.out.println(flag);
//    }
//
//    static void perm(int cnt) {
//        if (cnt == N) {
//            // 지우, A, B가 게임을 한다.
//            ziu = new Node("지우", 0, 0, 0, val);
//            A = new Node("경희", 1, 0, 0, a_arr);
//            B = new Node("민호", 2, 0, 0, b_arr);
//
////            System.out.println(Arrays.toString(val));
//            rsp(0, ziu, A);
////            System.out.println("==== 경기종료! ====");
////            System.out.println();
//
//            if (flag == 1) {
//                return;
//            }
//            return;
//        }
//
//        for (int i = 0; i < N; i++) {
//            if (visited[i] != 0) {
//                continue;
//            }
//
//            visited[i]++;
//            val[cnt] = i + 1;
//            perm(cnt + 1);
//            visited[i]--;
//            val[cnt] = 0;
//        }
//    }
//
//    static void rsp(int cnt, Node first, Node second) {
////        if (cnt == 3 * (K - 1) + 1) {
////            return;
////        }
//
//        if (first.point == K) {
//            System.out.println("승자는 " + first.name + " 입니다!");
//            System.out.println(first.idx);
//            System.out.println(first.id);
//            System.out.println(Arrays.toString(val));
//            // 지우가 우승한 경우
//            if (first.id == 0 && first.idx == N) {
//                System.out.println("지우가 " + (first.idx+1) + " 까지만 내고 우승함!" + ", " + cnt);
//                System.out.println("지우: " + ziu.point);
//                System.out.println("경희: " + A.point);
//                System.out.println("민호: " + B.point);
//                System.out.println(Arrays.toString(val));
//                System.out.println();
//                flag = 1;
//            }
//            return;
//        }
//
//        if (second.point == K) {
//            System.out.println("승자는 " + second.name + " 입니다!");
//            System.out.println(second.idx);
//            System.out.println(second.id);
//            System.out.println(Arrays.toString(val));
//            // 지우가 우승한 경우
//            if (second.id == 0 && second.idx == N) {
//                System.out.println("지우가 " + (second.idx+1) + " 까지만 내고 우승함!" + ", " + cnt);
//                System.out.println("지우: " + ziu.point);
//                System.out.println("경희: " + A.point);
//                System.out.println("민호: " + B.point);
//                System.out.println(Arrays.toString(val));
//                System.out.println();
//                flag = 1;
//            }
//            return;
//        }
//
//        if (ziu.idx == N) {
//            System.out.println("지우가 승리할 수 없으므로 경기를 종료합니다!");
//            return;
//        }
//
//        System.out.println(first.name + ", " + second.name + " 의 경기를 진행합니다!");
//
//
//        int f = first.strategy[first.idx++];
//        int s = second.strategy[second.idx++];
//
////        System.out.println(first.name + "가 낸 숫자: " + f);
////        System.out.println(second.name + "가 낸 숫자: " + s);
//
//        Node winner = null;
//
////        System.out.println(arr[f][s]);
//        switch (arr[f][s]) {
//            // f가 졌을 때
//            case 0:
//            // f가 비겼을 때
//            case 1:
//                second.point++;
//                winner = second;
//                break;
//
//            // f가 이겼을 때
//            case 2:
//                first.point++;
//                winner = first;
//                break;
//        }
//
//        Node next_challenger = null;
//        for (int i = 0; i < 3; i++) {
//            if (first.id != i && second.id != i) {
//                switch (i) {
//                    case 0: // 지우
//                        next_challenger = ziu;
//                        break;
//                    case 1: // A
//                        next_challenger = A;
//                        break;
//                    case 2: // B
//                        next_challenger = B;
//                        break;
//                }
//                break;
//            }
//        }
//
////        System.out.println(winner.name + " 가(이) 승리했습니다! 다음 도전자는 " + next_challenger.name + " 입니다!");
////        System.out.println("지우: " + ziu.point);
////        System.out.println("경희: " + A.point);
////        System.out.println("민호: " + B.point);
////        System.out.println();
//        rsp(cnt + 1, winner, next_challenger);
//    }
//}
//
//
//// N: 3 K: 2
//// 0: 패배, 1: 비김, 2: 우승
////    1 2 3
//// 1: 1 0 2
//// 2: 2 1 0
//// 3: 0 2 1
//
//// 순열, K번만 이기면 우승.
//
//// 1 2 3
//// 1 2
//// 1 3
//// 2 1
//// 2 3
//// 3 1
//// 3 2
//
//// 0- 지우: 3 1 2
//// 1- 경희: 2 [2] 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
//// 2- 민호: [3] 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3 3
//
//// 지우:0 / 경희:1 / 민호:0
//// 지우 vs 경희 : 3-2 지우 승
//// 지우 vs 민호 : 1-3 지우 승
//// 민호 vs 지우 : 3-1 지우 승
//// 지우 vs 경희 : 3-2 지우 승
//
//// 지우:0 / 경희:1 / 민호:0
//// 지우 vs 경희 : 2-2 경희 승
//// 경희 vs 민호 : 2-3 민호 승
//// 민호 vs 지우 : 3-1 지우 승
//// 지우 vs 경희 : 3-2 지우 승
//
//// 1, 4, 2, 5, 7, 9, 3, 6, 8