package cn.junwork.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/restore-ip-addresses/description/">93. Restore IP Addresses</a>
 * <pre>
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 *
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * </pre>
 */
public class Q93_RestoreIPAddresses {

    /**
     * 因为“.”的插入位置最多也就 C(11,3) 种，
     * 所以先尝试穷举
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return result;

        int n = s.length() - 1, k = 3;
        int[] dotIndexs = new int[k];
        for (int i = 0; i < dotIndexs.length; ++i) {
            dotIndexs[i] = i + 1;
        }

        for (; ;) {
            String ip = getIp(s, dotIndexs);
            if (ip != null) result.add(ip);

            int i;
            for (i = dotIndexs.length - 1; i >= 0 && (dotIndexs.length - i - 1) + dotIndexs[i] == n; --i);
            if (i < 0) break;

            ++dotIndexs[i];

            for (int j = i + 1; j < dotIndexs.length; ++j) {
                dotIndexs[j] = dotIndexs[j - 1] + 1;
            }
        }

        return result;
    }


    private String getIp(String s, int[] dotIndexs) {
        String b1 = s.substring(0, dotIndexs[0]);
        String b2 = s.substring(dotIndexs[0], dotIndexs[1]);
        String b3 = s.substring(dotIndexs[1], dotIndexs[2]);
        String b4 = s.substring(dotIndexs[2]);

        if (valid(b1) && valid(b2) && valid(b3) && valid(b4)) {
            return b1 + "." + b2 + "." + b3 + "." + b4;
        }
        return null;
    }


    private boolean valid(String b) {
        if (b.charAt(0) == '0' && b.length() > 1) return false;
        int ib = Integer.parseInt(b);
        return 0 <= ib && ib <= 255;
    }
}
