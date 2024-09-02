package com.ssafy._2023._2023_07.day_07_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int weight;
    int price;

    public Node(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Node o) {
        // 무게가 같다면, 가격이 더 싼 것을 골라!
        if (price == o.price) {
            return Integer.compare(o.weight, weight);
        } else {
            return Integer.compare(price, o.price);
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "weight=" + weight +
                ", price=" + price +
                '}';
    }
}

public class BJ_2285_정육점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int min_val = Integer.MAX_VALUE;
        int totalWeight = 0;
        int totalPrice = 0;
        int flag = 0;

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            list.add(new Node(w, p));
        }

        Collections.sort(list);

        int idx = 0;
        for (Node node : list) {
            System.out.println(node);
            totalWeight += node.weight;
            System.out.println(totalWeight);

            // 1번째 인덱스부터, 이전과 같은 가격의 고기인 경우
            if (idx > 0 && list.get(idx).price == list.get(idx - 1).price) {
                totalPrice += list.get(idx).price;
            }
            // 이전과 가격이 다르다면, 지금이 더 비싼 가격의 고기이다.(지금을 기준으로 이전의 고기들을 무료로 매입)
            else {
                totalPrice = list.get(idx).price;
            }

            // 더 싼가격에 기준보다 같거나 많은 고기를 구매하는 경우를 찾는다.
            if (totalWeight >= M) {
                flag = 1;
                min_val = Math.min(min_val, totalPrice);
            }

            idx++;
        }

        if (flag == 1) {
            System.out.println(min_val);
        } else  {
            System.out.println(-1);
        }
    }
}

// 무게는 무거울수록, 가격은 쌀수록 좋다.

//5 9
//1 2
//2 4
//3 6
//3 5
//4 6

//3 8
//3 2
//4 2
//1 4