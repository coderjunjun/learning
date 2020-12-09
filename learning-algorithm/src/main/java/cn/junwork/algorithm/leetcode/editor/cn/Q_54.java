//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组 
// 👍 542 👎 0

package cn.junwork.algorithm.leetcode.editor.cn;

import java.util.*;

public class Q_54 {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int topBound = 0, rightBound = matrix[0].length - 1, bottomBound = matrix.length - 1, leftBound = 0;
        while (topBound <= bottomBound && leftBound <= rightBound) {
            for (int j = leftBound; j <= rightBound; ++j) {
                result.add(matrix[topBound][j]);
            }
            for (int i = topBound + 1; i <= bottomBound; ++i) {
                result.add(matrix[i][rightBound]);
            }
            for (int j = rightBound - 1; j >= leftBound; --j) {
                result.add(matrix[bottomBound][j]);
            }
            for (int i = bottomBound - 1; i > topBound; --i) {
                result.add(matrix[i][leftBound]);
            }
            ++leftBound;
            --rightBound;
            ++topBound;
            --bottomBound;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}