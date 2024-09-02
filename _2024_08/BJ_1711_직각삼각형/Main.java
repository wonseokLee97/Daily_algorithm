package com.ssafy._2024_08.BJ_1711_직각삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static List<Pos> list;
    static int visited[], N, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        visited = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Pos(x, y));
        }

        comb(0, 0);

        System.out.println(ans);
    }

    static void comb(int start, int cnt) {
        if (cnt == 3) {
            triangle();
        }

        for (int i = start; i < N; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            comb(i, cnt + 1);
            visited[i] = 0;
        }
    }

    static void triangle() {
        List<Pos> posList = new ArrayList<>();
        List<Integer> iList = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 1) {
                posList.add(list.get(i));
            }
        }

        for (int i = 0; i < 3; i++) {
            Pos posA = posList.get(i);
            for (int j = i + 1; j < 3; j++) {
                Pos posB = posList.get(j);
                iList.add((int) (Math.pow(posA.x - posB.x, 2) + Math.pow(posA.y - posB.y, 2)));
            }
        }

        Collections.sort(iList);

        // 피타고라스 법칙
        if (iList.get(2) == iList.get(1) + iList.get(0)) {
            ans++;
        }
    }
}

// 1, 2, 1
// (-1,1) (-1,0) (0,0)

// 7, [1, 5], 3

// -1 1, [-1, 0], [0, 0], [1, 0], [1, 1]
//           1     루트2    루트5     2

// -1 0
// 0 0
// 1 0
// 1 1

// 4c2 = 43/2
// 1500!/1497! * 3!

// (1500 * 1499 * 1498) / 6