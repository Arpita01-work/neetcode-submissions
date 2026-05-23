class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        for(int i = 0; i<height.length; i++){
            int leftMax = 0;
            int rightMax = 0;
            for(int j = 0; j <= i; j++){
                if(height[j] > leftMax){
                    leftMax = height[j];
                }
            }
            for(int k = i; k < n; k++){
                if(height[k] > rightMax){
                    rightMax = height[k];
                }
            }
            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }
}
