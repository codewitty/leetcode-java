import java.util.*;

class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length(), sign = 1;
        while (i < n && s.charAt(i) == ' ') i++;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) sign = s.charAt(i++) == '-' ? -1 : 1;
        long result = 0;
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            result = result * 10 + (s.charAt(i++) - '0');
            if (result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int) (result * sign);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("42"));
        System.out.println(s.myAtoi("   -042"));
        System.out.println(s.myAtoi("1337c0d3"));
        System.out.println(s.myAtoi("-91283472332"));
    }
}
