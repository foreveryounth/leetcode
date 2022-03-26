package _278_First_bad_Version;

public class Solution2 {
    boolean versionData[] = {true, true, true};
    boolean isBadVersion(int version){
        return versionData[version];
    }
    public int firstBadVersion(int n) {
        if (isBadVersion(1)) {
            return 1;
        }
        int low = 2, high = n;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (isBadVersion(mid)){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
