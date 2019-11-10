package cn.junwork.algorithm.leetcode;

/**
 * <a href="https://leetcode.com/problems/maximal-rectangle/">85. Maximal Rectangle</a>
 * <pre>
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2019-03-13
 */
public class Q85_MaximalRectangle {

    private Q84_LargestRectangleInHistogram largestRectangleInHistogram = new Q84_LargestRectangleInHistogram();

    /**
     * <p>从题目不难看出，结果一定是某一行向上的柱形图中圈出来的面积最大的矩形。
     * <p>所以依次算出每一行的柱形图heights，再求柱形图最大矩形，比较每一行的结果即可得出最大值。
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int max = 0;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                heights[j] = (matrix[i][j] == '0') ? 0 : heights[j] + 1;
            }
            max = Math.max(max, largestRectangleInHistogram.largestRectangleArea(heights));
        }
        return max;
    }
}
