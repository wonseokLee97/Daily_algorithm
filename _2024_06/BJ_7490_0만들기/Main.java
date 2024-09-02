package com.ssafy._2024_06.BJ_7490_0만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, visited[];
    static List<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            list = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            visited = new int[N - 1]; // 기호
            comb(0, 0);

            Collections.sort(list);

            for (String ans : list) {
                System.out.println(ans);
            }
            System.out.println();
        }
    }

    static void comb(int cnt, int start) {
        if (cnt == N - 1) {
            int idx = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= N; i++) {
                sb.append(i);

                if (idx < N - 1) {
                    int v = visited[idx++];

                    switch (v) {
                        case 1: // +
                            sb.append("+");
                            break;
                        case 2: // -
                            sb.append("-");
                            break;
                        case 3: // 공백(합치기)
                            sb.append(" ");
                            break;
                    }
                }
            }

            char[] c_arr = sb.toString().toCharArray();

            Stack<String> stack = new Stack<>();

            for (int i = 0; i < c_arr.length; i++) {
                char c = c_arr[i];

                int flag = 0;
                switch (c) {
                    case '+':
                    case '-':
                    case ' ':
                        flag = 1;
                        stack.push(String.valueOf(c));
                        break;
                }

                // 숫자인 경우
                if (flag == 0) {
                    // 스택에 뭐가 들어있고, 마지막으로 들어온게 공백이면
                    if (!stack.isEmpty() && stack.peek().equals(" ")) {
                        StringBuilder sb2 = new StringBuilder();
                        stack.pop(); // 공백 제거
                        String prev_val = stack.pop();
                        sb2.append(prev_val);
                        sb2.append(c_arr[i]);

                        stack.push(sb2.toString());
                    } else {
                        stack.push(String.valueOf(c));
                    }
                }
            }

            // 1-23-45+67
            // 공백의 경우 가장 먼저 연산을 수행해야 한다.
            // 이외의 경우 연산을 하고 다시 넣는다.
            int total = Integer.parseInt(stack.get(0));

            for (int i = 1; i < stack.size();) {
                String m = stack.get(i);
                if (m.equals("+")) {
                    int now_val = Integer.parseInt(stack.get(i + 1));
                    total += now_val;
                    i += 2;

                } else if (m.equals("-")) {
                    int now_val = Integer.parseInt(stack.get(i + 1));
                    total -= now_val;
                    i += 2;
                }
            }


            if (total == 0) {
                list.add(sb.toString());
            }

            return;
        }


        for (int i = start; i < N - 1; i++) {
            if (visited[i] != 0) {
                continue;
            }

            for (int j = 1; j <= 3; j++) {
                visited[i] = j;
                comb(cnt + 1, start + 1);
                visited[i] = 0;
            }
        }
    }
}

// 1 2 3
// 조합 (순서상관 O, 중복 X)
// 1-23-45+67