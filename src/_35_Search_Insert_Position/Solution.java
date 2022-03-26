package _35_Search_Insert_Position;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length -1;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        //不会出现low = high && nums[low] = target的情况
        if (nums[low] < target) {
            return low + 1;
        } else {
            return low;
        }
    }

    //缩减问题规模的思想，答案ans不断逼近“大于target的第一个数"
    public int searchInsert2(int[] nums, int target) {
        int low = 0, high = nums.length - 1, ans = nums.length;
        while (low <= high) {
            int mid = ((high - low) >> 1) + low;
            if (target <= nums[mid]) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
