import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    /**
     * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
     * 子数组 是数组的一段连续部分。
     *
     * 示例一：
     * 输入：nums = [1,0,1,0,1], goal = 2
     * 输出：4
     * 解释：
     * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
     *
     * 示例二：
     * 输入：nums = [0,0,0,0,0], goal = 0
     * 输出：15
     *
     * 提示：
     * 1 <= nums.length <= 3 * 10^4
     * nums[i] 不是 0 就是 1
     * 0 <= goal <= nums.length
     */
    class Solution {
        /**
         * 普通双循环法
         * @param nums
         * @param goal
         * @return
         */
        public int numSubarraysWithSum(int[] nums, int goal) {
            int length = nums.length;
            int sum = 0;
            int count = 0;
            for (int i = 0; i < length; i++) {
                sum = 0;
                for (int j = i; sum <= goal && j < length; j++) {
                    sum += nums[j];
                    if (sum == goal) {
                        count++;
                    }
                }
            }
            return count;
        }

        /**
         * 哈希表法
         * @param nums
         * @param goal
         * @return
         */
        public int numSubarraysWithSumHash(int[] nums, int goal) {
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            int count = 0;
            for (int val : nums) {
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                sum += val;
                count += map.getOrDefault(sum - goal, 0);
            }
            return count;
        }

        /**
         * 滑动窗口法
         * @param nums
         * @param goal
         * @return
         */
        public int numSubarraysWithSumSlide(int[] nums, int goal) {
            int left = 0, right = 0;
            int sum1 = 0, sum2 = 0;
            int count = 0;
            int length = nums.length;
            int i = 0;
            while ( i < length) {
                sum1 += nums[i];
                while (left <=i && sum1 > goal) {
                    sum1 -= nums[left];
                    left ++;
                }
                sum2 += nums[i];
                while (right <= i && sum2 >= goal) {
                    sum2 -= nums[right];
                    right ++;
                }
                count += right - left;
                i ++;
            }
            return count;
        }


    }
}
