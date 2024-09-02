package com.ssafy._2023._2023_07.day_07_28;

import java.util.*;
import java.io.*;

public class PG_파일명정렬 {
    class Node implements Comparable<Node> {
        String HEAD;
        int NUMBER;
        String TAIL;
        String fileName;

        public Node (String HEAD, int NUMBER, String TAIL, String fileName) {
            this.HEAD = HEAD;
            this.NUMBER = NUMBER;
            this.TAIL = TAIL;
            this.fileName = fileName;
        }

        @Override
        public int compareTo(Node o) {
            // head 사전순으로 정렬, head값이 다르다면 비교한다.
            if (!this.HEAD.equals(o.HEAD)) {
                return this.HEAD.compareTo(o.HEAD);
            }
            // number 오름차순 정렬, number 값이 다르다면 비교한다.
            else if (this.NUMBER != o.NUMBER) {
                return Integer.compare(this.NUMBER, o.NUMBER);
            } else {
                return 0;
            }
        }
    }

    class Solution {
        public String[] fileSort(String[] files) {
            String[] answer = {};
            List<Node> list = new ArrayList<>();

            System.out.println('1' - '0');
            System.out.println('a' - '0');
            System.out.println('z' - '0');
            System.out.println('A' - '0');
            System.out.println('Z' - '0');
            System.out.println(' ' - '0');
            System.out.println('-' - '0');
            System.out.println('.' - '0');

            for (String f : files) {
                StringBuilder HEAD = new StringBuilder();
                StringBuilder NUMBER = new StringBuilder();
                StringBuilder TAIL = new StringBuilder();

                char[] fileName = f.toCharArray();
                int flag = 0;

                for (int i = 0; i < fileName.length; i++) {
                    int get = fileName[i] - '0';

                    // NUMBER 찾기
                    if (flag == 1) {
                        // 영어 대소문자, 공백, -
                        if ((get >= 17 && get <= 42) || (get >= 49 && get <= 74) || get == -16 || get == -3 || get == -2) {
                            flag = 2;
                            TAIL.append(fileName[i]);
                        } else {
                            NUMBER.append(fileName[i]);
                        }
                    }
                    // TAIL 찾기
                    else if (flag == 2) {
                        TAIL.append(fileName[i]);
                    }
                    // HEAD 찾기
                    else {
                        // 알파벳일 경우
                        if ((get >= 17 && get <= 42) || (get >= 49 && get <= 74) || get == -16 || get == -3 || get == -2) {
                            HEAD.append(fileName[i]);
                        } else { // 숫자인 경우
                            flag = 1;
                            NUMBER.append(fileName[i]);
                        }
                    }
                }

//             System.out.println(HEAD);
//             System.out.println(NUMBER);
//             System.out.println(TAIL);
//             System.out.println();

                int num = Integer.parseInt(NUMBER.toString());

                Node node = new Node(HEAD.toString().toLowerCase(), num, TAIL.toString().toLowerCase(), f);
                list.add(node);
            }

            Collections.sort(list);

            answer = new String[list.size()];

            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i).fileName;
            }


            return answer;
        }
    }
}
