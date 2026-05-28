class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int l = 0, r = k - 1;

        while(r < nums.length){
            int max = Integer.MIN_VALUE;
            for(int i = l; i<=r; i++){
                max = Math.max(max, nums[i]);
            }
            list.add(max);

            l++;
            r++;
        }
        return list.stream().mapToInt(i -> i).toArray();    }
}
