package com.ssafy._2024_08.BJ_21276_계보복원가호석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<String> nameList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nameList.add(st.nextToken());
        }

        Collections.sort(nameList);

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(nameList.get(i), i);
        }

        // 진입차수
        int[] degree = new int[N];

        // 부모 그래프
        List<List<Integer>> parentGraph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            parentGraph.add(new ArrayList<>());
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken(); // child
            String p = st.nextToken(); // parent

            int cIdx = map.get(c);
            int pIdx = map.get(p);

            // 부모-자식
            parentGraph.get(pIdx).add(cIdx);
            // 자식 노드의 진입차수 증가.
            degree[cIdx]++;
        }

        List<String> p = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (degree[i] == 0) {
                pq.offer(i);
                p.add(nameList.get(i));
            }
        }

        Collections.sort(p);

        // 자식 그래프
        List<List<Integer>> childGraph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            childGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            // 현재 진입차수가 0인 노드
            int nowNode = pq.poll();

            // 간선을 끊을 다음 노드들
            List<Integer> nextNodes = parentGraph.get(nowNode);
            for (int nextNode : nextNodes) {
                // 진입차수가 0인경우,
                if (--degree[nextNode] == 0) {
                    // nowNode 의 자식으로 간주한다.
                    childGraph.get(nowNode).add(nextNode);
                    pq.offer(nextNode);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(p.size()).append("\n");
        for (String s : p) {
            sb.append(s).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < childGraph.size(); i++) {
            List<Integer> list = childGraph.get(i);
            sb.append(nameList.get(i)).append(" ");
            sb.append(childGraph.get(i).size()).append(" ");

            Collections.sort(list);

            for (int idx : list) {
                sb.append(nameList.get(idx)).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

// daeil:  hoseok
// sangdo: hoseok, daeil
// yuri:
// hoseok:
// minji:  doha, haeun
// doha:   haeun
// haeun:

// hoseok sangdo
// hoseok daeil

// yuri minji

// daeil sangdo

// doha minji

// haeun doha
// haeun minji