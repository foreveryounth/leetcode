package _278_First_bad_Version;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution {
    boolean versionData[] = {true, true, true};
    boolean isBadVersion(int version){
        return versionData[version];
    }
    public int firstBadVersion(int n) {
        if (isBadVersion(1)) {
            return 1;
        }
        int low = 2, high = n;
        while (low <= high) {
            int mid = low + (high - low)/2;
            /*boolean pre = isBadVersion(mid -1);
            boolean cur = isBadVersion(mid);

            if(!pre && !cur) {
                low = mid + 1;
            } else if (pre && cur) {
                high = mid -1;
            } else {
                return mid;
            }
             */
            boolean cur = isBadVersion(mid);
            if (!cur) {
                low = mid + 1;
            } else {
                boolean pre = isBadVersion(mid -1);
                if (pre) {
                    high = mid -1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
