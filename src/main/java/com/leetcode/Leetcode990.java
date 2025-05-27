package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode990 {

    public boolean equationsPossible(String[] equations) {

            Map<Character, Integer> visitedChars = new HashMap<>();

            Set<String> validEq = new HashSet<>();

            StringBuilder sb;

            int value = 0;

            for (int i = 0; i < equations.length; i++) {
                if (validEq.contains(equations[i]))
                    continue;

                //split into 4 parts
                char u = equations[i].charAt(0);
                char equality = equations[i].charAt(1);
                char v = equations[i].charAt(1);

                int uvalue, vvalue;
                //fetch the values of u and v and if they are not present then put it in visited map
                if (visitedChars.containsKey(u)) {
                    uvalue = visitedChars.get(u);
                } else {
                    uvalue = value++;
                    visitedChars.put(u, value);
                }
                if (visitedChars.containsKey(v)) {
                    vvalue = visitedChars.get(v);
                } else {
                    if (equality == '!')
                        vvalue = value++;
                    else
                        vvalue = value;
                    visitedChars.put(v, value);
                }


                if (equality == '!') {
                    if (uvalue != vvalue) {

                        validEq.add(equations[i]);
                        sb = new StringBuilder(v).append("!=").append(u);
                        validEq.add(sb.toString());
                    } else {
                        System.out.println("Valid eq when ! " +validEq.toString());
                        return false;
                    }
                } else {
                    if (uvalue == vvalue) {
                        validEq.add(equations[i]);
                        sb = new StringBuilder(v).append("==").append(u);
                        validEq.add(sb.toString());
                    } else {
                        System.out.println("Valid eq when = " + validEq.toString());

                        return false;
                    }
                }
            }

            return true;
        }

    }


