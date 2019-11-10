package cn.junwork.algorithm.leetcode;

/**
 * <a href="https://leetcode.com/problems/minimum-cost-for-tickets/">983. Minimum Cost For Tickets</a>
 *
 * <pre>
 * In a country popular for train travel, you have planned some train travelling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in 3 different ways:
 *
 * a 1-day pass is sold for costs[0] dollars;
 * a 7-day pass is sold for costs[1] dollars;
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
 *
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 *
 *
 *
 * Example 1:
 *
 * Input: days = [1,4,6,7,8,20], costs = [2,7,15]
 * Output: 11
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
 * On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
 * On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
 * In total you spent $11 and covered all the days of your travel.
 * Example 2:
 *
 * Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
 * Output: 17
 * Explanation:
 * For example, here is one way to buy passes that lets you travel your travel plan:
 * On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
 * On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
 * In total you spent $17 and covered all the days of your travel.
 *
 *
 * Note:
 *
 * 1 <= days.length <= 365
 * 1 <= days[i] <= 365
 * days is in strictly increasing order.
 * costs.length == 3
 * 1 <= costs[i] <= 1000
 * </pre>
 *
 * @author coderjunjun@gmail.com
 * @date 2019-02-01
 */
public class Q983_MinimumCostForTickets {


    /**
     * <pre>
     * 动态规划的思想：
     * 1.显然，这个问题的子问题是前i天的最少旅行费用minCost[i]
     * 2.对于任意i，如果第i天不出门，那minCost[i] = minCost[i-1]
     * 3.如果第i天要出门，那票可能是今天买的，也可能是昨天或者前天买的，即cost[i] = min(minCost[i − 1], minCost[i − 2], ...) + x，其中x是票价
     * 4.可以发现，minCost是递增的，也就是说票正好在第i天结束，尽量覆盖较多的天数，是最可能省钱的
     * </pre>
     *
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        //minCost[i]表示本年度前i天最少的旅行费用
        int[] minCost = new int[366];
        //标记每一天是否旅行
        boolean[] dayFlag = new boolean[366];
        for (int day : days) {
            dayFlag[day] = true;
        }

        int[] ticketDuration = new int[]{1, 7, 30};
        for (int i = 1; i < minCost.length; ++i) {
            if (dayFlag[i] == false) {
                minCost[i] = minCost[i - 1];
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < ticketDuration.length; ++j) {
                int beforeBuyDay = i - ticketDuration[j] < 0 ? 0 : i - ticketDuration[j];
                int cost = costs[j] + minCost[beforeBuyDay];
                if (cost < min) min = cost;
            }
            minCost[i] = min;
        }

        return minCost[365];
    }


    /**
     * 前一种方法的逆向思路：如果第i天买连续j天的票（票价x），那么本年度第i天之后的总费用Cost[i] = x + Cost[i + j]。
     * 所以就从后往前推算，如果第i天不旅行，那Cost[i] = Cost[i + 1]，每一次迭代都选择最省钱的方案
     *
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets1(int[] days, int[] costs) {
        //minCost[i]表示本年度第i天之后最少的旅行费用
        int[] minCost = new int[400];
        //标记每一天是否旅行
        boolean[] dayFlag = new boolean[366];
        for (int day : days) {
            dayFlag[day] = true;
        }
        for (int i = dayFlag.length - 1; i > 0; --i) {
            minCost[i] = dayFlag[i]? Math.min(costs[0] + minCost[i + 1], Math.min(costs[1] + minCost[i + 7], costs[2] + minCost[i + 30])) : minCost[i + 1];
        }
        return minCost[1];
    }
}
