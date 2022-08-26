package com.ssafy.day_220823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Shark implements Comparable<Shark> {
    int x, y, cnt;
    int size = 2; // default
    int eat = 0;

    public Shark(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Shark(int x, int y, int cnt, int size, int eat) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.size = size;
        this.eat = eat;
    }

    public void eat() {
        if (eat == size) {
            eat = 0;
            size++;
        }
    }

    @Override
    public int compareTo(Shark o) {
        return this.cnt == o.cnt ?
                this.x == o.x ?
                        this.y - o.y : this.x - o.x : this.cnt - o.cnt;
//        return this.x == o.x ? this.y - o.y : this.x - o.x;
    }
}

public class BJ_16236_아기상어_이원석 {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] arr, v;
    static int N, flag, result;
    static Shark shark;
    static List<Shark> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int get = Integer.parseInt(st.nextToken());

                if (get == 9) {
                    shark = new Shark(i, j);
                }
                arr[i][j] = get;
            }
        }

        while (true) {
            flag = 0;                               // validation 초기화
            v = new int[N][N];                      // 방문배열 초기화
            v[shark.x][shark.y] = 1;                // 시작위치 1로 초기화
            bfs(shark.x, shark.y);                  // bfs
            if (flag == 0) { // 아무 물고기도 찾지 못했을 때
                break;
            }
            Collections.sort(list);                 // 정렬
//            for (Shark s : list) {
//                System.out.println(s.x + ", " + s.y + ", " + s.cnt + ", " + s.size + ", " + s.eat);
//            }
            shark = list.get(0);                    // 다음 상어의 위치
            shark.eat++;                            // 단백질 섭취
            shark.eat();                            // 벌크업 확인
            arr[shark.x][shark.y] = 0;              // 잡아먹힌 물고기 삭제
            result += shark.cnt - 1;
        }

        System.out.println(result);
    }

    public static void bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b});
        list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 범위 안일 때,
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    // 물고기라면,
                    if (1 <= arr[nx][ny] && arr[nx][ny] <= 6) {
                        if (v[nx][ny] == 0) {
                            switch (check(nx, ny)) {
                                case 1: // 상어의 크기가 더 클 때,
                                    flag = 1; // 먹이가 더 이상 없는지 validation
                                    v[nx][ny] = v[x][y] + 1;
                                    list.add(new Shark(nx, ny, v[nx][ny], shark.size, shark.eat));
                                    queue.add(new int[]{nx, ny});
                                    break;
                                case 2: // 상어와 물고기의 크기가 같을 때,
                                    v[nx][ny] = v[x][y] + 1;
                                    queue.add(new int[]{nx, ny});
                                    break;
                                case 3: // 상어가 더 작을 때,
                                    break;
                            }
                        }
                    } else { // 물고기가 아니라면
                        if (v[nx][ny] == 0) {
                            v[nx][ny] = v[x][y] + 1;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }

    public static int check(int x, int y) {
        if (arr[x][y] < shark.size) { // 상어의 크기가 더 클 때,
            return 1;
        } else if (arr[x][y] == shark.size) { // 상어와 물고기의 크기가 같을 때,
            return 2;
        } else { // 상어가 더 작을 때,
            return 3;
        }
    }
}

//class Shark {
//    int size = 2;
//    int eat = 0;
//    int x, y, time = 0;
//
//    public void check() {
//        if (eat == size) { // 자신의 크기만큼 물고기를 먹었다면,
//            size++;
//            eat = 0;
//        }
//    }
//}
//
//class Fish implements Comparable<Fish> {
//    int x, y;
//
//    public Fish(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    @Override
//    public int compareTo(Fish o) {
//        return this.x == o.x ? this.y - o.y : this.x - o.x;
//    }
//}
//
//public class BJ_16236_아기상어_이원석 {
//    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
//    static int[][] arr, visited;
//    static int N, flag, keep;
//    static List<Fish> list;
//    static Shark shark = new Shark();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        N = Integer.parseInt(br.readLine());
//        arr = new int[N][N];
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                int get = Integer.parseInt(st.nextToken());
//                arr[i][j] = get;
//
//                if (get == 9) { // 상어의 위치
//                    shark.x = i;
//                    shark.y = j;
//                }
//            }
//        }
//
//        while (true) {
//            flag = 0;
//            keep = 0;
//            visited = new int[N][N];
//            visited[shark.x][shark.y] = 1;
//
//            System.out.println(shark.x + ", " + shark.y + ", " + shark.size);
//            bfs(shark.x, shark.y);
//
//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(visited[i]));
//            }
//
//            Collections.sort(list);
//
//            arr[list.get(0).x][list.get(0).y] = 0;
//            shark.eat++;
//            shark.check(); // 먹은 크기 확인
//            shark.x = list.get(0).x;
//            shark.y = list.get(0).y;
//            shark.time += visited[shark.x][shark.y] - 1;
//
//
//            System.out.println(shark.time);
//            System.out.println();
//            for (int i = 0; i < N; i++) {
//                System.out.println(Arrays.toString(arr[i]));
//            }
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    if (arr[i][j] == 0) {
//                        continue;
//                    } else if (arr[i][j] < shark.size) { // 사냥감이 있으면 계속 loop
//                        keep = 1;
//                    }
//                }
//            }
//
//            if (keep == 0) { // 없으면 break
//                break;
//            }
//            System.out.println();
//        }
//    }
//
//    public static void bfs(int a, int b) {
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{a, b});
//        list = new ArrayList<>();
//        int time = 0;
//
//        while (!queue.isEmpty()) {
////            for (int i = 0; i < N; i++) {
////                System.out.println(Arrays.toString(visited[i]));
////            }
////            System.out.println();
//            int[] poll = queue.poll();
//            int x = poll[0];
//            int y = poll[1];
//
//            for (int i = 0; i < 4; i++) {
//                int nx = x + dx[i];
//                int ny = y + dy[i];
//
//                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
//                    // 움직인 칸에 물고기가 있다면,
//                    if (1 <= arr[nx][ny] && arr[nx][ny] <= 6) {
//
//                        switch (validate(nx, ny)) {
//                            case 0: // 물고기가 더 크다면,
//                                break;
//                            case 1: // 크기가 같다면
//                                if (visited[nx][ny] >= 1) {
//                                    break;
//                                }
//                                visited[nx][ny] = visited[x][y] + 1;
//                                queue.add(new int[]{nx, ny});
//                                break;
//                            case 2: // 상어의 몸집이 더 크다면
//                                visited[nx][ny] = visited[x][y] + 1;
//                                flag = 1;
//                                if (list.size() == 0) { // 최초로 잡은 물고기
//                                    time = visited[nx][ny];
//                                    list.add(new Fish(nx, ny));
//                                } else {
//                                    if (time == visited[nx][ny]) {
//                                        list.add(new Fish(nx, ny));
//                                    }
//                                }
//                                break;
//                        }
//
//                    } else if (arr[nx][ny] == 0 || arr[nx][ny] == 9) {
//                        if (visited[nx][ny] == 0) {
//                            visited[nx][ny] = visited[x][y] + 1;
//                        } else {
//                            visited[nx][ny] = Math.min(visited[nx][ny], visited[x][y] + 1);
//                        }
//
//                        if (flag == 0) {
//                            queue.add(new int[]{nx, ny});
//                        }
//                    }
//                }
//            }
//        }
//
//        if (list.size() > 1) { // 여러개의 물고기를 잡았다면
//            Collections.sort(list);
//        }
//
//    }
//
//    public static int validate(int nx, int ny) {
//        if (arr[nx][ny] < shark.size) { // 상어의 몸집이 더 크다면,
//            return 2;
//        } else if (arr[nx][ny] > shark.size) { // 물고기가 더 크다면,
//            return 0;
//        } else { // 크기가 같다면
//            return 1;
//        }
//    }
//}
//
////    [0, 0, 0, 0, 0, 0]
////    [3, 0, 0, 0, 0, 0]
////    [2, 3, 0, 0, 0, 0]
////    [1, 2, 0, 0, 0, 0]
////    [2, 0, 0, 0, 0, 0]
////    [0, 0, 0, 0, 0, 0]
////    1
////    26
////
////    [5, 0, 0, 0, 0, 4]
////    [0, 0, 0, 0, 4, 5]
////    [0, 0, 9, 5, 6, 6]
////    [0, 0, 0, 3, 4, 5]
////    [0, 2, 0, 6, 5, 4]
////    [6, 6, 6, 6, 6, 6]