package com.ssafy.toss;

import java.util.*;


public class po3 {

    static String[] merchantNames;
    static int max_idx;

    public static void main(String[] args) {
        merchantNames = new String[]{
//                "비바리퍼블리", "토스커피사일로 베이커리", "비바리퍼블리카 식당", "토스커피사일", "토스커피사일로 베이커", "비바리퍼블리카식", "토스커피사일로 베이", "토스커피사일로.베이커리", "토스커피사일로&베이커리"
                "토스커피사일로 베이커리", "토스커피사일", "토스커피사일로 베이커", "토스커피사일로 베이", "토스커피사일로&베이커리"
        };


        String[] symbol = new String[]{"&", "(", ")", "-", "."};
        HashMap<String, Integer> map = new HashMap<>();

        String[] merchantNamesClone = merchantNames.clone();
        Arrays.sort(merchantNamesClone, (String s1, String s2) -> s2.length() - s1.length());



        for (int i = 0; i < merchantNamesClone.length; i++) {
            int flag = 0;

            String[] split = null;

            if (merchantNamesClone[i].contains(" ")) {
                split = merchantNamesClone[i].split(" ");
                for (String key : map.keySet()) {
                    if (key.contains(split[0])) {
                        flag = 1;
                        break;
                    }
                }
            } else {
                int find = 0;

                for (String s : symbol) {
                    if (merchantNamesClone[i].contains(s)) {
                        find = 1;

                        if (s.equals(".")) {
                            split = merchantNamesClone[i].split("\\.");
                        } else {
                            split = merchantNamesClone[i].split(s);
                        }

                        for (String key : map.keySet()) {
                            if (key.contains(split[0])) {
                                flag = 1;
                                break;
                            }
                        }
                    }
                }

                // 특수기호 및 공백이 없는 문자.
                if (find == 0) {
                    for (String key : map.keySet()) {
                        if (key.contains(merchantNamesClone[i])) {
                            flag = 1;
                            break;
                        } else if (merchantNamesClone[i].contains(key)) {
                            if (map.get(key) > merchantNamesClone[i].length()) {
                                flag = 1;
                                break;
                            }
                        }
                    }
                }
            }

            if (flag == 0) {
//                System.out.println(split[0] + ", " + i + " 번째 " + merchantNamesClone[i]);
                map.put(split[0], merchantNamesClone[i].length());
            }
        }



        HashMap<String, Integer> ans = new HashMap<>();

        for (String key : map.keySet()) {
            for (int i = 0; i < merchantNames.length; i++) {
                // key 의 길이와 같고, key 를 포함하고 있는 점포
                if (map.get(key) == merchantNames[i].length() && merchantNames[i].contains(key)) {
                    // 아직 정답에 저장이 되지 않았다면
                    if (ans.get(key) == null) {
                        // 특수기호를 포함한 정답이 없다면
                        if (ans.get(key + "@") == null) {
                            int flag = 0;

                            for (String s : symbol) {
                                if (merchantNames[i].contains(s)) {
                                    flag = 1;
                                    break;
                                }
                            }

                            // 만약 특수기호를 포함했다면
                            if (flag == 1) {
                                ans.put(key + "@", i);
                            } else {
                                ans.put(key, i);
                            }
                        }

                    }
                    // 정답이 이미있는 경우
                    else if (ans.get(key) != null) {
                        int flag = 0;

                        for (String s : symbol) {
                            if (merchantNames[i].contains(s)) {
                                flag = 1;
                                break;
                            }
                        }

                        // 만약 특수기호를 포함했다면
                        if (flag == 1) {
                            ans.remove(key);
                            ans.put(key + "@", i);
                        } else {
                            ans.put(key, i);
                        }
                    }
                }
            }
        }

        String[] answer = new String[ans.keySet().size()];

        int idx = 0;

        for (String s : ans.keySet()) {
            answer[idx++] = merchantNames[ans.get(s)];
        }

        System.out.println(Arrays.toString(answer));
    }
}
