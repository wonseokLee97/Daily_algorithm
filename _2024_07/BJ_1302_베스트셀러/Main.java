package com.ssafy._2024_07.BJ_1302_베스트셀러;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    String name;
    int cnt;

    public Node(String name, int cnt) {
        this.name = name;
        this.cnt = cnt;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String book = br.readLine();
            if (!map.containsKey(book)) {
                map.put(book, 1);
            } else {
                map.put(book, map.get(book) + 1);
            }
        }

        List<Node> list = new ArrayList<>();
        for (String book : map.keySet()) {
            list.add(new Node(book, map.get(book)));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.cnt == o2.cnt) {
                    return o1.name.compareTo(o2.name);
                } else {
                    return o2.cnt - o1.cnt;
                }
            }
        });

        System.out.println(list.get(0).name);
    }
}
