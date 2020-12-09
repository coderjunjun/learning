//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1988 👎 0

package cn.junwork.algorithm.leetcode.editor.cn;

import java.util.*;

public class Q_20 {
    public static void main(String[] args) {
        boolean valid = (new Q_20()).new Solution()
                .isValid("()");
        System.out.println(valid);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (!stack.isEmpty() && match(stack.peek(), c)){
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean match(char c1, char c2) {
        return c1 == '(' && c2 == ')'
                || c1 == '{' && c2 == '}'
                || c1 == '[' && c2 == ']';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}