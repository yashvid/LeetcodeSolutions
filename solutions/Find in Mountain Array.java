/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 


class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
    
        // Find peak index
        int left = 0;
        int right = mountainArr.length() - 1;  // Fixing right pointer to be mountainArr.length() - 1
        int peak = -1;
        
        // Find peak using binary search
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        peak = left;
        
        // Search in the ascending part
        int result = binarySearch(target, mountainArr, 0, peak, true);  // true indicates ascending order
        if (result != -1) {
            return result;  // If target is found in ascending part, return index
        }
        
        // Search in the descending part
        return binarySearch(target, mountainArr, peak + 1, mountainArr.length() - 1, false);  // false for descending order
    }
    
    private int binarySearch(int target, MountainArray mountainArr, int left, int right, boolean ascending) {
        int result = -1; // Variable to store the smallest index
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int value = mountainArr.get(mid);
        
            // Check if the current mid is the target
            if (value == target) {
                result = mid;  // Store the current index
                if (ascending) {
                    right = mid - 1;  // Continue searching in the left half if ascending
                } else {
                    left = mid + 1;   // Continue searching in the right half if descending
                }
            }
            // On the ascending slope
            else if (ascending) {
                if (value < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // On the descending slope
            else {
                if (value > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }     
        return result;  // Return the smallest index found or -1 if not found
    }
}