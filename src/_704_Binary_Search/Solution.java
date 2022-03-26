package _704_Binary_Search;

public class Solution {
    public int search(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;

        while (low <= high) {
            int mid = low + (high - low)/2;
            int midVal = nums[mid];
            if (target < midVal) {
                high = mid - 1;
            } else if (target > midVal) {
                low = mid + 1;
            }  else {
                return -1;
            }
        }
        return -1;
    }
}
