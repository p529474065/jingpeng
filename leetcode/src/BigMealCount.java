import java.util.HashMap;
import java.util.Map;

public class BigMealCount {
    /**
    *大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
    *你可以搭配 任意 两道餐品做一顿大餐。
    *给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第i道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 10^9 + 7 取余。
    *注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
    *来源：力扣（LeetCode）
    *链接：https://leetcode-cn.com/problems/count-good-meals
    *著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     **/
    class Solution {
        public int countPairs(int[] deliciousness) {
            final int MOD = 1000000007;
            int maxVal = 0;
            for (int a : deliciousness) {
                maxVal = Math.max(a, maxVal);
            }
            int maxSum = 2* maxVal;
            int pairs = 0;
            Map<Integer, Integer> map = new HashMap<>();
            int length = deliciousness.length;
            for (int i = 0; i < length; i++) {
                int val = deliciousness[i];
                for (int sum = 1; sum <= maxSum; sum <<= 1) {
//                    int count = map.getOrDefault(sum - val, 0);
//                    pairs = (pairs + count) % MOD;
                    pairs += map.getOrDefault(sum - val, 0);
                    if (pairs >= MOD) {
                        pairs -= MOD;
                    }
                }
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
            return pairs;
        }
    }
}
