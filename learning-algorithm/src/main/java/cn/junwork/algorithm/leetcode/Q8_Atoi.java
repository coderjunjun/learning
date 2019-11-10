package cn.junwork.algorithm.leetcode;

/**
 * <a href="https://leetcode.com/problems/string-to-integer-atoi/description/">8. String to Integer (atoi)</a>
 * <p>
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then,
 * starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values,
 * INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class Q8_Atoi {
    
    public static void main(String[] args) {
        Q8_Atoi solution = new Q8_Atoi();
        System.out.println(solution.myAtoiDev("  -0012a42"));
    }
    
    
    public int myAtoi(String str) {
        int sign = 1;
        int i = 0;
        long value = 0;
        
        str = str.trim();
        if (str.length() > 0) {
            if (str.charAt(0) == '+') {
                sign = 1;
                ++i;
            } else if (str.charAt(0) == '-') {
                sign = -1;
                ++i;
            }
            
            for (; i < 12 && i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'; ++i) {
                value = value * 10 + sign * (str.charAt(i) - '0');
            }
        }
        
        if (value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE) {
            return (int) value;
        } else { //溢出
            return value < Integer.MIN_VALUE ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
    
    
    public int myAtoiDev(String str) {
        str = str.trim();
        if (!str.matches("[+|-]?\\d+.*")) return 0;
        try {
            str = str.charAt(0) + str.substring(1, str.length()).replaceAll("\\D.*", "");
            return Integer.parseInt(str);
        } catch (Exception e) {
            return str.startsWith("-") ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}
