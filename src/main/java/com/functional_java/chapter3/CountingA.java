package com.functional_java.chapter3;

public class CountingA implements Compositor<String, Integer>{

    @Override
    public Integer apply(String string) {

        int cnt = 0;
        for (char s : string.toCharArray()) {
            if (s == 'a') {
                cnt += 1;
            }
        }

        return cnt;
    }

}


