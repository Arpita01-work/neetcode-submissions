class Solution {
    public int findMin(int[] nums) {
        int minElement = nums[0];

        for(int i = 1; i<nums.length; i++){
            if(nums[i] < minElement){
                minElement = nums[i];
            }
        }
        return minElement;
    }
}
