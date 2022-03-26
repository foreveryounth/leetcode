package _15_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (len < 3)
            return ans;
        //对原数组进行排序
        Arrays.sort(nums);

        int c = len - 1;
        for (int a = 0; a < len; a++) {
            if (a > 0 && nums[a] == nums[a - 1])
                continue;
            c = len - 1;
            for (int b = a + 1; b < len; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1])
                    continue;
                for (; c > b; c--) {
                    if (c < len - 1 && nums[c] == nums[c + 1])
                        continue;
                    if (nums[a] + nums[b] + nums[c] == 0) {
                        ans.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    } else if (nums[a] + nums[b] + nums[c] < 0) {
                        break;
                    }
                }
            }
        }
        return ans;
    }

    //代码逻辑控制凌乱
    public List<List<Integer>> threeSum2(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(len < 3)
            return ans;
        Arrays.sort(nums);

        for (int a = 0; a < len; a++) {
            if (a > 0 && nums[a] == nums[a - 1])
                continue;
            int b = a + 1, c = len -1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                if (sum > 0){
                    c--;
                    while (b < c && nums[c + 1] == nums[c])
                        c--;
                } else {
                    if (sum == 0)
                        ans.add(Arrays.asList(nums[a], nums[b], nums[c]));
                    b++;
                    while (b < c && nums[b - 1] == nums[b])
                        b++;
                }
            }
        }
        return ans;
    }
}
