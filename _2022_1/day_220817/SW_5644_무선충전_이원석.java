package com.ssafy._2022_1.day_220817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class AP{
    int x;
    int y;
    int dis;
    int pow;
    int num;

    public AP(int x, int y, int dis, int pow, int num) {
        this.x = x;
        this.y = y;
        this.dis = dis;
        this.pow = pow;
        this.num = num;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("");
        sb.append(num);
        return sb.toString();
    }
}

public class SW_5644_무선충전_이원석 {
    static int[] dx = new int[]{0, -1, 0, 1, 0};
    static int[] dy = new int[]{0, 0, 1, 0, -1};
    static int[] move_A, move_B;
    static int[][] time_per_charge;
    static ArrayList<AP>[][] arr;
    static int M, result;
    static ArrayList<AP> APs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t < TC + 1; t++) {
            result = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            arr = new ArrayList[11][11];
            move_A = new int[M];
            move_B = new int[M];
            time_per_charge = new int[2][M + 1];
            APs = new ArrayList<>();

            // A의 이동정보
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                move_A[i] = Integer.parseInt(st.nextToken());
            }

            // B의 이동정보
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                move_B[i] = Integer.parseInt(st.nextToken());
            }

            // AP 들의 정보
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int dis = Integer.parseInt(st.nextToken());
                int pow = Integer.parseInt(st.nextToken());

                APs.add(new AP(x, y, dis, pow, i + 1));
            }

            for (AP ap : APs) {
                bfs(ap);
            }

            solution();
            System.out.printf("#%d %d\n",t ,result);
        }
    }

    public static void bfs(AP ap) {
        int[][] visited = new int[11][11];
        int power = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{ap.x, ap.y});
        // 시작점
        if (arr[ap.x][ap.y] == null) {
            arr[ap.x][ap.y] = new ArrayList<>();
        }

        arr[ap.x][ap.y].add(ap);
        visited[ap.x][ap.y] = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) { // 큐에 들어오는 사이즈 만큼 돌린다.
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];

                for (int j = 1; j < 5; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 1 && nx <= 10 && ny >= 1 && ny <= 10 && visited[nx][ny] == 0) {
                        if (arr[nx][ny] == null) {                // 이동 지점이 null
                            arr[nx][ny] = new ArrayList<>();    // 이동지점에 bc 저장위한 리스트 객체 생성
                        }
                        // 충전기 영역표시
                        arr[nx][ny].add(ap);
                        visited[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            power++;

            if (power == ap.dis) { // 충전기 영역이 끝나면 break
                break;
            }
        }
    }

    public static void solution() {
        int ax = 1, ay = 1, bx = 10, by = 10;
        cal_charge(ax, ay, bx, by);

        for (int i = 0; i < M; i++) {
            int anx = ax + dx[move_A[i]];
            int any = ay + dy[move_A[i]];

            int bnx = bx + dx[move_B[i]];
            int bny = by + dy[move_B[i]];
            cal_charge(anx, any, bnx, bny);
            ax = anx;
            ay = any;

            bx = bnx;
            by = bny;
        }
    }

    public static void cal_charge(int anx, int any, int bnx, int bny) {
        int max_val = Integer.MIN_VALUE;

//        for (int i = 0; i < 11; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
//
//        System.out.println("==============");

        // A, B의 해당 좌표가 충전 영역이라면,
        if (arr[anx][any] != null && arr[bnx][bny] != null) {
            for (AP A : arr[anx][any]) {
                for (AP B : arr[bnx][bny]) {
                    if (A.equals(B)) { // A와 B가 같은 영역에 있다면 뿜빠이
                        max_val = Math.max(max_val, A.pow);
                    } else { // A와 B가 같은 영역에 있지만 서로 다른 영역을 사용하는게 더 클 떄,
                        max_val = Math.max(max_val, A.pow + B.pow);
                    }
                }
            }
        } else if (arr[anx][any] != null) { // A만 해당 좌표가 충전 영역이라면,
            for (AP A : arr[anx][any]) {
                max_val = Math.max(max_val, A.pow);
            }
        } else if (arr[bnx][bny] != null) { // B만 해당 좌표가 충전 영역이라면,
            for (AP B : arr[bnx][bny]) {
                max_val = Math.max(max_val, B.pow);
            }
        } else max_val = 0; // 아무것도 아니라면

        result += max_val;
    }
}




//5
//20 3
//2 2 3 2 2 2 2 3 3 4 4 3 2 2 3 3 3 2 2 3
//4 4 1 4 4 1 4 4 1 1 1 4 1 4 3 3 3 3 3 3
//4 4 1 100
//5 7 3 40
//6 3 2 70
