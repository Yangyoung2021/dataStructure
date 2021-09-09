package dateSource.leecode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LongStr {

    @Test
    public void test(){
        String s = "abcd";
        int i = longestStr(s);
//        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    private int longestStr1(String s) {
        /*
        一旦碰到重复的字母即重新开始插入，并保留最大值
        具体逻辑：
            如果存在当前键，
            1.拿到上一个集合的大小，拿到当前集合的大小，保留两者中较大的哪个值
         */
        if (s.equals("")) return 0;
        Map<Character, Character> map = new HashMap<>();
        int max = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //先判断是否存在当前键，存在就重新创建集合
            if (map.get(c) != null){
                //记录上次出现的索引
                index = i - index;
                //先拿到之前的集合大小
                max = Math.max(max, map.size());
                map = new HashMap<>();
                for (int j = index; j <= i; j++) {
                    map.put(s.charAt(j), s.charAt(j));
                }
            }
            map.put(c, c);
        }
        max = Math.max(max, map.size());
        return max;
    }

    public int longestStr(String s){
        if (s.equals("")) return 0;
        int prev = 0;
        int index = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        do {
            for (int i = index; i < s.length(); i++) {
                char c = s.charAt(i);
                //先判断是否存在当前键，存在就重新创建集合
                if (map.get(c) != null) {
                    //记录上次出现的索引
                    prev = map.get(c);
                    //先拿到之前的集合大小
                    max = Math.max(max, map.size());
                    map = new HashMap<>();
                    index = prev + 1;
                    break;
                }
                map.put(c, i);
                index++;
            }
        } while (index != s.length());
        max = Math.max(max, map.size());
        return max;
    }
}
