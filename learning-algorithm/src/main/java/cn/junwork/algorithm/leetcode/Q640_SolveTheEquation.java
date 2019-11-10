package cn.junwork.algorithm.leetcode;

/**
 * <a href="https://leetcode.com/problems/solve-the-equation/description/">640. Solve the Equation</a>
 * <p>
 * Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.
 * <p>
 * If there is no solution for the equation, return "No solution".
 * <p>
 * If there are infinite solutions for the equation, return "Infinite solutions".
 * <p>
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 * <p>
 * Example 1:
 * Input: "x+5-3+x=6+x-2"
 * Output: "x=2"
 * <p>
 * Example 2:
 * Input: "x=x"
 * Output: "Infinite solutions"
 * <p>
 * Example 3:
 * Input: "2x=x"
 * Output: "x=0"
 * <p>
 * Example 4:
 * Input: "2x+3x-6x=x+2"
 * Output: "x=-1"
 * <p>
 * Example 5:
 * Input: "x=x+2"
 * Output: "No solution"
 */
public class Q640_SolveTheEquation {
    
    public static void main(String[] args) {
        Q640_SolveTheEquation s = new Q640_SolveTheEquation();
        System.out.println(s.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(s.solveEquation("x=x"));
        System.out.println(s.solveEquation("2x=x"));
        System.out.println(s.solveEquation("2x+3x-6x=x+2"));
        System.out.println(s.solveEquation("x=x+2"));
    }
    
    
    public String solveEquation(String equation) {
        int xCo = 0; //x的系数和（移项到左边）
        int constant = 0; //常数和（移项到右边）
        int itemSign = 1; //每一项的符号，模拟等式两边移项
        
        for (int i = 0; i < equation.length(); ) {
            if (equation.charAt(i) == '=') {
                itemSign = -1;
                ++i;
                continue;
            }
            
            String item = pickItem(equation, i);
            if (item.contains("x")) {
                xCo += itemSign * getCo(item);
            } else {
                constant -= itemSign * Integer.parseInt(item);
            }
            i += item.length();
        }
        
        if (xCo == 0 && constant == 0) {
            return "Infinite solutions";
        }
        if (xCo == 0 && constant != 0) {
            return "No solution";
        }
        
        return "x=" + constant / xCo;
    }
    
    
    private String pickItem(String s, int start) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(start));
        
        for (int i = start + 1; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '=') {
                break;
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
    
    
    /**
     * 获取系数
     *
     * @param item
     * @return
     */
    private int getCo(String item) {
        String sCo = item.replace("x", "");
        if (sCo.length() == 0 || sCo.charAt(sCo.length() - 1) < '0' || sCo.charAt(sCo.length() - 1) > '9') {
            sCo += "1";
        }
        return Integer.parseInt(sCo);
    }
}
