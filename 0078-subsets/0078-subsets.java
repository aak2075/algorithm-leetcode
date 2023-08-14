class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        BT(0, result, nums, new ArrayList<Integer>());
        
        return result;
    }
    
    public void BT(int index, List<List<Integer>> result, int[] nums, List<Integer> letters) {
        if (index == nums.length) {
            result.add(letters);
            return;
        }
        
        List<Integer> tmp1 = new ArrayList<>(letters);
        BT(index + 1, result, nums, tmp1); 
        int n = nums[index];
        List<Integer> tmp2 = new ArrayList<>(letters);
        tmp2.add(n);
        BT(index + 1, result, nums, tmp2);
    }
}