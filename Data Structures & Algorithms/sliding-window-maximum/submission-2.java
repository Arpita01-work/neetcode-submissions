class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int l = 0, r = k - 1, idx = 0;

        while(r < nums.length){
            int max = Integer.MIN_VALUE;
            for(int i = l; i<=r; i++){
                max = Math.max(max, nums[i]);
            }
            result[idx] = max;
            idx++;

            l++;
            r++;
        }
        return result;
    }
}
